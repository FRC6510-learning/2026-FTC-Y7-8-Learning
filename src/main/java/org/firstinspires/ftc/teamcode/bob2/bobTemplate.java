package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(group = "", name = "")
public class bobTemplate extends OpMode {
    // Section 1 : defining variables
    DcMotor bob4;




    @Override
    public void init(){
        // Section 2 configurating bobd
        bob4 = hardwareMap.get(DcMotor.class, "bob5");


    }
    @Override
    public void loop(){
        // Section 3 : repeating bobd







    }
}
