package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp()
public class thecodedrivecode extends OpMode {

    DcMotor frontLeft, frontRight, backLeft, backRight ;


    @Override
    public void init(){

        frontLeft = hardwareMap.get(DcMotor.class, "fl") ;
        frontRight = hardwareMap.get(DcMotor.class, "fr") ;
        backLeft = hardwareMap.get(DcMotor.class, "bl") ;
        backRight = hardwareMap.get(DcMotor.class, "br") ;

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);


    }
    @Override
    public void loop(){

        double a = -gamepad1.left_stick_y; //
        double b = gamepad1.right_stick_x;
        double x = gamepad1.left_stick_x;

        frontLeft.setPower(a + b + x);
        frontRight.setPower(a - b - x);
        backLeft.setPower(a + b - x);
        backRight.setPower(a - b + x);



    }
}
