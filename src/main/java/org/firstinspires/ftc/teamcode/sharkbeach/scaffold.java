package org.firstinspires.ftc.teamcode.sharkbeach;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class scaffold extends OpMode {
    //naming motors
    DcMotor sharkbeach;

    @Override
    public void init(){
        //configuring motors
        sharkbeach = hardwareMap.get(DcMotor.class, "sb");


    }
    @Override
    public void loop(){
        //telling motors what to do


    }

}
