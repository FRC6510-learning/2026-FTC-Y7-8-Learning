package org.firstinspires.ftc.teamcode.sharkbeach;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "c1")
public class c1teleop extends OpMode {
    //naming motors
    DcMotor tl, tr, bl, br;
   // DcMotor shartake;

    @Override
    public void init(){
        //configuring motors
        tl = hardwareMap.get(DcMotor.class, "tl");
        tr = hardwareMap.get(DcMotor.class, "tr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
       // shartake = hardwareMap.get(DcMotor.class, "intake");
        tl.setDirection(DcMotor.Direction.FORWARD);
        tr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop(){
        //telling motors what to do
        double forward=gamepad1.left_stick_y;
        double turnright= gamepad1.right_stick_x;
        double strafe= gamepad1.left_stick_x;
        tr.setPower(forward + turnright- strafe);
        tl.setPower(forward - turnright+strafe);
        br.setPower(forward + turnright- strafe);
        bl.setPower(forward - turnright+ strafe);

        if (gamepad1.aWasPressed()){
            tl.setPower((forward + turnright- strafe)/2);
            tr.setPower((forward - turnright+strafe)/2);
            bl.setPower((forward + turnright- strafe)/2);
            br.setPower((forward - turnright+ strafe)/2);
        }


        telemetry.addData("hello", "bye");
        telemetry.update();


    }

}
