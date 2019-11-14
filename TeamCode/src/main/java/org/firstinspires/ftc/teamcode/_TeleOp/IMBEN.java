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
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@TeleOp(name="Im Ben", group="Iterative Opmode")
public class IMBEN extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor TopLeft = null;
    private DcMotor TopRight = null;
    private DcMotor BottomLeft = null;
    private DcMotor BottomRight = null;
    private Servo Leftflipper = null;
    private Servo Rightflipper = null;
    private Servo Leftscoop = null;
    private Servo Rightscoop = null;
    private DcMotor leftRoly = null;
    private DcMotor rightRoly = null;

    //bootleeeeeen
    private Boolean hasTopLeft =Boolean.FALSE;
    private Boolean hasTopRight =Boolean.FALSE;
    private Boolean hasBottomLeft =Boolean.FALSE;
    private Boolean hasBottomRight =Boolean.FALSE;
    private Boolean hasLeftflipper =Boolean.FALSE;
    private Boolean hasRightflipper =Boolean.FALSE;
    private Boolean hasLeftscoop =Boolean.FALSE;
    private Boolean hasRightscoop =Boolean.FALSE;
    private Boolean hasleftRoly =Boolean.FALSE;
    private Boolean hasrightRoly =Boolean.FALSE;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        try{
            TopLeft  = hardwareMap.get(DcMotor.class, "Top_Left");
            TopLeft.setDirection(DcMotor.Direction.FORWARD);
            hasTopLeft = Boolean.TRUE;
            telemetry.addData("TopLeft", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("TopLeft", "Failed");
        }


        try{
            TopRight  = hardwareMap.get(DcMotor.class, "Top_Right");
            hasTopRight = Boolean.TRUE;
            telemetry.addData("TopRight", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("TopRight", "Failed");
        }


        try{
            BottomRight  = hardwareMap.get(DcMotor.class, "Bottom_Right");
            hasBottomRight = Boolean.TRUE;
            BottomRight.setDirection(DcMotor.Direction.REVERSE);
            telemetry.addData("BottomRight", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("BottomRight", "Failed");
        }


        try{
            BottomLeft  = hardwareMap.get(DcMotor.class, "Bottom_Left");
            hasBottomLeft = Boolean.TRUE;
            BottomLeft.setDirection(DcMotor.Direction.FORWARD);
            telemetry.addData("BottomLeft", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("BottomLeft", "Failed");
        }
        try{
            BottomLeft  = hardwareMap.get(DcMotor.class, "Bottom_Left");
            hasBottomLeft = Boolean.TRUE;
            BottomLeft.setDirection(DcMotor.Direction.FORWARD);
            telemetry.addData("BottomLeft", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("BottomLeft", "Failed");
        }

        try{
            Leftflipper  = hardwareMap.get(Servo.class, "left_flipper");
            hasLeftflipper = Boolean.TRUE;
            telemetry.addData("Leftflipper", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("Leftflipper", "Failed");
        }
        try{
            Rightflipper  = hardwareMap.get(Servo.class, "right_flipper");
            hasRightflipper = Boolean.TRUE;
            telemetry.addData("Rightflipper", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("Rightflipper", "Failed");
        }
        try{
            Leftscoop  = hardwareMap.get(Servo.class, "left_scoop");
            hasLeftscoop = Boolean.TRUE;
            telemetry.addData("Leftscoop", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("Leftscoop", "Failed");
        }
        try{
            Rightscoop  = hardwareMap.get(Servo.class, "right_scoop");
            hasRightscoop = Boolean.TRUE;
            telemetry.addData("Rightscoop", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("Rightscoop", "Failed");
        }
        try{
            leftRoly  = hardwareMap.get(DcMotor.class, "left_Roly");
            hasleftRoly = Boolean.TRUE;
            leftRoly.setDirection(DcMotor.Direction.FORWARD);
            telemetry.addData("leftRoly", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("leftRoly", "Failed");
        }
        try{
            rightRoly  = hardwareMap.get(DcMotor.class, "right_Roly");
            hasrightRoly = Boolean.TRUE;
            rightRoly.setDirection(DcMotor.Direction.REVERSE);
            telemetry.addData("rightRoly", "Initialized");
        }
        catch (IllegalArgumentException iax)  {
            telemetry.addData("rightRoly", "Failed");
        }

//        // Initialize the hardware variables. Note that the strings used here as parameters
//        // to 'get' must correspond to the names assigned during the robot configuration
//        // step (using the FTC Robot Controller app on the phone).
//        BottomLeft  = hardwareMap.get(DcMotor.class, "left_drive");
//        BottomRight = hardwareMap.get(DcMotor.class, "right_drive");
//        TopLeft = hardwareMap.get(DcMotor.class, "right_drive");
//        TopRight = hardwareMap.get(DcMotor.class, "right_drive");
//
//        // Most robots need the motor on one side to be reversed to drive forward
//        // Reverse the motor that runs backwards when connected directly to the battery
//        leftDrive.setDirection(DcMotor.Direction.FORWARD);
//        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Bot", "Initialized");
        telemetry.addData("init", "Loop");
        telemetry.addData("10101001101","THE BOT IS WORKING 01101010101010101");
    }

    /*
     * Code to run REPEATEDLY after the driv
     * er hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
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

        double LeftRight = gamepad1.left_stick_x;
        double Forwardbackward = -gamepad1.left_stick_y;
        double Turning = -gamepad1.right_stick_x;
        double LeftTrigger = gamepad1.left_trigger * 0.7;
        double RightTrigger = gamepad1.right_trigger * 0.3;
        double Angle;
        double gamepad2LeftFlipper = gamepad2.left_trigger;
        double gamepad2RightFlipper = gamepad2.right_trigger;
        double gamepad2LeftScoop = -gamepad2.left_stick_y;
        double gamepad2RightScoop = -gamepad2.right_stick_y;
        double rolliOut = gamepad2.dpad_up;
        double rolliIn = gamepad2.dpad_down;
        double FrontRightPower = 0;
        double FrontLeftPower = 0;
        double BackRightPower = 0;
        double BackLeftPower = 0;

        //this is getting rid of negative zero yay!
        if(LeftRight > -0.000001 && LeftRight < 0.000001){
            LeftRight = 0;
        }
        if(Forwardbackward > -0.000001 && Forwardbackward < 0.000001){
            Forwardbackward = 0;
        }
        if(Turning > -0.000001 && Turning < 0.000001){
            Turning = 0;
        }
        if(LeftTrigger > -0.000001 && LeftTrigger < 0.000001){
            LeftTrigger = 0;
        }
        if(RightTrigger > -0.000001 && RightTrigger < 0.000001){
            RightTrigger = 0;
        }
        if(LeftRight > -0.000001 && LeftRight < 0.000001){
            LeftRight = 0;

        }
        if(gamepad2LeftScoop < 0.2){
            gamepad2LeftScoop = 0.2;
        }

        if(gamepad2RightScoop > 0.5){
            gamepad2RightScoop = 0.5 ;
        }
        else if(gamepad2RightScoop < -0.5){
            gamepad2RightScoop = - 0.5 ;
        }

        Angle = Math.toDegrees(Math.atan2(LeftRight,Forwardbackward));

        if(Angle < 0 ){
            Angle = Angle+360;
        }
        if (Math.abs(LeftRight)+Math.abs(Forwardbackward)< 0.8){
            FrontLeftPower =0;
            FrontRightPower =0;
            BackRightPower =0;
            BackLeftPower =0;
        }
        else {


            FrontLeftPower = Math.cos(Math.toRadians(Angle-45));

            FrontRightPower = Math.cos(Math.toRadians(Angle+45));

            BackLeftPower = Math.cos(Math.toRadians(Angle-135));

            BackRightPower = -Math.cos(Math.toRadians(Angle+135));

        }

        // scale the direction by power buttons
        FrontLeftPower = FrontLeftPower*(RightTrigger + LeftTrigger);
        FrontRightPower = FrontRightPower*(RightTrigger + LeftTrigger);
        BackLeftPower = BackLeftPower* (RightTrigger + LeftTrigger);
        BackRightPower =  BackRightPower* (RightTrigger + LeftTrigger);

        // scaling the turn by power buttons
        FrontLeftPower +=  Turning *(RightTrigger + LeftTrigger);
        FrontRightPower += -Turning *(RightTrigger + LeftTrigger);
        BackLeftPower += Turning * (RightTrigger + LeftTrigger);
        BackRightPower +=  -Turning * (RightTrigger + LeftTrigger);

        ArrayList<Double> Box = new ArrayList<>();
        Box.add(Math.abs(FrontLeftPower));
        Box.add(Math.abs(FrontRightPower));
        Box.add(Math.abs(BackLeftPower));
        Box.add(Math.abs(BackRightPower));
        double biggest = Collections.max(Box);

        if(biggest > 1) {
            FrontRightPower = BackLeftPower / biggest;
            FrontLeftPower = BackLeftPower / biggest;
            BackRightPower = BackLeftPower / biggest;
            BackLeftPower = BackLeftPower / biggest;
        }


        if(hasTopLeft) {
            TopLeft.setPower(FrontLeftPower);
        }
        if(hasTopRight) {
            TopRight.setPower(FrontRightPower);
        }
        if(hasBottomLeft) {
            BottomLeft.setPower(BackLeftPower);
        }
        if(hasBottomRight) {
            BottomRight.setPower(BackRightPower);
        }
        if(hasLeftflipper) {
            Leftflipper.setPosition(gamepad2LeftFlipper);
        }
        if(hasRightflipper) {
            Rightflipper.setPosition(gamepad2RightFlipper);
        }
        if(hasLeftscoop) {
            Leftscoop.setPosition(gamepad2LeftScoop);
        }
        if(hasRightscoop) {
            Rightscoop.setPosition(gamepad2RightScoop);
        }
        if(hasleftRoly){
            leftRoly.setPower (rolyOut + rolyIn)
        }
        if(hasrightRoly) {
            rightRoly.setPower (rolyOut + rolyIn)
        }





        telemetry.addData("left_stick_x", LeftRight);
        telemetry.addData("left_stick_y", Forwardbackward);
        telemetry.addData("right_stick_x", Turning);
        telemetry.addData("left_trigger", LeftTrigger);
        telemetry.addData("right_trigger", RightTrigger);
        telemetry.addData("LeftStick_Degrees", Angle);
        telemetry.addData("MotorPower","Left Front(%.2f), Right Front (%.2f)", FrontLeftPower, FrontRightPower);
        telemetry.addData("MotorPower","Left Back(%.2f), Right Back (%.2f)", BackLeftPower, BackRightPower);
        telemetry.addData("ScoopPotiton","Left (%.2f), Right (%.2f)", gamepad2LeftScoop, gamepad2RightScoop);
        telemetry.addData("FlipperPotiton","Left (%.2f), Right (%.2f)", gamepad2LeftFlipper, gamepad2RightFlipper);
        telemetry.addData("rolliMotors","Left (%.2f), Right (%.2f)", rolyOut + rolyIn, rolyOut + rolyIn);
    }

    @Override
    public void stop() {
    }

}