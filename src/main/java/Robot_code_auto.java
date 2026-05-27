import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

@Autonomous(name = "a5robotcode_auto_fs")
public class Robot_code_auto extends LinearOpMode {
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight, secondfeeder,  firstfeeder;
    private CRServo Servo;
    private DcMotorEx frontshooter, backshooter;

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

        forward(1100, 0.4);

        Turn(1000, 0.4);

        firstfeeder.setPower(-0.7);

        secondfeeder.setPower(-0.7);


        forward(-1800, 0.3);
        firstfeeder.setPower(0);
        secondfeeder.setPower(0);


        forward(2100, 0.4);
        Turn(-1000,0.4);
        forward(2000,0.4);
        Turn(-510, 0.4);



        frontshooter.setVelocity(-1850);
        backshooter.setVelocity(-1850);
        Servo.setPower(-2);
        sleep(300);
        secondfeeder.setPower(-1);
        firstfeeder.setPower(-1);
        sleep(10000);
        frontshooter.setVelocity(0);
        backshooter.setVelocity(0);
        Servo.setPower(0);
        secondfeeder.setPower(0);
        firstfeeder.setPower(0);


    }
    public void Turn(int distance, double power) {
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FrontLeft.setTargetPosition(distance);
        FrontLeft.setPower(power);
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setTargetPosition(-distance);
        FrontRight.setPower(-power);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setTargetPosition(distance);
        BackLeft.setPower(power);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setTargetPosition(-distance);
        BackRight.setPower(-power);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(FrontLeft.isBusy() || FrontRight.isBusy()|| BackRight.isBusy()|| BackLeft.isBusy()){
            if (FrontLeft.getPower() < Threshold &&
                    FrontRight.getPower() < Threshold &&
                    BackRight.getPower() < Threshold &&
                    BackLeft.getPower() < Threshold
            )
            {
                break;
            }
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



    }

}
