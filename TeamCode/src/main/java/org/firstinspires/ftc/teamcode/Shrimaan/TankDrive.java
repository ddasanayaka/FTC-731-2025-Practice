package org.firstinspires.ftc.teamcode.Shrimaan;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class TankDrive extends OpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    @Override
    public void init() {
        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor = hardwareMap.get(DcMotor.class, "right");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double left_Power = -gamepad1.left_stick_y;
        double right_Power = -gamepad1.right_stick_y;

        leftMotor.setPower(left_Power);
        rightMotor.setPower(right_Power);
    }
}
