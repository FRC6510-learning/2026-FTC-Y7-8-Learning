package org.firstinspires.ftc.teamcode.bob2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(group = "", name = "the best code that doesn't make any sense")
public class controllingBabbob extends OpMode {
    // Section 1 : defining variables
    DcMotor backbob, middlebob, shooterbobl, shooterbobr;
    CRServo frontbob;




    @Override
    public void init(){
        // Section 2 configurating bobd
        backbob = hardwareMap.get(DcMotor.class, "back intake");
        middlebob = hardwareMap.get(DcMotor.class, "middle intake");
        frontbob = hardwareMap.get(CRServo.class, "top intake servo");
        shooterbobl = hardwareMap.get(DcMotor.class, "shooter left");
        shooterbobr = hardwareMap.get(DcMotor.class, "shooter right");


    }
    @Override
    public void loop(){
        // Section 3 : repeating bob

        if (gamepad1.a) {
            backbob.setPower(-0.8);
            middlebob.setPower(-0.8);
            frontbob.setPower(-0.8);
        } else if (gamepad1.b) {
            backbob.setPower(0.8);
            middlebob.setPower(0.8);
            frontbob.setPower(0.8);

        }
        else {
            backbob.setPower(0);
            middlebob.setPower(0);
            frontbob.setPower(0);
        }

        if (gamepad1.y) {
            shooterbobl.setPower(-0.8);
            shooterbobr.setPower(0.8);
        } else if (gamepad1.x) {
            shooterbobl.setPower(-0.0);
            shooterbobr.setPower(0.0);
        }



    }
}
