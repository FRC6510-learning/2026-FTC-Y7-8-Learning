package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "a name- cc all rights reserved")
public class NEW_Challenge_one_CC_All_Rights_Reserved extends OpMode {
    // 1 - variables

    DcMotor FRwheel, FLwheel, BRwheel, BLwheel;

    @Override
    public void init(){
        // 2 - link to config

        FRwheel = hardwareMap.get(DcMotor.class, "frw");
        FLwheel = hardwareMap.get(DcMotor.class, "flw");
        BRwheel = hardwareMap.get(DcMotor.class, "brw");
        BLwheel = hardwareMap.get(DcMotor.class, "blw");

        //hihi

        FLwheel.setDirection(DcMotorSimple.Direction.REVERSE);
        BLwheel.setDirection(DcMotorSimple.Direction.REVERSE);

    }
    @Override
    public void loop(){
        // 3 - actual robot code

        double forwards = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double sideways = -gamepad1.left_stick_x;

        FRwheel.setPower(forwards + turn - sideways);
        FLwheel.setPower(forwards - turn + sideways);
        BRwheel.setPower(forwards + turn + sideways);
        BLwheel.setPower(forwards - turn - sideways);


    }
}
