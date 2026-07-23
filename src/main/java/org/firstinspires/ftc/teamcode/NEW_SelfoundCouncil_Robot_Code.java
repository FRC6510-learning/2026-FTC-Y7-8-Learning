package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "selfoundCouncil")
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

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        // Robot drive
        double forward = gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double strafe= gamepad1.left_stick_x;

        frontLeft.setPower(forward+turn+strafe);
        frontRight.setPower(forward-turn-strafe);
        backLeft.setPower(forward+turn-strafe);
        backRight.setPower(forward-turn+strafe);
    }
}
