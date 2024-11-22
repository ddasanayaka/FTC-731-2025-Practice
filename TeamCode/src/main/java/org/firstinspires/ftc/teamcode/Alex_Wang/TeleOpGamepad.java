package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Ernest.GamepadButton;

@TeleOp(group = "Alex")
public class TeleOpGamepad extends OpMode {
@Override
    public void init() {
}

int a = 1;
@Override
    public void loop() {
    if (gamepad1.a) {
        a = a + 1;
        telemetry.addData("A is ", a);
    }
    if (gamepad1.b) {
        a = a - 1;
        telemetry.addData("A is ", a);
    }

} }

