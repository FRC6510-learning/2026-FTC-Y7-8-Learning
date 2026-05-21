package org.firstinspires.ftc.teamcode.minicomp2026;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "autocode_minicomp")
public class comp_codemini_auto extends LinearOpMode {

    //Section 1 - creating variables
    DcMotor FR, FL, BR, BL;
    DcMotor Front_Intake_Right;
    DcMotor Middle_Intake_Left;
    DcMotor Shooter_Right,Shooter_Left;
    CRServo Servo;

    @Override
    public void runOpMode(){
        //Section 2 - assigning motors to configuration
        FR = hardwareMap.get(DcMotor.class, "FRApollo12");
        FL = hardwareMap.get(DcMotor.class, "FLMoonRover");
        BR = hardwareMap.get(DcMotor.class, "BRNeilArmstrong");
        BL = hardwareMap.get(DcMotor.class, "BLArtemis");
        Shooter_Left = hardwareMap.get(DcMotor.class, "Chickedee(Left shooter)");
        Shooter_Right = hardwareMap.get(DcMotor.class, "Chick(right shooter)");
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
        turn(950,0.8);

        forward(1000, 0.5);
        sleep(1000);
        turn(950,0.8);



    }

    public void forward(int distance, double power) {
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR.setTargetPosition(distance);
        FR.setPower(power);

        FL.setTargetPosition(distance);
        FL.setPower(power);

        BR.setTargetPosition(distance);
        BR.setPower(power);

        BL.setTargetPosition(distance);
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