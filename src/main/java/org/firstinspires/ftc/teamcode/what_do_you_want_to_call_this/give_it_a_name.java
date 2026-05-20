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

        Front_feeder.setPower(1);
        sleep(1000);
        Front_feeder.setPower(0);

    }
}
