
package org.firstinspires.ftc.teamcode.what_do_you_want_to_call_this;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Autonomous(name = "give_it_a_name")
public class give_it_a_name extends LinearOpMode {
    // Section 1 - Defining Variables (motors,servos etc)

    private DcMotor FL_wheel, BL_wheel, FR_wheel, BR_wheel, Front_feeder, Middle_feeder, Shooter_2, Shooter_1;
    private CRServo outServo;
    private IMU imu_called_bob;


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
        outServo = hardwareMap.get(CRServo.class, "Backfeeder");

        //.setDirection(DcMotorSimple.Direction.REVERSE);
        FL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        BL_wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        Front_feeder.setDirection(DcMotorSimple.Direction.REVERSE);
        outServo.setDirection(DcMotorSimple.Direction.REVERSE);

        imu_called_bob = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
        imu_called_bob.initialize(parameters);

        imu_called_bob.resetYaw();

        waitForStart();
        // Section 3 - Actual Drive Code
        //314159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328

        //collect balls
        forward(-1058, 0.68);
        turning(-90);
        Front_feeder.setPower(1);
        Middle_feeder.setPower(1);
        forward(-1800, 0.68);
        sleep (80);
        Middle_feeder.setPower(0);
        //going to shoot
        forward(1800, 0.68);
        turning(-90);
        forward(2150, 0.68);
        turning(-40);
        forward(-380, 0.68);
        Shooter_1.setPower(1);
        Shooter_2.setPower(1);
        sleep (1000);
        Middle_feeder.setPower(1);
        outServo.setPower(1);
        sleep(4000);
        Middle_feeder.setPower(0);
        Front_feeder.setPower(0);
        outServo.setPower(0);
        Shooter_1.setPower(0);
        Shooter_2.setPower(0);
        sleep (1000);
        //finished shooting, parking
        turning(-50);
        forward(1100, 0.68);
        turning(-90);
        forward(1650, 1);
    }

    public void turning(int target_angle) {
        double current_angle = imu_called_bob.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
        double Kp = 0.008;
        while (Math.abs(current_angle - target_angle) > 10) {
            current_angle = imu_called_bob.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

            double error = current_angle - target_angle;
            FR_wheel.setPower(error * Kp);
            FL_wheel.setPower(-error * Kp);
            BL_wheel.setPower(-error * Kp);
            BR_wheel.setPower(error * Kp);

            telemetry.addData("Angle:", current_angle);
            telemetry.addData("Error:", error);
            telemetry.update();

        }
    }



    public void forward(int distance, double power){


        FL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        FL_wheel.setTargetPosition(distance);
        FR_wheel.setTargetPosition(distance);
        BR_wheel.setTargetPosition(distance);
        BL_wheel.setTargetPosition(distance);


        FL_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL_wheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FL_wheel.setPower(power);
        FR_wheel.setPower(power);
        BR_wheel.setPower(power);
        BL_wheel.setPower(power);

        while (what_do_you_want_to_call_this_function()) {      }

        FL_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL_wheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }



    // boolean = either true or false
    public boolean what_do_you_want_to_call_this_function() {
        return (FL_wheel.isBusy() || FR_wheel.isBusy() || BR_wheel.isBusy() || BL_wheel.isBusy());
    }
}
