package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(group = "", name = "the best code that doesn't make any sense 2")
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

        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);


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


        FR.setPower(gamepad1.left_stick_y);
        FL.setPower(gamepad1.left_stick_y);
        BR.setPower(gamepad1.left_stick_y);
        BL.setPower(gamepad1.left_stick_y);

        telemetry.update();
    }
}
