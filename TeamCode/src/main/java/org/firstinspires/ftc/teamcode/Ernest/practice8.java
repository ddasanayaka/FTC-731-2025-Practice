package org.firstinspires.ftc.teamcode.Ernest;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(group = "Ernest")

public class practice8 extends OpMode {

    Servo servo;

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        servo = hardwareMap.get(Servo.class, "servo");

        if (gamepad1.a) {
            servo.setPosition(0.2);
        }

        if (gamepad1.x) {
            servo.setPosition(1);
        }
    }

}
