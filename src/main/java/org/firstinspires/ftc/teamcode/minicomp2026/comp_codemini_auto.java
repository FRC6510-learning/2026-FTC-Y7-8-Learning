package org.firstinspires.ftc.teamcode.minicomp2026;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "autocode_minicomp")
public class comp_codemini_auto extends LinearOpMode {

    //Section 1 - creating variables
    DcMotor FR, FL, BR, BL;
    DcMotor Front_Intake_Right;
    DcMotor Middle_Intake_Left;
    DcMotorEx Shooter_Right,Shooter_Left;
    CRServo Servo;

    @Override
    public void runOpMode(){
        //Section 2 - assigning motors to configuration
        FR = hardwareMap.get(DcMotor.class, "FRApollo12");
        FL = hardwareMap.get(DcMotor.class, "FLMoonRover");
        BR = hardwareMap.get(DcMotor.class, "BRNeilArmstrong");
        BL = hardwareMap.get(DcMotor.class, "BLArtemis");
        Shooter_Left = hardwareMap.get(DcMotorEx.class, "Chickedee(Left shooter)");
        Shooter_Right = hardwareMap.get(DcMotorEx.class, "Chick(right shooter)");
        Front_Intake_Right = hardwareMap.get(DcMotor.class, "Icecube(lower intake right)");
        Middle_Intake_Left = hardwareMap.get(DcMotor.class, "Penguin2 (2nd intake left)");
        Servo = hardwareMap.get(CRServo.class, "Arctic(shooter servo)");


        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        Servo.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Right.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        waitForStart();

            //Section 3 - the ACTUAL code
        forward(1200, 0.6);
        sleep(1000);
        turn(980,0.5);
        sleep(1000);
        Front_Intake_Right.setPower(1);
        Middle_Intake_Left.setPower(1);
        sleep(1000);
        forward(-1900,0.4);
        sleep(1000);
        forward(1000,0.6);
        sleep(1000);
        shooter(1900);
        sleep(1000);
        turn(-1009/2,0.6);
        sleep(1000);
        Servo.setPower(1);
        forward(1900,0.5);
        sleep(1700);
        shooter(0);
        forward(-1500,0.5);
        turn(-980,0.5);
        forward(1500,0.5);





    }

    public  void shooter(int power){
        Shooter_Left.setVelocity(power);
        Shooter_Right.setVelocity(power);
    }

    public void forward(int distance, double power) {
        FR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        FR.setTargetPosition(distance);
        FR.setPower(power);

        FL.setTargetPosition(distance);
        FL.setPower(power);

        BR.setTargetPosition(distance);
        BR.setPower(power);

        BL.setTargetPosition(distance);
        BL.setPower(power);

        FR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        while (FR.isBusy() || FL.isBusy() || BR.isBusy() || BL.isBusy()) {

        }



    }
    public void something(int FR_, int FL_, int BR_, int BL_, double power) {
        FR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        FR.setTargetPosition(FR_);
        FR.setPower(power);

        FL.setTargetPosition(FL_);
        FL.setPower(power);

        BR.setTargetPosition(BR_);
        BR.setPower(power);

        BL.setTargetPosition(BL_);
        BL.setPower(power);

        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (FR.isBusy() || FL.isBusy() || BR.isBusy() || BL.isBusy()) {

        }
    }

        public void turn(int distance, double powerforme) {

        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sleep(10);

        BR.setTargetPosition(-distance);
        BL.setTargetPosition(distance);
        FR.setTargetPosition(-distance);
        FL.setTargetPosition(distance);

        BR.setPower(powerforme);
        BL.setPower(powerforme);
        FL.setPower(powerforme);
        FR.setPower(powerforme);

        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (amIbusy()) {       }


    }

    public boolean amIbusy() {
        return ( BR.isBusy() || BL.isBusy() || FR.isBusy() || FL.isBusy());
    }



}