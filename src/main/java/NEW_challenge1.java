import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "DogSausageTeleop")
public class NEW_challenge1 extends OpMode {
    // section 1 - declaring variables - making variables
    private DcMotor FrontRight, FrontLeft, BackLeft, BackRight;

    @Override
    public void init(){
        // linking to config
        FrontRight = hardwareMap.get(DcMotor .class, "FRW");
        FrontLeft = hardwareMap.get(DcMotor.class, "FLW");
        BackLeft = hardwareMap.get(DcMotor.class, "BLW");
        BackRight = hardwareMap.get(DcMotor.class, "BRW");

        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);



    }
    @Override
    public void loop(){
        // actual code

        double forward = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;
        double speed = 0.5;

        if (gamepad1.left_trigger_pressed) {
            speed = 0.85;
        } else if (gamepad1.right_trigger_pressed) {
            speed = 0.3;
        }


        FrontLeft.setPower((forward + turn + strafe) * speed);
        FrontRight.setPower((forward - turn - strafe) * speed);
        BackLeft.setPower((forward + turn - strafe) * speed);
        BackRight.setPower((forward - turn + strafe) * speed);



    }
}
