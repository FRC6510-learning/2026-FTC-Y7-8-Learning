package org.firstinspires.ftc.teamcode.minicomp2026;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;




@TeleOp(name = "")
public class comp_codemini extends OpMode {
    //Seciton 1 - creating variables


    DcMotor FR, FL, BR, BL;
    DcMotor Front_Intake_Right;
    DcMotor Middle_Intake_Left;
    DcMotorEx Shooter_Right,Shooter_Left;
    CRServo Servo;

    double FPS = 0.5;

hi








    @Override
    public void init(){
        // Section 2 - assign motors to configuration


        FR = hardwareMap.get(DcMotor.class,"FRApollo12");
        FL = hardwareMap.get(DcMotor.class,"FLMoonRover");
        BR = hardwareMap.get(DcMotor.class,"BRNeilArmstrong");
        BL = hardwareMap.get(DcMotor.class,"BLArtemis");
        Shooter_Left = hardwareMap.get(DcMotorEx.class,"Chickedee(Left shooter)");
        Shooter_Right = hardwareMap.get(DcMotorEx.class,"Chick(right shooter)");
        Front_Intake_Right = hardwareMap.get(DcMotor.class,"Icecube(lower intake right)");
        Middle_Intake_Left = hardwareMap.get(DcMotor.class,"Penguin2 (2nd intake left)");
        Servo = hardwareMap.get(CRServo.class,"Arctic(shooter servo)");




        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        Servo.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Right.setDirection(DcMotorSimple.Direction.REVERSE);

        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }
    @Override
    public void loop(){
        // Section 3 - the ACTUAL code




        if (gamepad2.left_bumper) {
            Front_Intake_Right.setPower(1);
            Middle_Intake_Left.setPower(1);

        } else{
            Front_Intake_Right.setPower(0);
            Middle_Intake_Left.setPower(0);
        }


        if (gamepad2.dpad_right) {
            Shooter_Right.setVelocity(1900);
            Shooter_Left.setVelocity(1900);
        } else if(gamepad2.dpad_left) {
            Shooter_Right.setVelocity(1500);
            Shooter_Left.setVelocity(1500);
        } else if(gamepad2.dpad_up){
            Shooter_Right.setVelocity(1000);
            Shooter_Left.setVelocity(1000);
        } else if(gamepad2.dpad_down){
            Shooter_Right.setVelocity(0);
            Shooter_Left.setVelocity(0);
        }
        if (gamepad2.x){
            Servo.setPower(1);
        } else if (gamepad2.y) {
            Servo.setPower(0);
        }

        double forward = -gamepad1.left_stick_y;
        double turning = gamepad1.right_stick_x;
        double strafing =  -gamepad1.left_stick_x;

        BR.setPower((forward - turning - strafing)); // 1 - 0 = 1 , 1 - 1 = 0,  0 - (-1) = 1
        BL.setPower((forward + turning + strafing));
        FL.setPower((forward + turning - strafing));
        FR.setPower((forward - turning + strafing));

//        if (gamepad1.left_trigger_pressed){
//            FPS += 0.1;
//        };


        telemetry.addData("Front Right" , FR.getCurrentPosition());
        telemetry.addData("Front Left" , FL.getCurrentPosition());
        telemetry.addData("Back Right" , BR.getCurrentPosition());
        telemetry.addData("Back Left" , BL.getCurrentPosition());
        telemetry.addData("Power", BL.getPower());
        telemetry.addData("leftshooter", Shooter_Left.getVelocity());
        telemetry.addData("rightshooter",Shooter_Right.getVelocity());
        telemetry.update();





    }
}

