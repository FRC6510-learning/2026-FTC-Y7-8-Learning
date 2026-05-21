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

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
 * This OpMode illustrates the concept of driving a path based on time.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: RobotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backward for 1 Second
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */



@Autonomous(name="TEAM A8 AUTO CODE", group="Arbot")
public class RobotAutoDriveByTime_Linear_copy extends LinearOpMode {

    /* Declare OpMode members. */

    // Declare OpMode members.
    //private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftBackMotor;
    DcMotor leftFrontMotor;
    DcMotor rightFrontMotor;
    DcMotor rightBackMotor;
    DcMotor frontIntake;
    DcMotor middleIntake;
    CRServo topIntake;
    DcMotor topShooter;
    DcMotor bottomShooter;

   // private ElapsedTime runtime = new ElapsedTime();

    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        leftFrontMotor  = hardwareMap.get(DcMotor.class, "FLwheel");
        rightFrontMotor = hardwareMap.get(DcMotor.class, "FRwheel");
        leftBackMotor = hardwareMap.get(DcMotor.class, "BRwheel");
        rightBackMotor = hardwareMap.get(DcMotor.class, "BLwheel");
        frontIntake = hardwareMap.get(DcMotor.class, "Frontfeeder");
        middleIntake = hardwareMap.get(DcMotor.class, "Middlefeeder");
        topIntake = hardwareMap.get(CRServo.class, "Backfeeder");
        topShooter = hardwareMap.get(DcMotor.class, "Shooter1");
        bottomShooter = hardwareMap.get(DcMotor.class, "Shooter2");

        rightFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFrontMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);




        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses START)
        waitForStart();

        driveForward();
        turnLeft();




        // Step through each leg of the path, ensuring that the OpMode has not been stopped along the way.

    }
public void driveForward(){
    rightFrontMotor.setPower(1);
    leftFrontMotor.setPower(1);
    rightBackMotor.setPower(1);
    leftBackMotor.setPower(1);

    sleep(500);

    rightFrontMotor.setPower(0);
    leftFrontMotor.setPower(0);
    rightBackMotor.setPower(0);
    leftBackMotor.setPower(0);

}
    public void turnLeft(){
        rightFrontMotor.setPower(1);
        leftBackMotor.setPower(1);
        leftFrontMotor.setPower(-1);
        rightBackMotor.setPower(-1);

        sleep(115);

        rightFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        leftFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
    }


}
