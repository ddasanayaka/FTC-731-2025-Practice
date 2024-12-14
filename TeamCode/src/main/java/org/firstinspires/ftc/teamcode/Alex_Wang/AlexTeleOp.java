package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (group = "Alex")
@Disabled
public class AlexTeleOp extends OpMode {
    private DcMotor motor, motor2;
    private Servo servo;
    double Position;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        servo = hardwareMap.get(Servo.class, "servo");
    }

    @Override
    public void loop() {
        Position = -gamepad1.left_stick_y;
        if(gamepad1.left_trigger != 0) {
            servo.setPosition(Position);
            if(gamepad1.a) {
                motor.setPower(1);
                motor2.setPower(1);
            }
            else if(gamepad1.b) {
                motor.setPower(0.5);
                motor2.setPower(1);
            }
            else if(gamepad1.x) {
                motor.setPower(-0.5);
                motor2.setPower(1);
            }
            else if(gamepad1.y) {
                motor.setPower(-1);
                motor2.setPower(1);
            }
            else {
                motor.setPower(0);
                motor2.setPower(0);
            }
        }
        else {
            servo.setPosition(0);
            if(gamepad1.a) {
                motor.setPower(1);
                motor2.setPower(-1);
            }
            else if (gamepad1.b) {
                motor.setPower(0.5);
                motor2.setPower(-1);
            }
            else if (gamepad1.x) {
                motor.setPower(-0.5);
                motor2.setPower(-1);
            }
            else if (gamepad1.y) {
                motor.setPower(-1);
                motor2.setPower(-1);
            }
            else {
                motor.setPower(0);
                motor2.setPower(0);
            }
        }
    }
}
