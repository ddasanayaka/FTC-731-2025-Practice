package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(group = "Alex")
@Disabled
public class Motor4 extends OpMode {
    private DcMotor motor, motor2;
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
    }

    public void loop() {
        if (gamepad1.left_trigger != 0) {
            if (gamepad1.a) {
                motor.setPower(0.5);
                if (gamepad1.b) {
                    motor2.setPower(0.5);
                }
            }
            else if (gamepad1.b) {
                motor2.setPower(0.5);
            }
            else {
                motor.setPower(0);
                motor2.setPower(0);
            }
        }
        else if (gamepad1.a) {
            motor.setPower(1);
            if (gamepad1.b) {
                motor2.setPower(1);
            }
        }
        else if (gamepad1.b) {
            motor2.setPower(1);
        }
        else {
            motor.setPower(0);
            motor2.setPower(0);
        }

    }
}
