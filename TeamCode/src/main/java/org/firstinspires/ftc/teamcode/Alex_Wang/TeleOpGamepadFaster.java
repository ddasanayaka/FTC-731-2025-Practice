package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Ernest.GamepadButton;

@TeleOp()
public class TeleOpGamepadFaster extends OpMode {
    @Override
    public void init() {
    }

    int a = 1;
    @Override
    public void loop() {
        telemetry.addData(String.valueOf(a * 1000000000), gamepad1.a);
        telemetry.addData(String.valueOf(a - 1), gamepad1.b);
    } }

