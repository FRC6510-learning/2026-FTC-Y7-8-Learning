package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class A11_auto extends LinearOpMode {

    DcMotor frontLeft, frontRight, backRight, backLeft;
    DcMotor bottomShooter, topShooter, middleFeeder, frontFeeder;
    CRServo topFeeder;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontleftwheel");
        frontRight = hardwareMap.get(DcMotor.class, "frontrightwheel");
        backLeft = hardwareMap.get(DcMotor.class, "backleftwheel");
        backRight = hardwareMap.get(DcMotor.class, "backrightwheel");
        frontFeeder = hardwareMap.get(DcMotor.class, "frontfeeder");
        middleFeeder = hardwareMap.get(DcMotor.class, "middlefeeder");
        topFeeder = hardwareMap.get(CRServo.class, "topfeederservo");
        topShooter = hardwareMap.get(DcMotor.class, "topshooter");
        bottomShooter = hardwareMap.get(DcMotor.class, "bottomshooter");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();




        int result = jenniffer(8);
    }

    public int jenniffer(int x) {
        int y = 3 * x;
        return y;
    }

    public void forward(int distance, double power) {
        frontLeft.setTargetPosition(1000);
        frontLeft.setPower(1);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower(1);
        frontRight.setTargetPosition(1000);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeft.setPower(1);
        backLeft.setTargetPosition(1000);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backRight.setPower(1);
        backRight.setTargetPosition(1000);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
}
