package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class TelemetryDisplay extends OpMode {
    public void init() {
    }

    public void loop() {
        telemetry.addData("A button", gamepad1.a);

    }
}
