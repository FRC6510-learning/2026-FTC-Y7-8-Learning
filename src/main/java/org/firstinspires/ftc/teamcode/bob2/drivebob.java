package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(group = "", name = "")
public class drivebob extends OpMode {
    // Section 1 : defining variables
    DcMotor drivebobfr,drivebobfl, drivebobbr, drivebobbl;

    @Override
    public void init(){
        // Section 2 configurating bobd
        drivebobfr = hardwareMap.get(DcMotor.class,"front right" );
        drivebobfl = hardwareMap.get(DcMotor.class,"front left" );
        drivebobbl = hardwareMap.get(DcMotor.class,"back left");
        drivebobbr = hardwareMap.get(DcMotor.class,"back right");

        drivebobfl.setDirection(DcMotorSimple.Direction.REVERSE);
        drivebobbl.setDirection(DcMotorSimple.Direction.REVERSE);


    }
    @Override
    public void loop(){
        // Section 3 : repeating bobd

        double left_y = -gamepad1.left_stick_y;
        double left_x = gamepad1.left_stick_x;
        double right_x = -gamepad1.right_stick_x;

        drivebobfr.setPower(left_y - right_x - left_x);
        drivebobbr.setPower(left_y - right_x + left_x);
        drivebobfl.setPower(left_y + right_x + left_x);
        drivebobbl.setPower(left_y + right_x - left_x);



    }
}
