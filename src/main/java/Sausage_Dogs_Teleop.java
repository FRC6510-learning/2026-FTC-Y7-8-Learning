import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "Sausage_dogs_teleop")
public class Sausage_Dogs_Teleop extends OpMode {
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight;



    private CRServo Servo;
    @Override
    public void init() {
        FrontRight = hardwareMap.get(DcMotor .class, "FRW");
        FrontLeft = hardwareMap.get(DcMotor.class, "FLW");
        BackLeft = hardwareMap.get(DcMotor.class, "BLW");
        BackRight = hardwareMap.get(DcMotor.class, "BRW");
        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

        if (gamepad1.dpad_up) {
            Servo.setPower(1);
        } else {
            Servo.setPower(0);
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
