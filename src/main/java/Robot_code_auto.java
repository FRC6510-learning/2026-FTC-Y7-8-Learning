import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "a5robotcode_auto_fs")
public class Robot_code_auto extends LinearOpMode {
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight, secondfeeder, frontshooter, backshooter, firstfeeder;
    private CRServo Servo;

    private double Threshold = 0.1;


    @Override
    public void runOpMode() {
        FrontRight = hardwareMap.get(DcMotor .class, "FRW");
        FrontLeft = hardwareMap.get(DcMotor.class, "FLW");
        BackLeft = hardwareMap.get(DcMotor.class, "BLW");
        BackRight = hardwareMap.get(DcMotor.class, "BRW");
        firstfeeder = hardwareMap.get(DcMotor.class, "FF");
        secondfeeder = hardwareMap.get(DcMotor.class, "SF");
        frontshooter = hardwareMap.get(DcMotor.class, "FS");
        backshooter = hardwareMap.get(DcMotor.class, "BS");
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

        forward(1100, 0.5);

        Turn(1000, 0.5);

        firstfeeder.setPower(-0.7);

        secondfeeder.setPower(-0.7);


        forward(-1100, 0.4);
        firstfeeder.setPower(0);
        secondfeeder.setPower(0);

        Servo.setPower(-2);
        sleep(500);
        Servo.setPower(0);





        forward(2100, 0.5);
        Turn(-1000,0.5);
        forward(2000,0.5);
        Turn(-520, 0.5);



        frontshooter.setPower(-0.85);
        backshooter.setPower(-0.85);
        Servo.setPower(-2);
        sleep(300);
        secondfeeder.setPower(-1);
        firstfeeder.setPower(-1);
        sleep(10000);
        frontshooter.setPower(0);
        backshooter.setPower(0);
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
