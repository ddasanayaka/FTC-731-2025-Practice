package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// This OpMode is an example that allows a drivetrain to only move forwards and backwards
// This OpMode works on mecanum and non-mecanum wheels
@Disabled
@TeleOp
public class DrivetrainExample extends OpMode {
    // Creates DcMotor objects named "frontLeftMotor", "frontRightMotor", "backLeftMotor", and "backRightMotor"
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        // Assigns DcMotor objects to the physical motor
        frontLeftMotor = hardwareMap.get(DcMotor.class,"leftFront");
        frontRightMotor = hardwareMap.get(DcMotor.class,"rightFront");
        backLeftMotor = hardwareMap.get(DcMotor.class,"leftBack");
        backRightMotor = hardwareMap.get(DcMotor.class,"rightBack");

        // Reverses the directions of the motors on one side of the drivetrain because they are facing opposite directions
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        // Assigns a value "forward" to the y-axis position of the left stick
        // Note that the left stick can be pushed either direction, so "forward" can be either positive or negative
        double forward = -gamepad1.left_stick_y;

        // Sets the power of each motor to the "forward" value obtained above
        // Since "forward" can be either positive or negative, the robot can move either forward or backward
        frontLeftMotor.setPower(forward);
        frontRightMotor.setPower(forward);
        backLeftMotor.setPower(forward);
        backRightMotor.setPower(forward);
    }
}
