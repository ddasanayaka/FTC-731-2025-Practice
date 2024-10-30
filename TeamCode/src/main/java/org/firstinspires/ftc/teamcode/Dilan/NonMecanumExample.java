package org.firstinspires.ftc.teamcode.Dilan;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class NonMecanumExample extends OpMode {
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get("leftFront");
        frontRightMotor = hardwareMap.dcMotor.get("rightFront");
        backLeftMotor = hardwareMap.dcMotor.get("leftBack");
        backRightMotor = hardwareMap.dcMotor.get("rightBack");

        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;

        frontLeftMotor.setPower(forward);
        frontRightMotor.setPower(forward);
        backLeftMotor.setPower(forward);
        backRightMotor.setPower(forward);
    }
}
