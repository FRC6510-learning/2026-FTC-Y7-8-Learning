package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "rice_fc")
public class NEW_RICE_FC extends OpMode {

    DcMotor lf_motor, lb_motor, rf_motor, rb_motor;
    IMU imu;
    DcMotor intake;

    double drive_power;

    @Override
    public void init(){

        ///////////////////////drivetrain///////////
        lf_motor = hardwareMap.get(DcMotor.class, "lf_motor");
        lb_motor = hardwareMap.get(DcMotor.class, "lb_motor");
        rf_motor = hardwareMap.get(DcMotor.class, "rf_motor");
        rb_motor = hardwareMap.get(DcMotor.class, "rb_motor");

        lb_motor.setDirection(DcMotorSimple.Direction.REVERSE);
        lf_motor.setDirection(DcMotorSimple.Direction.REVERSE);

        /////////////telemetry///////////////
        imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.RIGHT));

        imu.initialize(parameters);

        //////////////intake////////////////////
        intake = hardwareMap.get(DcMotor.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

        double robot_heading =  imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double forward = -gamepad1.left_stick_y; // y
        double turn = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x; // x

        double rotForward = strafe * Math.sin(-robot_heading) + forward * Math.cos(-robot_heading);
        double rotStrafe = strafe * Math.cos(-robot_heading) - forward * Math.sin(-robot_heading);

        lf_motor.setPower(drive_power*(rotForward + turn + rotStrafe));
        lb_motor.setPower(drive_power*(rotForward + turn - rotStrafe));
        rf_motor.setPower(drive_power*(rotForward - turn - rotStrafe));
        rb_motor.setPower(drive_power*(rotForward - turn + rotStrafe));


        if (gamepad1.right_bumper) {
            drive_power = 0.9;
        } else {
            drive_power = 0.4;
        }
        if (gamepad1.start) {
            imu.resetYaw();
        }

        if (gamepad2.right_bumper) {
            intake.setPower(0.8);
        }
         else {
             intake.setPower(0);
        }
         if (gamepad2.left_bumper) {
             intake.setPower(-1);
         }

        telemetry.addData("imu", robot_heading);
        telemetry.update();

    }
}
