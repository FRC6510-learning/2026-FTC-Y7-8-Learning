import static java.lang.Math.abs;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@Autonomous(name = "a5robotcode_auto_fs")
public class Robot_code_auto extends LinearOpMode {
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight, secondfeeder,  firstfeeder;
    private CRServo Servo;
    private DcMotorEx frontshooter, backshooter;
    private IMU imu;

    private double Threshold = 0.05;


    @Override
    public void runOpMode() {
        FrontRight = hardwareMap.get(DcMotor .class, "FRW");
        FrontLeft = hardwareMap.get(DcMotor.class, "FLW");
        BackLeft = hardwareMap.get(DcMotor.class, "BLW");
        BackRight = hardwareMap.get(DcMotor.class, "BRW");
        firstfeeder = hardwareMap.get(DcMotor.class, "FF");
        secondfeeder = hardwareMap.get(DcMotor.class, "SF");
        frontshooter = hardwareMap.get(DcMotorEx.class, "FS");
        backshooter = hardwareMap.get(DcMotorEx.class, "BS");
        Servo = hardwareMap.get(CRServo.class, "Servo");
        imu = hardwareMap.get(IMU.class,"imu");

        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));

        imu.initialize(parameters);

        imu.resetYaw();

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        waitForStart();

        forward(1100, 0.6);

        Turn(90);

        firstfeeder.setPower(-0.7);

        secondfeeder.setPower(-0.7);


        forward(-1900, 0.5);
        Servo.setPower(0);
        sleep(1000);
        Servo.setPower(0);
        secondfeeder.setPower(0);


        forward(2100, 0.6);
        Turn(0);
        forward(2000,0.6);
        Turn(45);



        frontshooter.setVelocity(-1950);
        backshooter.setVelocity(-1950);
        Servo.setPower(-2);
        secondfeeder.setPower(-1);
        sleep(8000);
        frontshooter.setVelocity(0);
        backshooter.setVelocity(0);
        Servo.setPower(0);
        secondfeeder.setPower(0);
        firstfeeder.setPower(0);

        Turn(90);
        forward(500,6);
        Turn(180);
        forward(1500,6);



    }
    public void Turn(double target_angle) {
        double Kp = 0.03;
        double current_angle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

        while (Math.abs(current_angle - target_angle) > 3){
            current_angle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

            double error = target_angle - current_angle;

            FrontLeft.setPower(error * Kp);
            FrontRight.setPower(error * -Kp);
            BackLeft.setPower(error * Kp);
            BackRight.setPower(error * -Kp);

            telemetry.addData("current: ", current_angle);
            telemetry.addData("error: ", error);
            telemetry.update();
        }
    }
    public void forward(int distance, double power) {

        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontLeft.setTargetPosition(distance);
        FrontLeft.setPower(power);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setTargetPosition(distance);
        FrontRight.setPower(power);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setTargetPosition(distance);
        BackLeft.setPower(power);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setTargetPosition(distance);
        BackRight.setPower(power);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(FrontLeft.isBusy() || FrontRight.isBusy() || BackRight.isBusy() || BackLeft.isBusy()){
            if (FrontLeft.getPower() < Threshold &&
                FrontRight.getPower() < Threshold &&
                BackRight.getPower() < Threshold &&
                BackLeft.getPower() < Threshold
            )
            {
                break;
            }


        }

        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



    }

}
