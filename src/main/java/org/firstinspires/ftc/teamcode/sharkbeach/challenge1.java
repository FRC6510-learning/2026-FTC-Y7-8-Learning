package org.firstinspires.ftc.teamcode.sharkbeach;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class challenge1 extends OpMode {
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
        double turnright= gamepad1.left_stick_x;
        tl.setPower(forward + turnright);
        tr.setPower(forward - turnright);
        bl.setPower(forward + turnright);
        br.setPower(forward - turnright);



    }

}
