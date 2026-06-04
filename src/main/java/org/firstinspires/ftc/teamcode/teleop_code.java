package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name = "a10")
public class teleop_code extends OpMode {

    // Section 1 : naming variables

    private DcMotor front_left, front_right, back_right, back_left;
    private DcMotor left_flywheel, right_flywheel, conveyor, intake;
    private CRServo feeder;
    boolean power = false;

    @Override
    public void init() {

        // section 2 : connecting ports :)))))))))))))

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
    }

    @Override
    public void loop() {

        // Section 3 : actual code

        if (gamepad1.left_bumper) {
            intake.setPower(1);
            conveyor.setPower(1);
        } else if (gamepad1.left_trigger > 0.5) {
            intake.setPower(-1);
            conveyor.setPower(-1);
        } else {
            intake .setPower(0);
            conveyor .setPower(0);
        }

        telemetry.addData("Dpad up", gamepad1.dpad_up);
        if (gamepad1.dpad_up){
            feeder.setPower(1);
        } else if(gamepad1.dpad_down){
            feeder.setPower(-1);
        } else {
            feeder.setPower(0);
        }


        boolean current_state = gamepad1.rightBumperWasPressed();

        if (current_state){
            power = !power;
        }

        if (power) {
            // turn on top top shooter,bottom shooter motors
            left_flywheel.setPower(-1);
            right_flywheel.setPower(1);
        }
        else {
            left_flywheel.setPower(0);
            right_flywheel.setPower(0);
        }

        double forward = gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double strafe= gamepad1.left_stick_x;

        front_left.setPower(forward+turn-strafe);
        front_right.setPower(forward-turn+strafe);
        back_left.setPower(forward+turn+strafe);
        back_right.setPower(forward-turn-strafe);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
