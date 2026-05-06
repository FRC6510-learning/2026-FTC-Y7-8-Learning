import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

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
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        FrontLeft.setTargetPosition(1000);


    }

}
