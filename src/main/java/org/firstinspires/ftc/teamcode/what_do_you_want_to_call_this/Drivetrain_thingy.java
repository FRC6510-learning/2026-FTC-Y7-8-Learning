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

@TeleOp(name = "a6drivetraincode")
public class Drivetrain_thingy extends OpMode {
    // Section 1
    private DcMotor FL_wheel, BL_wheel, FR_wheel, BR_wheel;

    double aname = 0.28;

    @Override
    public void init(){

        // Section 2
        FL_wheel = hardwareMap.get(DcMotor.class, "FLwheel");
        BL_wheel = hardwareMap.get(DcMotor.class, "BLwheel");
        FR_wheel = hardwareMap.get(DcMotor.class, "FRwheel");
        BR_wheel = hardwareMap.get(DcMotor.class, "BRwheel");

        //.setDirection(DcMotorSimple.Direction.REVERSE);
        FL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        BL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);

        FL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
    @Override
    public void loop() {

        double forward = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double side = gamepad1.left_stick_x;

        if (gamepad1.right_bumper) {
            aname = 0.2;
        } else {
            aname = 1;
        }


        FR_wheel.setPower(aname*(-forward + turn + side));
        BR_wheel.setPower(aname*(-forward + turn - side));
        FL_wheel.setPower(aname*(-forward - turn + side));
        BL_wheel.setPower(aname*(-forward - turn - side));





    }

}

