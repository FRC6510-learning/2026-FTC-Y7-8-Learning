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

        forward(-1000, -0.5);

        turning(-1000, -0.5);


        intakes(-1);
        frontbob.setPower(1);


        forward(-1000, -0.5 );
        forward(4000, 0.5);

        turning(1000, 0.5);

        forward(1500,0.5);

        turning(55,0.5);

        shooterbobl.setPower(1);
        shooterbobr.setPower(1);

        intakes(-1);







        //int bob = jennifferr(10);

    }

//    public int jennifferr(int x) {
//        int y = x * 3;
//        return y;
//    }
    public void intakes(double powerbob){
        frontbob.setPower(powerbob);
        middlebob.setPower(powerbob);
        backbob.setPower(powerbob);
    }
    public void forward(int distance, double power) {

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        FR.setTargetPosition(distance);
        FR.setPower(power);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        FL.setTargetPosition(distance);
        FL.setPower(power);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BR.setTargetPosition(distance);
        BR.setPower(power);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BL.setTargetPosition(distance);
        BL.setPower(power);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (BL.isBusy() || BR.isBusy() || FR.isBusy() || FL.isBusy()) {
        }

    }

    public void turning(int distance, double power) {

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        FR.setTargetPosition(-distance);
        FR.setPower(-power);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        FL.setTargetPosition(distance);
        FL.setPower(power);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BR.setTargetPosition(-distance);
        BR.setPower(-power);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        BL.setTargetPosition(distance);
        BL.setPower(power);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (BL.isBusy() || BR.isBusy() || FR.isBusy() || FL.isBusy()) {
        }


    }


}















   //Jennifer function



