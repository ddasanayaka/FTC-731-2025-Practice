package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// TODO: There is 1 mistake in the code, find it, correct it, and explain what difference it makes. Hints are at the bottom
// Line number of mistake: 74
// Difference: double strafe = -gamepad1.left_stick_y;

// Assume that the control hub use is connected to 4 motors which don't have encoders, and there is no other hardware connected
// Assume that moving the left stick up moves the bot forward, right moves the bot right, and moving the right stick right makes the bot rotate right
// The above controls are standard for FTC

// TODO: What must the names of the motors on the configuration file be?
// Answer: leftFront, leftBack, rightFront, rightBack

// TODO: Will this OpMode show up on the Driver Hub?
// Answer: No, because it is disabled.
@Disabled
@TeleOp
public final class BasicPracticeFinal extends OpMode {
    // TODO: What is happening in the following 2 lines?
    // Answer: The motors are being created and a double called "runtime" is also being created.
    private DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
    private double runtime;

    @Override
    public void init() {
        // TODO: What is happening in the following 4 lines?
        // Answer: The four motors are being taken from the hardware map and are being configured
        leftFrontMotor = hardwareMap.get(DcMotor.class,"leftFront");
        leftBackMotor = hardwareMap.get(DcMotor.class,"leftBack");
        rightFrontMotor = hardwareMap.get(DcMotor.class,"rightFront");
        rightBackMotor = hardwareMap.get(DcMotor.class,"rightBack");

        // TODO: What is happening in the following 4 lines and why are they needed?
        // Answer: The motors' direction are being set to spin a specific way
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        // TODO: Which of the previous 4 lines are unnecessary
        // Answer: The two right motors, as the default spin is set to forward

        // TODO: Should the motors follow RunMode "RUN_USING_ENCODER"?
        // Answer: Yes as running without encoder may lead to the bot eventually straying off or being uncontrolled
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void init_loop() {
        // TODO: What do the following lines do?
        // Answer: Prints out a specific value "Time in INIT" and then the runtime
        runtime = getRuntime();
        telemetry.addData("Time in INIT",runtime);
    }

    @Override
    public void start() {
        // TODO: What does the following line do?
        // Answer: Once it starts, the run time and, in extension, the timer are reset
        resetRuntime();
    }

    @Override
    public void loop() {
        // TODO: What is happening in the following 3 lines?
        // Answer: Setting multiple double values to specific inputs on the gamepad (left stick y, left stick x, right stick x)
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        // These are the equations that define motion for mecanum wheels
        // You can look up the calculations if you want, but all you need to do is copy them down in a mecanum drive class
        double frontLeftPower = forward + strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backLeftPower = forward - strafe + rotate;
        double backRightPower = forward + strafe - rotate;

        // Since the wheel powers are comprised of multiple inputs, the power set to the motors must be normalized (lines 81-90)
        // TODO: What range of inputs must the motor power be set to?
        // Answer: From -1 to 1 (-1 and 1 are highest power in opposite spinning directions)
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;

        // TODO: What is happening in the following 4 lines?
        // Answer: The motors are getting their powers set to specific double values
        leftFrontMotor.setPower(frontLeftPower);
        leftBackMotor.setPower(frontRightPower);
        rightFrontMotor.setPower(backLeftPower);
        rightBackMotor.setPower(backRightPower);

        // TODO: What is happening in the following 3 lines?
        // Answer: Printing out captions to help with the process, giving the forward, strafe, and rotate values
        telemetry.addData("Forward",forward);
        telemetry.addData("Strafe",strafe);
        telemetry.addData("Rotate",rotate);

        // TODO: What is happening in the following 2 lines?
        // Answer: Taking the double run time and printing it out as a timer of sorts, giving the "Time" then the runtime
        runtime = getRuntime();
        telemetry.addData("Time",runtime);
    }
}

// Mistake Hints:








// The mistake is not in lines 1-23
// The mistake is not in lines 88-97
// Android Studio will not catch the mistake

// If you need a bigger hint, scroll down even farther
















































// Hint: Check gamepad inputs