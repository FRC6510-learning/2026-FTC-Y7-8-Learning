package org.firstinspires.ftc.teamcode.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="a4_auto_code", group="2")

public class Auto_Robot_Code extends LinearOpMode
{
    //Setup

    private DcMotor FR, FL, BR, BL, I, PF, SL, SR;
    private CRServo F;

    public void move(int distance, double speed){
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR.setTargetPosition(distance);
        FL.setTargetPosition(distance);
        BR.setTargetPosition(distance);
        BL.setTargetPosition(distance);

        FR.setPower(speed);
        FL.setPower(speed);
        BR.setPower(speed);
        BL.setPower(speed);


        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(FR.isBusy() || FL.isBusy() || BR.isBusy() || BL.isBusy()) {}


    }

    public void turn(int distance, double speed){
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR.setTargetPosition(distance);
        FL.setTargetPosition(-distance);
        BR.setTargetPosition(distance);
        BL.setTargetPosition(-distance);

        FR.setPower(speed);
        FL.setPower(-speed);
        BR.setPower(speed);
        BL.setPower(-speed);


        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(FR.isBusy() || FL.isBusy() || BR.isBusy() || BL.isBusy()) {}
    }

    @Override
    public void runOpMode(){
        //Auto Code
        FR = hardwareMap.get(DcMotor.class,"FR");
        FL = hardwareMap.get(DcMotor.class,"FL");
        BR = hardwareMap.get(DcMotor.class,"BR");
        BL = hardwareMap.get(DcMotor.class,"BL");
        I = hardwareMap.get(DcMotor.class,"I");
        PF = hardwareMap.get(DcMotor.class,"PF");
        SL = hardwareMap.get(DcMotor.class,"SL");
        SR = hardwareMap.get(DcMotor.class,"SR");

        F = hardwareMap.get(CRServo.class,"F");

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        //Auto program

        move(1000, 0.7);
        turn(1000, 0.7);
        I.setPower(-1);
        PF.setPower(-1);
        move(1750, 1);
        I.setPower(0);
        PF.setPower(0);
        move(-2000, 1);
        turn(1000, 0.7);
        move(-2000, 1);
        turn(500, 0.7);
        move(-2000, 1);

        // turn shooter
        sleep(1000);
        F.setPower(1);
        SR.setPower(1);
        SL.setPower(1);

        // turn shooter off

    }
}