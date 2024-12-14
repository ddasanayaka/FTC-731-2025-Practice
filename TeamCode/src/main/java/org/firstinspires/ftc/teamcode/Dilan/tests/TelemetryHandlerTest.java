package org.firstinspires.ftc.teamcode.Dilan.tests;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TelemetryHandler;

@TeleOp(group = "test")
public class TelemetryHandlerTest extends OpMode {
    TelemetryHandler telemetryHandler = new TelemetryHandler(telemetry);
    int i = 0;

    @Override
    public void init() {}

    @Override
    public void loop() {
        telemetryHandler.addData("Graph",i);
        Canvas canvas = telemetryHandler.fieldOverlay();
        canvas.setStroke("#00FF00");
        canvas.setStrokeWidth(1);
        canvas.strokeLine(0,0,10,10);
        telemetryHandler.update();
        i++;
    }
}
