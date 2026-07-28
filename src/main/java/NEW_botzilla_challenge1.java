import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class NEW_botzilla_challenge1 extends OpMode {
    // 1 - varibale definition

    int mynamebob;

    DcMotor FR;
    DcMotor FL;
    DcMotor BR;
    DcMotor BL;



    @Override
    public void init(){
        // 2
        FR = hardwareMap.get(DcMotor.class, "front right");
        FL = hardwareMap.get(DcMotor.class, "front left");
        BL = hardwareMap.get(DcMotor.class, "back left");
        BR = hardwareMap.get(DcMotor.class, "back right");

        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);




    }


    @Override
    public void loop(){
        // 3
        double forward = gamepad1.left_stick_y;
        double sideways = gamepad1.left_stick_x;
        double turning = gamepad1.right_stick_x;
                    // number
        FR.setPower(forward - turning - sideways);
        FL.setPower(forward + turning + sideways);
        BR.setPower(forward - turning + sideways);
        BL.setPower(forward + turning - sideways);

      
    }

}
