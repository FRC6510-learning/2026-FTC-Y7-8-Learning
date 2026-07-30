package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "selfoundCouncil 5")
public class NEW_SelfoundCouncil_Robot_Code extends OpMode {
    // Declare Variables
    private DcMotor frontLeft, frontRight, backRight, backLeft;

    @Override
    public void init() {
        // Initialise variables
        frontLeft = hardwareMap.get(DcMotor.class, "frontleftwheel");
        frontRight = hardwareMap.get(DcMotor.class, "frontrightwheel");
        backLeft = hardwareMap.get(DcMotor.class, "backleftwheel");
        backRight = hardwareMap.get(DcMotor.class, "backrightwheel");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        // Robot drive
        double forward = gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double strafe= gamepad1.left_stick_x;

        double SPEED = 0.5;

        frontLeft.setPower((forward+turn-strafe)*SPEED);
        frontRight.setPower((forward-turn+strafe)*SPEED);
        backLeft.setPower((forward+turn+strafe)*SPEED);
        backRight.setPower((forward-turn-strafe)*SPEED);
    }
}
