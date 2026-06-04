package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class Theotherroomauto extends LinearOpMode {

    DcMotor backbob, middlebob, shooterbobl, shooterbobr;
    DcMotor FR, FL, BR, BL;
    CRServo frontbob;

    @Override
    public void runOpMode() {
        backbob = hardwareMap.get(DcMotor.class, "back intake");
        middlebob = hardwareMap.get(DcMotor.class, "middle intake");
        frontbob = hardwareMap.get(CRServo.class, "top intake servo");
        shooterbobl = hardwareMap.get(DcMotor.class, "shooter left");
        shooterbobr = hardwareMap.get(DcMotor.class, "shooter right");
        FR = hardwareMap.get(DcMotor.class, "front right");
        FL = hardwareMap.get(DcMotor.class, "front left");
        BR = hardwareMap.get(DcMotor.class, "back right");
        BL = hardwareMap.get(DcMotor.class, "back left");


        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();


        FR.setTargetPosition(100000);
        FR.setPower(1);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        FL.setTargetPosition(100000);
        FL.setPower(1);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BR.setTargetPosition(100000);
        BR.setPower(1);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BL.setTargetPosition(100000);
        BL.setPower(1);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void forward(int distance, double power) {
        FR.setTargetPosition(100000);
        FR.setPower(1);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        FL.setTargetPosition(100000);
        FL.setPower(1);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BR.setTargetPosition(100000);
        BR.setPower(1);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BL.setTargetPosition(100000);
        BL.setPower(1);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
}




