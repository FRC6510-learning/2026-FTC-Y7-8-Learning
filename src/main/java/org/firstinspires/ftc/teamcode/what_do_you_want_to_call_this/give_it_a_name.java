package org.firstinspires.ftc.teamcode.what_do_you_want_to_call_this;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "")
public class give_it_a_name extends LinearOpMode {
    // Section 1 - Defining Variables (motors,servos etc)

    private DcMotor FL_wheel, BL_wheel, FR_wheel, BR_wheel, Front_feeder, Middle_feeder, Shooter_2, Shooter_1;
    private CRServo Servo;

    @Override
    public void runOpMode(){
        // Section 2 - Linking Configuration to the motor

        FL_wheel = hardwareMap.get(DcMotor.class, "FLwheel");
        BL_wheel = hardwareMap.get(DcMotor.class, "BLwheel");
        FR_wheel = hardwareMap.get(DcMotor.class, "FRwheel");
        BR_wheel = hardwareMap.get(DcMotor.class, "BRwheel");
        Middle_feeder = hardwareMap.get(DcMotor.class, "Middlefeeder");
        Front_feeder = hardwareMap.get(DcMotor.class, "Frontfeeder");
        Shooter_1 = hardwareMap.get(DcMotor.class, "Shooter1");
        Shooter_2 = hardwareMap.get(DcMotor.class, "Shooter2");
        Servo = hardwareMap.get(CRServo.class, "Backfeeder");

        //.setDirection(DcMotorSimple.Direction.REVERSE);
        FL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        BL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        // Section 3 - Actual Drive Code

        a_name_for_driving_forwards(3000, 0.8);
        a_name_for_driving_forwards(-1000,0.5);

    }

    public void a_name_for_driving_forwards(int distance, double are_you_waiting_for_me_to_say_something){

        FR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR_wheel.setTargetPosition(distance);
        FL_wheel.setTargetPosition(distance);
        BL_wheel.setTargetPosition(distance);
        BL_wheel.setTargetPosition(distance);

        FR_wheel.setPower(are_you_waiting_for_me_to_say_something);
        FL_wheel.setPower(are_you_waiting_for_me_to_say_something);
        BR_wheel.setPower(are_you_waiting_for_me_to_say_something);
        BL_wheel.setPower(are_you_waiting_for_me_to_say_something);

        FR_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (wdywctf()) {     }

    }

    public boolean wdywctf(){
        return FR_wheel.isBusy() || FL_wheel.isBusy() || BR_wheel.isBusy() || BL_wheel.isBusy();
    }

}
