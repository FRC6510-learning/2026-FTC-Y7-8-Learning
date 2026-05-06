package org.firstinspires.ftc.teamcode.minicomp2026;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "")
public class comp_codemini extends OpMode {
    //Seciton 1 - creating variables


    DcMotor FR, FL, BR, BL;
    DcMotor Front_Intake_Right;
    DcMotor Middle_Intake_Left;
    DcMotor Shooter_Right,Shooter_Left;
    CRServo Servo;








    @Override
    public void init(){
        // SEction 2 - assign motors to configuration


        FR = hardwareMap.get(DcMotor.class,"FRApollo 12");
        FL = hardwareMap.get(DcMotor.class,"FLMoonRover");
        BR = hardwareMap.get(DcMotor.class,"BRNeilArmstrong");
        BL = hardwareMap.get(DcMotor.class,"BLArtemis");
        Shooter_Left = hardwareMap.get(DcMotor.class,"Chickedee(Left shooter)");
        Shooter_Right = hardwareMap.get(DcMotor.class,"Chick(right shooter)");
        Front_Intake_Right = hardwareMap.get(DcMotor.class,"Icecube(lower intake right)");
        Middle_Intake_Left = hardwareMap.get(DcMotor.class,"Penguin2 (2nd intake left)");
        Servo = hardwareMap.get(CRServo.class,"Arctic(shooter servo)");


        BR.setDirection(DcMotorSimple.Direction.REVERSE);


    }
    @Override
    public void loop(){
        // Section 3




        if (gamepad1.a) {
            Front_Intake_Right.setPower(1);
        } else{
            Front_Intake_Right.setPower(0);
        }
        if (gamepad1.b) {
            Middle_Intake_Left.setPower(1);
        } else {
            Middle_Intake_Left.setPower(0);
        }


        if (gamepad1.dpad_right) {
            Shooter_Right.setPower(1);
            Shooter_Left.setPower(1);
        } else if(gamepad1.dpad_left) {
            Shooter_Right.setPower(0);
            Shooter_Left.setPower(0);
        } else if(gamepad1.dpad_up){
            Shooter_Right.setPower(0.75);
            Shooter_Left.setPower(0.75);
        } else if(gamepad1.dpad_down){
            Shooter_Right.setPower(0.25);
            Shooter_Left.setPower(0.25);
        }
        if (gamepad1.left_bumper){
            Servo.setPower(1);
        } else if (gamepad1.right_bumper) {
            Servo.setPower(0);
        }


        double forward = gamepad1.left_stick_y * -1;


        double turning = gamepad1.right_stick_x;


        double strafing =  gamepad1.left_stick_x;




        BR.setPower(forward - turning - strafing ); // 1 - 0 = 1 , 1 - 1 = 0,  0 - (-1) = 1
        BL.setPower(forward + turning + strafing );
        FL.setPower(forward + turning - strafing);
        FR.setPower(forward - turning + strafing);



    }
}

