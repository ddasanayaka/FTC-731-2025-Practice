package org.firstinspires.ftc.teamcode.Dilan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ScoringMech {
    DcMotor leftSlideMotor, rightSlideMotor;
    Servo leftLiftServo, rightLiftServo, liftClawServo;
    Servo linkLeftServo, linkRightServo, linkClawServo, linkClawLeftServo, linkClawRightServo;
    public static double TICKS_PER_INCH;

    /**
     * Initializes scoring mech motors and sets directions and run modes
     * @param hardwareMap used to create scoring mech hardware objects
     */
    public void initialize(HardwareMap hardwareMap) {
        leftSlideMotor = hardwareMap.get(DcMotor.class,"motor");
        rightSlideMotor = hardwareMap.get(DcMotor.class,"motor2");

        leftSlideMotor.setDirection(DcMotor.Direction.REVERSE);
        leftSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightSlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveToPosition(double inches, double speed) {
        int targetPosition = (int) (inches * TICKS_PER_INCH);
        leftSlideMotor.setTargetPosition(targetPosition);
        leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftSlideMotor.setPower(speed);

        // Wait for the motor to reach the target position
        while (leftSlideMotor.isBusy()) {

        }

        // Stop the motor after reaching the target
        leftSlideMotor.setPower(0);
        leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /**
     * Returns slides to position set on initialization
     * @param speed speed the slides retract
     */
    public void fullRetract(double speed) {
        leftSlideMotor.setTargetPosition(0);
        rightSlideMotor.setTargetPosition(0);
        leftSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftSlideMotor.setPower(speed);
        rightSlideMotor.setPower(speed);
        while (leftSlideMotor.isBusy() && rightSlideMotor.isBusy()) {}
        leftSlideMotor.setPower(0);
        rightSlideMotor.setPower(0);
        leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //if (leftSlideMotor.getCurrentPosition() > 20) {}
    }

    /**
     * Immediately halts slide motion
     */
    public void stop() {
        leftSlideMotor.setPower(0);
        rightSlideMotor.setPower(0);
    }

    /**
     * Provides slide position in ticks
     * @return slide motor position in ticks
     */
    public int currentPosition() {
        return leftSlideMotor.getCurrentPosition();
    }

    /**
     * Constantly extends slides while active
     * @param speed speed the slides extend
     * @param isActive proof of method activation
     */
    public void constantExtend(double speed, boolean isActive) {
        if (isActive) {
            leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftSlideMotor.setPower(speed);
            rightSlideMotor.setPower(speed);
        } else {
            leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftSlideMotor.setPower(0);
            rightSlideMotor.setPower(0);
        }
    }

    /**
     * Constantly retracts slides while active
     * @param speed speed the slides retract
     * @param isActive proof of method activation
     */
    public void constantRetract(double speed, boolean isActive) {
        if (isActive) {
            leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftSlideMotor.setPower(-speed);
            rightSlideMotor.setPower(-speed);
        } else {
            leftSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            leftSlideMotor.setPower(0);
            rightSlideMotor.setPower(0);
        }
    }
}

