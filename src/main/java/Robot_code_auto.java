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

        forward(1000, 0.5);

        Turn(1000, 0.5);

        firstfeeder.setPower(-1);

        secondfeeder.setPower(-1);

        forward(-1800, 0.3);

        firstfeeder.setPower(0);

        secondfeeder.setPower(0);

        forward(2000, 0.5);
        Turn(-1000,0.5);
        forward(2000,0.5);
        Turn(-400, 0.5);


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

        while(FrontLeft.isBusy() || FrontRight.isBusy()|| BackRight.isBusy()|| BackLeft.isBusy()){

        }

    }

}
