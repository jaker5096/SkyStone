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

package org.firstinspires.ftc.teamcode._TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="ControllerReader", group="Test")
//@Disabled
public class ControllerReader extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor NorthEast = null;
    private DcMotor NorthWest = null;
    private DcMotor SouthEast = null;
    private DcMotor SouthWest = null;
    private Boolean hasNorthEast = false;
    private Boolean hasNorthWest = false;
    private Boolean hasSouthEast = false;
    private Boolean hasSouthWest = false;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        try {
            NorthEast = hardwareMap.get(DcMotor.class, "NE_M");
            NorthEast.setDirection(DcMotor.Direction.FORWARD);
            hasNorthEast = true;
            telemetry.addData("NorthEast Motor", "Initialized");
        } catch (IllegalArgumentException iax) {
            telemetry.addData("NorthEast Motor", "Failed");
        }

        try {
            NorthWest = hardwareMap.get(DcMotor.class, "NW_M");
            NorthWest.setDirection(DcMotor.Direction.FORWARD);
            hasNorthWest = true;
            telemetry.addData("NorthWest Motor", "Initialized");
        } catch (IllegalArgumentException iax) {
            telemetry.addData("NorthWest Motor", "Failed");
        }

        try {
            SouthWest = hardwareMap.get(DcMotor.class, "SW_M");
            SouthWest.setDirection(DcMotor.Direction.FORWARD);
            hasSouthWest = true;
            telemetry.addData("Southwest Motor", "Initialized");
        } catch (IllegalArgumentException iax) {
            telemetry.addData("SouthWest Motor", "Failed");
        }

        try {
            SouthEast = hardwareMap.get(DcMotor.class, "SE_M");
            SouthEast.setDirection(DcMotor.Direction.FORWARD);
            hasSouthEast = true;
            telemetry.addData("SouthEast Motor", "Initialized");
        } catch (IllegalArgumentException iax) {
            telemetry.addData("SouthEast Motor", "Failed");
        }



    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
        if (hasNorthEast){
            NorthEast.setPower(0);
        }
        if (hasNorthWest){
            NorthWest.setPower(0);
        }
        if (hasSouthEast){
            SouthEast.setPower(0);
        }
        if (hasSouthWest){
            SouthWest.setPower(0);
        }

    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }


    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double NorthEastPower = 0;
        double NorthWestPower = 0;
        double SouthEastPower = 0;
        double SouthWestPower = 0;

        double controller_x = gamepad1.left_stick_x;
        double controller_y = -gamepad1.left_stick_y;
        double newX;
        double newY;

        double leftTrigger = gamepad1.left_trigger;
        double rightTrigger = gamepad1.right_trigger;

        double spin = gamepad1.right_stick_x;


        double turnRadians;
        double turnAngle;

        double powerAdj;


        boolean DoSpin = false;
        boolean useMotors = false;

        if (hasSouthEast && hasNorthWest && hasNorthEast && hasSouthWest) {
            useMotors = true;
        }

        if(controller_x > -0.000001 && controller_x < 0.000001){
            controller_x = 0;
        }
        if(controller_y > -0.000001 && controller_y < 0.000001){
            controller_y = 0;
        }
        if(spin > -0.000001 && spin < 0.000001){
            spin = 0;
        }

        turnRadians = Math.atan2(controller_y,controller_x);
        turnAngle = Math.toDegrees(turnRadians);

        if (turnAngle < 0) {
            turnAngle = 360 + turnAngle;
        }
        if (turnAngle == 0) {
            turnAngle = 360;
        }


        newX = Math.cos(turnAngle);
        newY = Math.sin(turnAngle);

        if (Math.abs(controller_x)+Math.abs(controller_y) < 0.8){
            SouthEastPower =0;
            SouthWestPower =0;
            NorthEastPower =0;
            NorthWestPower =0;
        }
        else {
            if (newY > .1) {
                NorthEastPower = newY;
                SouthWestPower = -newY;
            }
            else if (newY <= -.1) {
                NorthEastPower = -newY;
                SouthWestPower = newY;
            }
            if (newX > .1) {
                NorthWestPower = -newX;
                SouthEastPower = newX;
            }
            else if (newX <= -.1) {
                NorthWestPower = newX;
                SouthEastPower = -newX;
            }
        }

        //.2 power
        if (rightTrigger > 0) {
            powerAdj = .2;
        }
        else if (leftTrigger > 0) {
            powerAdj = .8;
        }
        else if (rightTrigger > 0 && leftTrigger > 0) {
            powerAdj = 1;
        }
        else {
            powerAdj = 0;
        }




        if (useMotors == true) {
            if (spin != 0 && powerAdj > 0) {
                if (spin < 0) {
                    NorthEast.setPower(-powerAdj);
                    NorthWest.setPower(-powerAdj);
                    SouthEast.setPower(-powerAdj);
                    SouthWest.setPower(-powerAdj);
                }
                else if (spin > 0) {
                    NorthEast.setPower(powerAdj);
                    NorthWest.setPower(powerAdj);
                    SouthEast.setPower(powerAdj);
                    SouthWest.setPower(powerAdj);
                }

            }
            else if (DoSpin == false && powerAdj > 0) {

                NorthEast.setPower(NorthEastPower*powerAdj);
                NorthWest.setPower(NorthWestPower*powerAdj);
                SouthEast.setPower(SouthEastPower*powerAdj);
                SouthWest.setPower(SouthWestPower*powerAdj);

                telemetry.addData("motors", null);

            }
        }






        telemetry.addData("X-val", controller_x);
        telemetry.addData("y_val", controller_y);
        telemetry.addData("left trigger", leftTrigger);
        telemetry.addData("right trigger", rightTrigger);
        telemetry.addData("spin", spin);
        telemetry.addData("turn angle", turnAngle);
        telemetry.addData("NE", NorthEastPower);
        telemetry.addData("NW", NorthWestPower);
        telemetry.addData("SE", SouthEastPower);
        telemetry.addData("SW", SouthWestPower);



    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }





}
