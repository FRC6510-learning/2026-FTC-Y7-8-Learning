package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "baked_not_fried")
public class NEW_Baked_Not_Fried extends OpMode {
    // 1 - declare variables

    DcMotor RF, RB, LF, LB;

    IMU imu;

    @Override
    public void init(){
        // 2 - configure motors

        RF = hardwareMap.get(DcMotor.class, "rf");
        RB = hardwareMap.get(DcMotor.class, "rb");
        LF = hardwareMap.get(DcMotor.class, "lf");
        LB = hardwareMap.get(DcMotor.class, "lb");

        imu = hardwareMap.get(IMU.class, "imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
// Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        RF.setDirection(DcMotorSimple.Direction.REVERSE);
        RB.setDirection(DcMotorSimple.Direction.REVERSE);
        LF.setDirection(DcMotorSimple.Direction.FORWARD);
        LB.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop(){
        // 3 - actual drive code

        double move = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;
        double direction = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double RotStrafe = strafe * Math.cos(-direction) - move * Math.sin(-direction);
        double RotMove = strafe * Math.sin(-direction) + move * Math.cos(-direction);

        RF.setPower(RotMove - turn - RotStrafe);
        RB.setPower(RotMove - turn +  RotStrafe);
        LF.setPower(RotMove + turn + RotStrafe);
        LB.setPower(RotMove + turn - RotStrafe);


        if (gamepad1.start){
            imu.resetYaw();
        }


        telemetry.addData("imu", imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES));
        telemetry.update();

    }


}
