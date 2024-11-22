package org.firstinspires.ftc.teamcode.Dilan;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ScoringMechConstructor {
    final DcMotorEx slideMotor;
    int TICKS_PER_INCH;

    /**
     * Initializes scoring mech motors and sets directions and run modes
     * @param hardwareMap used to create scoring mech hardware objects
     */
    public ScoringMechConstructor(HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotorEx.class,"motor");
        // Set the motor direction if needed
        slideMotor.setDirection(DcMotor.Direction.FORWARD);
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveToPosition(double inches, double speed) {
        int targetPosition = (int) (inches * TICKS_PER_INCH);
        slideMotor.setTargetPosition(targetPosition);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(speed);

        // Wait for the motor to reach the target position
        while (slideMotor.isBusy()) {}

        // Stop the motor after reaching the target
        slideMotor.setPower(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extend(double inches, double speed) {
        moveToPosition(inches, speed);
    }

    public void retract(double inches, double speed) {
        moveToPosition(-inches, speed);
    }

    /**
     * Returns slides to position set on initialization
     * @param speed speed the slides retract
     */
    public void fullRetract(double speed) {
        slideMotor.setTargetPosition(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(speed);
        while (slideMotor.isBusy()) {}
        slideMotor.setPower(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /**
     * Immediately halts slide motion
     */
    public void stop() {
        slideMotor.setPower(0);
    }

    /**
     * Provides slide position in ticks
     * @return slide motor position in ticks
     */
    public int currentPosition() {
        return slideMotor.getCurrentPosition();
    }

    /**
     * Constantly extends slides while active
     * @param speed speed the slides extend
     * @param isActive proof of method activation
     */
    public void constantExtend(double speed, boolean isActive) {
        if (isActive) {
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(speed);
        }else {
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(0);
        }
    }

    /**
     * Constantly retracts slides while active
     * @param speed speed the slides retract
     * @param isActive proof of method activation
     */
    public void constantRetract(double speed, boolean isActive) {
        if (isActive) {
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(-speed);
        }else {
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(0);
        }
    }
}

