package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import java.util.ArrayList;

public class HardwareController {
    private final DcMotorEx leftFront, leftBack, rightFront, rightBack/*, leftLift, rightLift, leftHang, rightHang*/;
    //servos
    private final IMU imu;

    public HardwareController(HardwareMap hardwareMap) {
        // drivetrain motors
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
        rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
/*
        // lift motors
        leftLift = hardwareMap.get(DcMotorEx.class, "leftLiftMotor");
        rightLift = hardwareMap.get(DcMotorEx.class, "rightLiftMotor");

        rightLift.setDirection(DcMotorSimple.Direction.REVERSE);
        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // hang motors
        leftHang = hardwareMap.get(DcMotorEx.class, "leftHangMotor");
        rightHang = hardwareMap.get(DcMotorEx.class, "rightHangMotor");

        leftHang.setDirection(DcMotorSimple.Direction.REVERSE);
        leftHang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightHang.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
*/
        // imu params
        imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(orientation));
    }

    private void setDrivePowers(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower, double slowModeScalar) {
        double maxSpeed = 1.0;
        maxSpeed = Math.max(maxSpeed, Math.abs(frontLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(frontRightPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backLeftPower));
        maxSpeed = Math.max(maxSpeed, Math.abs(backRightPower));

        frontLeftPower /= maxSpeed;
        frontRightPower /= maxSpeed;
        backLeftPower /= maxSpeed;
        backRightPower /= maxSpeed;


        leftFront.setPower(frontLeftPower * slowModeScalar);
        rightFront.setPower(frontRightPower * slowModeScalar);
        leftBack.setPower(backLeftPower * slowModeScalar);
        rightBack.setPower(backRightPower * slowModeScalar);
    }

    public void drive(double forward, double lateral, double rotate, double slowModeScalar) {
        double frontLeftPower = forward + lateral + rotate;
        double frontRightPower = forward - lateral - rotate;
        double backLeftPower = forward - lateral + rotate;
        double backRightPower = forward + lateral - rotate;

        setDrivePowers(frontLeftPower, frontRightPower, backLeftPower, backRightPower, slowModeScalar);
    }

    public void forceLeftFront(double speed) {
        leftFront.setPower(speed);
    }
    public void forceLeftBack(double speed) {
        leftBack.setPower(speed);
    }
    public void forceRightFront(double speed) {
        rightFront.setPower(speed);
    }
    public void forceRightBack(double speed) {
        rightBack.setPower(speed);
    }
/*
    public void extendSlides(double speed, boolean isActive) {
        if (isActive) {
            leftLift.setPower(speed);
            rightLift.setPower(speed);
        } else {
            leftLift.setPower(0);
            rightLift.setPower(0);
        }
    }
    public void retractSlides(double speed, boolean isActive) {
        if (isActive) {
            leftLift.setPower(-speed);
            rightLift.setPower(-speed);
        } else {
            leftLift.setPower(0);
            rightLift.setPower(0);
        }
    }
*/
    public ArrayList<TestItem> getTests() {
        ArrayList<TestItem> tests = new ArrayList<>();
        tests.add(new TestMotor("Test Left Front Drivetrain Motor",0.5,leftFront,""));
        return tests;
    }
}
