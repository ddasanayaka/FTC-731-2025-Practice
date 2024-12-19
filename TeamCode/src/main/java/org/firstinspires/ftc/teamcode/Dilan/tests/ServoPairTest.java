package org.firstinspires.ftc.teamcode.Dilan.tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

@Config
@TeleOp(group = "test")
@Disabled
public class ServoPairTest extends OpMode {
    Servo servo1, servo2;
    public static double pos;
    TelemetrySynchronizer telemetrySynchronizer = new TelemetrySynchronizer(telemetry);

    @Override
    public void init() {
        servo1 = hardwareMap.get(Servo.class,"servo");
        servo2 = hardwareMap.get(Servo.class,"servo2");
        servo2.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        servo1.setPosition(pos);
        servo2.setPosition(pos);
        telemetrySynchronizer.addData("Positions",servo1.getPosition(),servo2.getPosition());
    }
}
