package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "Alex")
@Disabled
public class RotateServo extends OpMode {
    private Servo servo;
    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "servo");

    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            servo.setPosition(0.5);
        }
        if(gamepad1.x) {
            servo.setPosition(0.2);
        }
    }

}
