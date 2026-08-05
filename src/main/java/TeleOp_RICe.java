/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="RICe_TeleOp", group="TeleOp")
public class TeleOp_RICe extends OpMode {

    DcMotor lf_motor = null;
    DcMotor lb_motor = null;
    DcMotor rf_motor;
    DcMotor rb_motor;

    @Override
    public void init() {


    lf_motor = hardwareMap.get(DcMotor.class, "lf_motor");
    lb_motor = hardwareMap.get(DcMotor.class, "lb_motor" );
    rf_motor = hardwareMap.get(DcMotor.class, "rf_motor");
    rb_motor = hardwareMap.get(DcMotor.class, "rb_motor");

    lf_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    lb_motor.setDirection(DcMotorSimple.Direction.REVERSE);
    rf_motor.setDirection(DcMotorSimple.Direction.FORWARD);
    rb_motor.setDirection(DcMotorSimple.Direction.FORWARD);

    lf_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    lb_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rf_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    rb_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }


    @Override
    public void loop() {

        double y = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;



        rf_motor.setPower(y);
        rb_motor.setPower(y);
        lb_motor.setPower(y);
        lf_motor.setPower(y);

    }

}
