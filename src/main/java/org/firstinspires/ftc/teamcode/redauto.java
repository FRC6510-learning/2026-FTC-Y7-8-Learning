package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "")
public class redauto extends LinearOpMode {

    // Section 1 : variables
    private DcMotor front_left, front_right, back_right, back_left;
    private DcMotor left_flywheel, right_flywheel, conveyor, intake;
    private CRServo feeder;


    @Override
    public void runOpMode() {

        // Section 2 : configuration
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        back_left = hardwareMap.get(DcMotor.class, "back_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        intake = hardwareMap.get(DcMotor.class, "intake");
        conveyor = hardwareMap.get(DcMotor.class, "conveyor");
        feeder = hardwareMap.get(CRServo.class, "feeder");
        left_flywheel = hardwareMap.get(DcMotor.class, "topshooter");
        right_flywheel = hardwareMap.get(DcMotor.class, "bottomshooter");

        front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        back_left.setDirection(DcMotorSimple.Direction.REVERSE);
        feeder.setDirection(CRServo.Direction.REVERSE);
        conveyor.setDirection(DcMotorSimple.Direction.REVERSE);
        left_flywheel.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();
        // Section 3 : code
        //drive forward from edge of white triangle tape
        forward(1200, 0.8);
        //turn right
        turn(-1000, 0.8);
        // intake and conveyor turns on
        intake.setPower(1);
        conveyor.setPower(1);
        //drive forward
        forward(1000, 0.2);
        //drive back
        forward(-1000, 0.5);
        //intake turn off
        intake.setPower(0);
        //turn right
        turn(-1000,0.8);
        //outtake turn on
        left_flywheel.setPower(1);
        right_flywheel.setPower(1);
        //drive back
        forward(-2500, 0.2);
        //turn right
        turn(-300, 0.4);
        //feeder turn on
        feeder.setPower(1);
        sleep(5000);
        //outtake turn off
        right_flywheel.setPower(0);
        left_flywheel.setPower(0);
        conveyor.setPower(1);
        //fix wheel, and flywheel - too much friction
        //refine code next time



    }



    void forward(int distance, double power) {


        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_left.setTargetPosition(-distance);
        front_right.setTargetPosition(-distance);
        back_left.setTargetPosition(-distance);
        back_right.setTargetPosition(-distance);

        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front_left.setPower(power);
        front_right.setPower(power);
        back_right.setPower(power);
        back_left.setPower(power);

        while (front_left.isBusy() || front_right.isBusy() || back_left.isBusy() || back_right.isBusy()) {
            telemetry.addData("front left cond", front_left.isBusy());
            telemetry.update();
        }

    }

    void turn(int distance, double power) {


        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_left.setTargetPosition(+distance);
        front_right.setTargetPosition(-distance);
        back_left.setTargetPosition(+distance);
        back_right.setTargetPosition(-distance);

        front_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        front_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back_right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front_left.setPower(power);
        front_right.setPower(power);
        back_right.setPower(power);
        back_left.setPower(power);

        while (front_left.isBusy() || front_right.isBusy() || back_left.isBusy() || back_right.isBusy()) {
            telemetry.addData("front left cond", front_left.isBusy());
            telemetry.update();
        }
        //chelsea wang is a bigback 67 negative aura not sigma skibidi
        //alyssa is sigma
        //zoey pishes me auff
        //hayley is a decent canoeing partner
        //jadyn is a fat pig oink oink
        //bianca is a moon lookalike
        //chelsea is a stick insect matching with jimmy
        //noooooo i miss camp wahhhhhhh
        //i bet alyssa cant make a single shot myahhahahahahah
        //pinky up
        //agabaga
    }

}
