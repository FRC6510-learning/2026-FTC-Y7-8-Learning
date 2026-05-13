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

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Pymble A1Milk", group="Iterative OpMode")
public class A1_robotcode extends OpMode
{
    // Declare OpMode members.
    private DcMotor lfront, rfront, lback, rback, intake, feeder, lshooter, rshooter;
    private CRServo feeder2;

    double y;
    double x;
    double rx;

    boolean xButton;
    boolean yButton;

    boolean aButton;
    boolean bButton;

    boolean rButton;

    boolean lButton;

    private CRServo servo;

    double denominator;
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {

        lfront = hardwareMap.get(DcMotor.class, "lfront");
        rfront = hardwareMap.get(DcMotor.class, "rfront");
        lback = hardwareMap.get(DcMotor.class, "lback");
        rback = hardwareMap.get(DcMotor.class, "rback");
        intake = hardwareMap.get(DcMotor.class, "intake");
        feeder = hardwareMap.get(DcMotor.class, "feeder1");
        lshooter = hardwareMap.get(DcMotor.class, "lshooter");
        rshooter=hardwareMap.get(DcMotor.class, "rshooter");
        feeder2 = hardwareMap.get(CRServo.class, "servo");

        lfront.setDirection(DcMotor.Direction.REVERSE);
        lback.setDirection(DcMotor.Direction.REVERSE);
        rshooter.setDirection(DcMotor.Direction.FORWARD);
        lshooter.setDirection(DcMotor.Direction.REVERSE);

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        xButton = gamepad1.x;
        yButton = gamepad1.y;
        aButton = gamepad1.a;
        bButton = gamepad1.b;
        rButton = gamepad1.right_bumper;
        lButton = gamepad1.left_bumper;
        y = gamepad2.left_stick_y;
        x = gamepad2.right_stick_x;
        rx = gamepad2.left_stick_x;
        denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx),1);

        lfront.setPower((y + x + rx)/denominator);
        rfront.setPower((y - x - rx)/denominator);
        lback.setPower((y + x - rx)/denominator);
        rback.setPower((y - x + rx)/denominator);

        if(xButton) {
            intake.setPower(1.0);
            feeder.setPower(1.0);
        } else if(yButton) {
            intake.setPower(-1.0);
            feeder.setPower(-1.0);
        } else {
            intake.setPower(0);
            feeder.setPower(0);
        }

        if(aButton) {
            lshooter.setPower(1.0);
            rshooter.setPower(-1.0);
        }else if(bButton) {
            lshooter.setPower(-1.0);
            rshooter.setPower(1.0);
        } else {
            lshooter.setPower(0);
            rshooter.setPower(0);
        }

        if(rButton) {
            feeder2.setPower(1.0);
        } else if(lButton) {
            feeder2.setPower(-1.0);
        } else {
            feeder2.setPower(0);
        }

    }
    }




