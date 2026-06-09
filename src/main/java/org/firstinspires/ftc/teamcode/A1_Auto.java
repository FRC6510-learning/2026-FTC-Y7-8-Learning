package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "A1MilkAuto1")
public class A1_Auto extends LinearOpMode {
    private DcMotor lfront, rfront, lback, rback, intake, feeder, lshooter, rshooter;
    private CRServo feeder2;

    double y;
    double x;
    double rx;

    boolean xButton;
    boolean yButton;

    boolean aButton;
    boolean bButton;

    boolean rButton;

    boolean lButton;

    private CRServo servo;

    double denominator;

    @Override
    public void runOpMode() {

        lfront = hardwareMap.get(DcMotor.class, "lfront");
        rfront = hardwareMap.get(DcMotor.class, "rfront");
        lback = hardwareMap.get(DcMotor.class, "lback");
        rback = hardwareMap.get(DcMotor.class, "rback");
        intake = hardwareMap.get(DcMotor.class, "intake");
        feeder = hardwareMap.get(DcMotor.class, "feeder1");
        lshooter = hardwareMap.get(DcMotor.class, "lshooter");
        rshooter=hardwareMap.get(DcMotor.class, "rshooter");
        feeder2 = hardwareMap.get(CRServo.class, "servo");

        lfront.setDirection(DcMotor.Direction.REVERSE);
        lback.setDirection(DcMotor.Direction.REVERSE);

        lfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rfront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rback.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

        forward (-950, -0.7);
        turn (970, 0.5 );
        intake.setPower(1);
        feeder.setPower(1);
        forward( -1600, -0.4);
        feeder.setPower(0);
        intake.setPower(0);
        forward( 950, 0.7);
        turn ( -970, -0.7);
        forward (-900, -0.7);
        turn (1300, 0.5);
        feeder2.setPower(1);
        forward(900, 0.7);
        intake.setPower(1);
        feeder.setPower(1);
        lshooter.setPower(-1);
        rshooter.setPower(-1);
        forward(700, 0.7);
        intake.setPower(1);
        feeder.setPower(1);
        lshooter.setPower(-0.7);
        sleep(3000);
        rshooter.setPower(-0.7);
        sleep(3000);
        feeder.setPower(1);
        sleep(3000);
        forward(-950, -0.7);
        turn(970, 0.7);

    }
    public void forward (int distance, double power) {
        lfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lfront.setTargetPosition(distance);
        lfront.setPower(power);
        lfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rfront.setTargetPosition(distance);
        rfront.setPower(power);
        rfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lback.setTargetPosition(distance);
        lback.setPower(power);
        lback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rback.setTargetPosition(distance);
        rback.setPower(power);
        rback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(lfront.isBusy() || rfront.isBusy() || lback.isBusy() || rback.isBusy()) {}

    }
    public void turn (int distance, double power) {
        lfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rfront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rback.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lfront.setTargetPosition(distance);
        lfront.setPower(power);
        lfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rfront.setTargetPosition(-distance);
        rfront.setPower(-power);
        rfront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lback.setTargetPosition(distance);
        lback.setPower(power);
        lback.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rback.setTargetPosition(-distance);
        rback.setPower(-power);
        rback.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(lfront.isBusy() || rfront.isBusy() || lback.isBusy() || rback.isBusy()) {}
    }
}

