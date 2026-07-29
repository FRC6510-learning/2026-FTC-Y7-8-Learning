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

package org.firstinspires.ftc.teamcode.what_do_you_want_to_call_this;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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

@TeleOp(name="Basic: Iterative OpMode", group="Iterative OpMode")
public class NEWshrek_steak_robotcode extends OpMode
{
    // Declare OpMode members.
    private DcMotor FrontRightMotor;
    private DcMotor FrontLeftMotor;
    private DcMotor BackRightMotor;
    private DcMotor BackLeftMotor;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        FrontRightMotor = hardwareMap.get(DcMotor.class, "fr");
        FrontLeftMotor = hardwareMap.get(DcMotor.class, "fl");
        BackRightMotor = hardwareMap.get(DcMotor.class, "br");
        BackLeftMotor = hardwareMap.get(DcMotor.class, "bl");

        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     */

    @Override
    public void loop() {
        double forward_and_back = gamepad1.right_stick_y;
        double turn = gamepad1.left_stick_x;
        double left_and_right = gamepad1.right_stick_x;

//        FrontRightMotor.setPower(forward_and_back);
//        FrontLeftMotor.setPower(forward_and_back);
//        BackRightMotor.setPower(forward_and_back);
//        BackLeftMotor.setPower(forward_and_back);

//        FrontRightMotor.setPower(turn);
//        FrontLeftMotor.setPower(-turn);
//        BackRightMotor.setPower(turn);
//        BackLeftMotor.setPower(-turn);

//        FrontRightMotor.setPower(left_and_right);
//        FrontLeftMotor.setPower(-left_and_right);
//        BackRightMotor.setPower(-left_and_right);
//        BackLeftMotor.setPower(left_and_right);

        FrontRightMotor.setPower(forward_and_back + turn + left_and_right);
        FrontLeftMotor.setPower(forward_and_back -turn -left_and_right);
        BackRightMotor.setPower(forward_and_back + turn -left_and_right);
        BackLeftMotor.setPower(forward_and_back -turn + left_and_right);

    }
}
