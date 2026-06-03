package org.firstinspires.ftc.teamcode.what_do_you_want_to_call_this;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "a6ArBotcode")
public class Aname extends OpMode {
    // Section 1
    private DcMotor FL_wheel, BL_wheel, FR_wheel, BR_wheel, Front_feeder, Middle_feeder, Shooter_2, Shooter_1;
    private CRServo Servo;
    double aname = 0.28;

    private IMU imu_called_bob;
    @Override
    public void init() {
        // Section 2

        FL_wheel = hardwareMap.get(DcMotor.class, "FLwheel");
        BL_wheel = hardwareMap.get(DcMotor.class, "BLwheel");
        FR_wheel = hardwareMap.get(DcMotor.class, "FRwheel");
        BR_wheel = hardwareMap.get(DcMotor.class, "BRwheel");
        Middle_feeder = hardwareMap.get(DcMotor.class, "Middlefeeder");
        Front_feeder = hardwareMap.get(DcMotor.class, "Frontfeeder");
        Shooter_1 = hardwareMap.get(DcMotor.class, "Shooter1");
        Shooter_2 = hardwareMap.get(DcMotor.class, "Shooter2");
        Servo = hardwareMap.get(CRServo.class, "Backfeeder");

        //.setDirection(DcMotorSimple.Direction.REVERSE);
        FL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        BL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);

        FL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        imu_called_bob = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
        imu_called_bob.initialize(parameters);

        imu_called_bob.resetYaw();
    }
    @Override
    public void loop() {
        if (gamepad1.a) {
            Front_feeder.setPower(-1);
            Middle_feeder.setPower(1);
        } else if (gamepad1.y) {
            Middle_feeder.setPower(-1);
            Servo.setPower(1);
        }
        else {
            Front_feeder.setPower(0);
            Middle_feeder.setPower(0);
        }


        if (gamepad1.b) {
            Servo.setPower(-1);
        } else {
            Servo.setPower(0);
        }

        if (gamepad1.dpad_up) {
            Shooter_1.setPower(1);
            Shooter_2.setPower(1);
        } else if (gamepad1.dpad_down){
            Shooter_1.setPower(0);
            Shooter_2.setPower(0);
        }



        double forward = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double side = gamepad1.left_stick_x;

        if (gamepad1.right_bumper) {
            aname = 0.2;
        } else {
            aname = 1;
        }


        FR_wheel.setPower(aname*(forward + turn + side));
        BR_wheel.setPower(aname*(forward + turn - side));
        FL_wheel.setPower(aname*(forward - turn - side));
        BL_wheel.setPower(aname*(forward - turn + side));


        // you told me to name it something and something else
        //
        double current_angle = imu_called_bob.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        telemetry.addData("something", "something else");
        telemetry.addData("Front right position", FR_wheel.getCurrentPosition());
        telemetry.addData("Back right position", BR_wheel.getCurrentPosition());
        telemetry.addData("Front Left position", FL_wheel.getCurrentPosition());
        telemetry.addData("Back Left position", BL_wheel.getCurrentPosition());
        telemetry.addData("imu pos", current_angle);
        telemetry.update();



    }

}

