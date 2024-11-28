package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// TODO: There is 1 mistake in the code, find it, correct it, and explain what difference it makes. Hints are at the bottom
// Line number of mistake: idk
// Difference: other way rotation?

// Assume that the control hub use is connected to 4 motors which don't have encoders, and there is no other hardware connected
// Assume that moving the left stick up moves the bot forward, right moves the bot right, and moving the right stick right makes the bot rotate right
// The above controls are standard for FTC

// TODO: What must the names of the motors on the configuration file be?
// Answer: leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor

// TODO: Will this OpMode show up on the Driver Hub?
// Answer: no (because it is disabled)
@Disabled
@TeleOp
public final class BasicPracticeFinal extends OpMode {
    // TODO: What is happening in the following 2 lines?
    // Answer: the dc motors are being named, and the runtime double variable is established
    private DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
    private double runtime;

    @Override
    public void init() {
        // TODO: What is happening in the following 4 lines?
        // Answer: the motors previously named are associated with the motors connected to the control hub
        leftFrontMotor = hardwareMap.get(DcMotor.class,"leftFront");
        leftBackMotor = hardwareMap.get(DcMotor.class,"leftBack");
        rightFrontMotor = hardwareMap.get(DcMotor.class,"rightFront");
        rightBackMotor = hardwareMap.get(DcMotor.class,"rightBack");

        // TODO: What is happening in the following 4 lines and why are they needed?
        // Answer: the motors are given directions - 2 motors are facing the other way (in order to have 4 motors organized symmetrically), so 2 motors (right motors) are set to reverse direction here so that we don't have to do it later on in the code and the robot can move forward when all motors have the same input
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        // TODO: Which of the previous 4 lines are unnecessary
        // Answer: the right motors because they are already default set to forward

        // TODO: Should the motors follow RunMode "RUN_USING_ENCODER"?
        // Answer: yes, because without an encoder the robot may no move in its intended path
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void init_loop() {
        // TODO: What do the following lines do?
        // Answer: it prints out "Time in INIT" and then the runtime on the controller screen thing
        runtime = getRuntime();
        telemetry.addData("Time in INIT",runtime);
    }

    @Override
    public void start() {
        // TODO: What does the following line do?
        // Answer: the runtime and the timer on the screen reset
        resetRuntime();
    }

    @Override
    public void loop() {
        // TODO: What is happening in the following 3 lines?
        // Answer: it assigns double variables to inputs that the robot can recieve via the gamepad
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_y;

        // These are the equations that define motion for mecanum wheels
        // You can look up the calculations if you want, but all you need to do is copy them down in a mecanum drive class
        double frontLeftPower = forward + strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backLeftPower = forward - strafe + rotate;
        double backRightPower = forward + strafe - rotate;

        // Since the wheel powers are comprised of multiple inputs, the power set to the motors must be normalized (lines 81-90)
        // TODO: What range of inputs must the motor power be set to?
        // Answer: -1 to 1
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
        // Answer: the motors are set to the power provided by some previously defined double variables
        leftFrontMotor.setPower(frontLeftPower);
        leftBackMotor.setPower(frontRightPower);
        rightFrontMotor.setPower(backLeftPower);
        rightBackMotor.setPower(backRightPower);

        // TODO: What is happening in the following 3 lines?
        // Answer: it prints out the forward, strafe, and rotate values that are recieved from the gamepad
        telemetry.addData("Forward",forward);
        telemetry.addData("Strafe",strafe);
        telemetry.addData("Rotate",rotate);

        // TODO: What is happening in the following 2 lines?
        // Answer: it prints the runtime on the screen thing after putting the runtime in a variable
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