package org.firstinspires.ftc.teamcode.Dilan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private final int slowModeFactor = 3;

    /**
     * Initializes drivetrain motors and sets directions and run modes
     * @param hardwareMap used create drivetrain hardware objects
     */
    public void initialize(HardwareMap hardwareMap) {
        frontLeftMotor = hardwareMap.dcMotor.get("leftFront");
        frontRightMotor = hardwareMap.dcMotor.get("rightFront");
        backLeftMotor = hardwareMap.dcMotor.get("leftBack");
        backRightMotor = hardwareMap.dcMotor.get("rightBack");

        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /**
     * Normalizes drivetrain motor powers
     * @param frontLeftPower unnormalized power for front left wheel
     * @param frontRightPower unnormalized power for front right wheel
     * @param backLeftPower unnormalized power for back left wheel
     * @param backRightPower unnormalized power for back right wheel
     * @param slowMode is slow mode active
     */
    private void setPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, boolean slowMode) {
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;

        if (slowMode) {
            frontLeftMotor.setPower(frontLeftPower / slowModeFactor);
            frontRightMotor.setPower(frontRightPower / slowModeFactor);
            backLeftMotor.setPower(backLeftPower / slowModeFactor);
            backRightMotor.setPower(backRightPower / slowModeFactor);
        }
        else {
            frontLeftMotor.setPower(frontLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backLeftMotor.setPower(backLeftPower);
            backRightMotor.setPower(backRightPower);
        }
    }

    /**
     * Converts analog inputs to mecanum wheel inputs
     * @param forward amount of forward motion of robot
     * @param lateral amount of lateral motion of robot
     * @param rotate amount of rotational motion of robot
     * @param slowMode is slow mode active
     */
    public void drive(double forward, double lateral, double rotate, boolean slowMode) {
        double frontLeftPower = forward + lateral + rotate;
        double frontRightPower = forward - lateral - rotate;
        double backLeftPower = forward - lateral + rotate;
        double backRightPower = forward + lateral - rotate;

        setPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower, slowMode);
    }
}

