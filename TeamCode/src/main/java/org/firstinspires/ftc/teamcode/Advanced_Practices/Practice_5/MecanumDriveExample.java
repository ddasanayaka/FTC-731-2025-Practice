package org.firstinspires.ftc.teamcode.Advanced_Practices.Practice_5;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This is not an OpMode, the OpMode you make in advanced practice 5 will call methods from a class similar to this
public class MecanumDriveExample {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    /**
     * Method that creates and defaults motors
     */
    // Should be called in init()
    public void initialize(HardwareMap hardwareMap) {
        frontLeftMotor = hardwareMap.get(DcMotor.class,"leftFront");
        frontRightMotor = hardwareMap.get(DcMotor.class,"rightFront");
        backLeftMotor = hardwareMap.get(DcMotor.class,"leftBack");
        backRightMotor = hardwareMap.get(DcMotor.class,"rightBack");

        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /**
     * Method that normalizes drivetrain motor powers
     * @param frontLeftPower unnormalized front left motor power
     * @param frontRightPower unnormalized front right motor power
     * @param backLeftPower unnormalized back left motor power
     * @param backRightPower unnormalized back right motor power
     */
    // This is a private method that is called by the drive() method in this class
    // You don't have to separate these methods
    private void setPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;


        frontLeftMotor.setPower(frontLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backLeftMotor.setPower(backLeftPower);
        backRightMotor.setPower(backRightPower);
    }

    /** Method that converts inputs to wheel powers
     * @param forward forward and backward robot velocity
     * @param lateral lateral robot velocity
     * @param rotate angular robot velocity
     */
    // Should be called repeatedly in loop()
    // Inputs should be gamepad stick values
    public void drive(double forward, double lateral, double rotate) {
        double frontLeftPower = forward + lateral + rotate;
        double frontRightPower = forward - lateral - rotate;
        double backLeftPower = forward - lateral + rotate;
        double backRightPower = forward + lateral - rotate;

        setPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }
}

