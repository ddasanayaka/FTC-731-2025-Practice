package org.firstinspires.ftc.teamcode.Dilan;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class MecanumDrive {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    public static double configTest = 1;

    /**
     * Initializes drivetrain motors and sets directions and run modes
     * @param hardwareMap used create drivetrain hardware objects
     */
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
     * Normalizes drivetrain motor powers
     * @param frontLeftPower unnormalized power for front left wheel
     * @param frontRightPower unnormalized power for front right wheel
     * @param backLeftPower unnormalized power for back left wheel
     * @param backRightPower unnormalized power for back right wheel
     * @param slowModeScalar activates slow mode at provided value
     */
    private void setPowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, double slowModeScalar) {
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;


        frontLeftMotor.setPower(frontLeftPower * slowModeScalar * configTest);
        frontRightMotor.setPower(frontRightPower * slowModeScalar * configTest);
        backLeftMotor.setPower(backLeftPower * slowModeScalar * configTest);
        backRightMotor.setPower(backRightPower * slowModeScalar * configTest);
    }

    /**
     * Converts analog inputs to mecanum wheel inputs
     * @param forward amount of forward motion of robot
     * @param lateral amount of lateral motion of robot
     * @param rotate amount of rotational motion of robot
     * @param slowModeScalar activates slow mode at provided value
     */
    public void drive(double forward, double lateral, double rotate, double slowModeScalar) {
        double frontLeftPower = forward + lateral + rotate;
        double frontRightPower = forward - lateral - rotate;
        double backLeftPower = forward - lateral + rotate;
        double backRightPower = forward + lateral - rotate;

        setPowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower, slowModeScalar);
    }
}

