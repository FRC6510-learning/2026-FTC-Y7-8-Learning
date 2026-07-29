import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp(name = "a5robotcode")
public class A5_robot_teleop extends OpMode {
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight, secondfeeder, frontshooter, backshooter, firstfeeder;



    private CRServo Servo;
    @Override
    public void init() {
        FrontRight = hardwareMap.get(DcMotor .class, "FRW");
        FrontLeft = hardwareMap.get(DcMotor.class, "FLW");
        BackLeft = hardwareMap.get(DcMotor.class, "BLW");
        BackRight = hardwareMap.get(DcMotor.class, "BRW");


        firstfeeder = hardwareMap.get(DcMotor.class, "FF");
        secondfeeder = hardwareMap.get(DcMotor.class, "SF");
        frontshooter = hardwareMap.get(DcMotor.class, "FS");
        backshooter = hardwareMap.get(DcMotor.class, "BS");
        Servo = hardwareMap.get(CRServo.class, "Servo");

        firstfeeder.setDirection(DcMotorSimple.Direction.REVERSE);
        secondfeeder.setDirection(DcMotorSimple.Direction.REVERSE);
        Servo.setDirection(DcMotorSimple.Direction.REVERSE);
        frontshooter.setDirection(DcMotorSimple.Direction.REVERSE);
        backshooter.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {
        if (gamepad1.a) {
            // exeute
            firstfeeder.setPower(1);
        } else {
            firstfeeder.setPower(0);
        }

        if (gamepad1.b) {
            secondfeeder.setPower(1);
        } else {
            secondfeeder.setPower(0);
        }

        if (gamepad1.dpad_up) {
            Servo.setPower(1);
        } else {
            Servo.setPower(0);
        }

        if (gamepad1.left_bumper) {
            frontshooter.setPower(0.75);
            backshooter.setPower(0.8);
        } else {
            frontshooter.setPower(0);
            backshooter.setPower(0);
        }

        double forward = gamepad2.left_stick_y;
        double turning = -gamepad2.right_stick_x;
        double strafe = -gamepad2.left_stick_x;

        FrontRight.setPower(forward-turning-strafe);
        FrontLeft.setPower(forward+turning+strafe);
        BackLeft.setPower(forward+turning-strafe);
        BackRight.setPower(forward-turning+strafe);


    }

}
