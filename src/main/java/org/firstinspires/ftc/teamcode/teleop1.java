package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class teleop1 extends OpMode {
    //naming motors
    DcMotor tl, tr, bl, br;
    DcMotor shartake;

    @Override
    public void init(){
        //configuring motors
        tl = hardwareMap.get(DcMotor.class, "tl");
        tr = hardwareMap.get(DcMotor.class, "tr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        shartake = hardwareMap.get(DcMotor.class, "intake");
    }
    @Override
    public void loop(){
        //telling motors what to do
        double forward=gamepad1.left_stick_y;
        double turnright= gamepad1.right_stick_x;
        double strafe= gamepad1.left_stick_x;
        tl.setPower(forward + turnright- strafe);
        tr.setPower(forward - turnright+strafe);
        bl.setPower(forward + turnright- strafe);
        br.setPower(forward - turnright+ strafe);

        if (gamepad1.aWasPressed()){
            tl.setPower((forward + turnright- strafe)/2);
            tr.setPower((forward - turnright+strafe)/2);
            bl.setPower((forward + turnright- strafe)/2);
            br.setPower((forward - turnright+ strafe)/2);
        }


    }

}
