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

package org.firstinspires.ftc.teamcode._Libs;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class Xdrive {
    /* Public OpMode members. */
    // Declare OpMode members.
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor TopLeft = null;
    public DcMotor TopRight = null;
    public DcMotor BottomLeft = null;
    public DcMotor BottomRight = null;
    public Servo Leftflipper = null;
    public Servo Rightflipper = null;
    public Servo Leftscoop = null;
    public Servo Rightscoop = null;

    //bootleeeeeen
    public Boolean hasTopLeft = Boolean.FALSE;
    public Boolean hasTopRight = Boolean.FALSE;
    public Boolean hasBottomLeft = Boolean.FALSE;
    public Boolean hasBottomRight = Boolean.FALSE;
    public Boolean hasLeftflipper = Boolean.FALSE;
    public Boolean hasRightflipper = Boolean.FALSE;
    public Boolean hasLeftscoop = Boolean.FALSE;
    public Boolean hasRightscoop = Boolean.FALSE;

    public static final double FrontRightPower = 0;
    public static final double FrontLeftPower = 0;
    public static final double BackRightPower = 0;
    public static final double BackLeftPower = 0;

    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Constructor */
    public Xdrive() {

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {


        // Save reference to Hardware map
        hwMap = ahwMap;

        try {
            TopLeft = hwMap.get(DcMotor.class, "Top_Left");
            TopLeft.setDirection(DcMotor.Direction.FORWARD);
            hasTopLeft = Boolean.TRUE;
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("TopLeft", "Failed");
        }


        try {
            TopRight = hwMap.get(DcMotor.class, "Top_Right");
            hasTopRight = Boolean.TRUE;
//            telemetry.addData("TopRight", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("TopRight", "Failed");
        }


        try {
            BottomRight = hwMap.get(DcMotor.class, "Bottom_Right");
            hasBottomRight = Boolean.TRUE;
            BottomRight.setDirection(DcMotor.Direction.REVERSE);
//            telemetry.addData("BottomRight", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("BottomRight", "Failed");
        }


        try {
            BottomLeft = hwMap.get(DcMotor.class, "Bottom_Left");
            hasBottomLeft = Boolean.TRUE;
            BottomLeft.setDirection(DcMotor.Direction.REVERSE);
//            telemetry.addData("BottomLeft", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("BottomLeft", "Failed");
        }


        try {
            Leftflipper = hwMap.get(Servo.class, "left_flipper");
            hasLeftflipper = Boolean.TRUE;
//            telemetry.addData("Leftflipper", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("Leftflipper", "Failed");
        }
        try {
            Rightflipper = hwMap.get(Servo.class, "right_flipper");
            hasRightflipper = Boolean.TRUE;
//            telemetry.addData("Rightflipper", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("Rightflipper", "Failed");
        }
        try {
            Leftscoop = hwMap.get(Servo.class, "left_scoop");
            hasLeftscoop = Boolean.TRUE;
//            telemetry.addData("Leftscoop", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("Leftscoop", "Failed");
        }
        try {
            Rightscoop = hwMap.get(Servo.class, "right_scoop");
            hasRightscoop = Boolean.TRUE;
//            telemetry.addData("Rightscoop", "Initialized");
        } catch (IllegalArgumentException iax) {
//            telemetry.addData("Rightscoop", "Failed");

//            if (hasTopLeft) {
//                TopLeft.setPower(FrontLeftPower);
//            }
//            if (hasTopRight) {
//                TopRight.setPower(FrontRightPower);
//            }
//            if (hasBottomLeft) {
//                BottomLeft.setPower(BackLeftPower);
//            }
//            if (hasBottomRight) {
//                BottomRight.setPower(BackRightPower);
//            }
//            if (hasLeftflipper) {
//                Leftflipper.setPosition(0);
//            }
//            if (hasRightflipper) {
//                Rightflipper.setPosition(0);
//            }
//            if (hasLeftscoop) {
//                Leftscoop.setPosition(0);
//            }
//            if (hasRightscoop) {
//                Rightscoop.setPosition(0);
//            }

        }
    }
}

