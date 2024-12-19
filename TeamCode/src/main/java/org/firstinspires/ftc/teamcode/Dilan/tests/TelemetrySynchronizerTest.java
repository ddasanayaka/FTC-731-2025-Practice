package org.firstinspires.ftc.teamcode.Dilan.tests;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

@TeleOp(group = "test")
public class TelemetrySynchronizerTest extends OpMode {
    TelemetrySynchronizer telemetrySynchronizer = new TelemetrySynchronizer(telemetry);
    int i = 0;

    @Override
    public void init() {}

    @Override
    public void loop() {
        telemetrySynchronizer.addData("Graph",i);
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addLine(1e-3);
        Canvas canvas = telemetrySynchronizer.fieldOverlay();
        canvas.setStroke("#00FF00");
        canvas.setStrokeWidth(1);
        canvas.strokeLine(0,0,10,10);
        telemetrySynchronizer.update();
        i++;
    }
}
