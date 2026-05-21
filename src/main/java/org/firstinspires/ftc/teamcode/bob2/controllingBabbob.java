package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(group = "", name = "the best code that doesn't make any sense 3")
public class controllingBabbob extends OpMode {
    // Section 1 : defining variables
    DcMotor backbob, middlebob, shooterbobl, shooterbobr;

    DcMotor FR, FL, BR, BL;
    CRServo frontbob;




    @Override
    public void init(){
        // Section 2 configurating bobd
        backbob = hardwareMap.get(DcMotor.class, "back intake");
        middlebob = hardwareMap.get(DcMotor.class, "middle intake");
        frontbob = hardwareMap.get(CRServo.class, "top intake servo");
        shooterbobl = hardwareMap.get(DcMotor.class, "shooter left");
        shooterbobr = hardwareMap.get(DcMotor.class, "shooter right");
        FR = hardwareMap.get(DcMotor.class, "front right");
        FL = hardwareMap.get(DcMotor.class, "front left");
        BR = hardwareMap.get(DcMotor.class, "back right");
        BL = hardwareMap.get(DcMotor.class, "back left");

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);


    }
    @Override
    public void loop(){
        // Section 3 : repeating bob

        telemetry.addData("Servo Power", frontbob.getPower());

        if (gamepad1.a) {
            backbob.setPower(-1);
            middlebob.setPower(-1);
            frontbob.setPower(1);
        } else if (gamepad1.b) {
            backbob.setPower(1);
            middlebob.setPower(1);
            frontbob.setPower(-1);
        }
        else {
            backbob.setPower(0);
            middlebob.setPower(0);
            frontbob.setPower(0);
        }
        if (gamepad1.y) {
            shooterbobl.setPower(-0.9);
            shooterbobr.setPower(-0.9);
        } else if (gamepad1.x) {
            shooterbobl.setPower(-0.0);
            shooterbobr.setPower(0.0);
        }

        double left_y = gamepad1.left_stick_y;
        double left_x = gamepad1.left_stick_x;
        double right_x = gamepad1.right_stick_x;


//        FR.setPower(left_y);
//        FL.setPower(left_y);
//        BR.setPower(left_y);
//        BL.setPower(left_y);

//        FR.setPower(left_x);
//        FL.setPower(-left_x);
//        BR.setPower(-left_x);
//        BL.setPower(left_x);

        FR.setPower(left_y + left_x + right_x);
        FL.setPower(left_y - left_x - right_x);
        BR.setPower(right_x + left_y - left_x);
        BL.setPower(-right_x + left_y + left_x);

        telemetry.update();
    }
}
