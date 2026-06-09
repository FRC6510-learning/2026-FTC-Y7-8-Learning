package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "A2_auto")
public class A2_Auto extends LinearOpMode {

    private DcMotor fr, br, fl, bl, i1, i2, ts, bs;

    private CRServo feeder;

    @Override
    public void runOpMode() {
        fr = hardwareMap.get(DcMotor.class, "fr");
        fl = hardwareMap.get(DcMotor.class, "fl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl = hardwareMap.get(DcMotor.class, "bl");
        feeder = hardwareMap.get(CRServo.class, "servo");
        i2 = hardwareMap.get(DcMotor.class, "i2");
        i1 = hardwareMap.get(DcMotor.class, "i1");
        bs = hardwareMap.get(DcMotor.class, "bs");
        ts = hardwareMap.get(DcMotor.class, "ts");
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setDirection(DcMotor.Direction. REVERSE);

        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);



        waitForStart();

        forward(1000, 0.5);
        turn(1100,0.5);
        i2.setPower(1);
        i1.setPower(1);
        forward(-1700,-0.5);
        i2.setPower(0);
        i1.setPower(0);
        forward(1000,1);
        ts.setPower(1);
        bs.setPower(1);
        turn(-1100,-0.5);
        forward(2200,0.5);
        turn(-475,-0.5);
        feeder.setPower(-0.5);
        i2.setPower(1);
        i1.setPower(1);
        sleep(5000);
        i2.setPower(0);
        i1.setPower(0);



    }

    public void forward(int distance, double power) {
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fr.setTargetPosition(distance);
        fr.setPower(power);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fl.setTargetPosition(distance);
        fl.setPower(power);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        br.setTargetPosition(distance);
        br.setPower(power);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bl.setTargetPosition(distance);
        bl.setPower(power);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (fr.isBusy() || br.isBusy() || fl.isBusy() || bl.isBusy()) {}
    }

    public void turn(int distance, double power) {
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        fr.setTargetPosition(-distance);
        fr.setPower(-power);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        fl.setTargetPosition(distance);
        fl.setPower(power);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        br.setTargetPosition(-distance);
        br.setPower(-power);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        bl.setTargetPosition(distance);
        bl.setPower(power);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (fr.isBusy() || br.isBusy() || fl.isBusy() || bl.isBusy()) {}
    }
}
