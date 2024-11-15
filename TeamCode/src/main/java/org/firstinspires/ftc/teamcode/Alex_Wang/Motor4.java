package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Motor4 extends OpMode {
    private DcMotor motor, motor2;
    public void init() {
    }

    public void loop() {
        if (gamepad1.dpad_left) {
            if (gamepad1.a) {
                motor.setPower(0.5);
                motor2.setPower(0.5);
            }
            else if (gamepad1.b) {
                motor.setPower(0.5);
                motor2.setPower(0.5);
            }
        }
        else if(gamepad1.a) {
            motor.setPower(1);
        }
        else if (gamepad1.b) {
            motor2.setPower(1);
        }

    }
}
