package org.firstinspires.ftc.teamcode.Dilan.tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TelemetryHandler;

@TeleOp(group = "test")
public class TelemetryHandlerTest extends OpMode {
    TelemetryHandler telemetryHandler = new TelemetryHandler(telemetry);
    @Override
    public void init() {
        telemetryHandler.addData("Working","working more");
    }

    @Override
    public void loop() {

    }
}
