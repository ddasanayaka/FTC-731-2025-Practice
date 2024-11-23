package org.firstinspires.ftc.teamcode.Advanced_Practices.Practice_0;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This is a simplified version of the BasicPracticeFinal (just a 4-motor mecanum drive)

@Disabled
@TeleOp
public class MethodMecanum extends OpMode {
    private DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

    @Override
    public void init() {
        // Method is called here, temporarily move to the createMotors method
        // init() is an overriden OpMode method, thus it can use hardwareMap (that's why it's purple)
        createMotors(hardwareMap);
    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        // The gamepad inputs above are passed into this method
        drive(forward,strafe,rotate);
    }

    // This method does everything that needs to be done regarding drivetrain motors in init()
                             // The parameter for this method is of type "HardwareMap"
                             // Since "hardwareMap" is part of OpMode, only OpMode methods (init(), init_loop(), start(), loop(), stop()) can use it
    private void createMotors(HardwareMap hardwareMap) {
        leftFrontMotor = hardwareMap.get(DcMotor.class,"leftFront");
        leftBackMotor = hardwareMap.get(DcMotor.class,"leftBack");
        rightFrontMotor = hardwareMap.get(DcMotor.class,"rightFront");
        rightBackMotor = hardwareMap.get(DcMotor.class,"rightBack");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);

        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Once the method is done, return to the place it was called
    }

    // This method normalizes and sets the powers of the drivetrain motors
    private void drive(double forward, double strafe, double rotate) {
        double frontLeftPower = forward + strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double backLeftPower = forward - strafe + rotate;
        double backRightPower = forward + strafe - rotate;

        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;

        // setPower is a method
        leftFrontMotor.setPower(frontLeftPower);
        leftBackMotor.setPower(frontRightPower);
        rightFrontMotor.setPower(backLeftPower);
        rightBackMotor.setPower(backRightPower);

        // Once the method is done, return to the place it was called
    }
}