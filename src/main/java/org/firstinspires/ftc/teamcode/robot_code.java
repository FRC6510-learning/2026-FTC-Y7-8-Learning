package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp (name = "a11")
public class robot_code extends OpMode {

    private DcMotor frontLeft, frontRight, backRight, backLeft;
    private DcMotor bottomShooter, topShooter, middleFeeder, frontFeeder;
    private CRServo topFeeder;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontleftwheel");
        frontRight = hardwareMap.get(DcMotor.class, "frontrightwheel");
        backLeft = hardwareMap.get(DcMotor.class, "backleftwheel");
        backRight = hardwareMap.get(DcMotor.class, "backrightwheel");
        frontFeeder = hardwareMap.get(DcMotor.class, "frontfeeder");
        middleFeeder = hardwareMap.get(DcMotor.class, "middlefeeder");
        topFeeder = hardwareMap.get(CRServo.class, "topfeederservo");
        topShooter = hardwareMap.get(DcMotor.class, "topshooter");
        bottomShooter = hardwareMap.get(DcMotor.class, "bottomshooter");
    }

    @Override
    public void loop() {
        if (gamepad1.right_trigger>0.5) {
            // turn on front feeder motor
            frontFeeder.setPower(1);
            middleFeeder.setPower(-1);
        }
        else {
            frontFeeder.setPower(0);
            middleFeeder.setPower(0);
        }

        telemetry.addData("Dpad Up", gamepad1.dpad_up);
        if (gamepad1.dpad_up){
            // TODO FIX turn on top feeder motor
            topFeeder.setPower(1);
        }
        else {
            frontFeeder.setPower(0);
        }

        if (gamepad1.left_bumper) {
            // turn on top top shooter,bottom shooter motors
            topShooter.setPower(-0.7);
            bottomShooter.setPower(1);
        }
        else {
            topShooter.setPower(0);
            bottomShooter.setPower(0);
        }
    }
}
