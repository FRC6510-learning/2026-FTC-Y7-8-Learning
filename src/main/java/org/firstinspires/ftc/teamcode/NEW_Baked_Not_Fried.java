package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "baked_not_fried")
public class NEW_Baked_Not_Fried extends OpMode {
    // 1 - declare variables

    DcMotor RF, RB, LF, LB, I;

    @Override
    public void init(){
        // 2 - configure motors

        RF = hardwareMap.get(DcMotor.class, "rf");
        RB = hardwareMap.get(DcMotor.class, "rb");
        LF = hardwareMap.get(DcMotor.class, "lf");
        LB = hardwareMap.get(DcMotor.class, "lb");
        I = hardwareMap.get(DcMotor.class, "i");



        RF.setDirection(DcMotorSimple.Direction.FORWARD);
        RB.setDirection(DcMotorSimple.Direction.FORWARD);
        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){
        // 3 - acual drive code

        double lsy = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;

        RF.setPower(lsy - turn - strafe);
        RB.setPower(lsy - turn + strafe);
        LF.setPower(lsy + turn + strafe);
        LB.setPower(lsy + turn - strafe);

            if (gamepad1.right_trigger > 0.1) {
                I.setPower(1);
            } else {
                I.setPower(0);
            }

    }


}
