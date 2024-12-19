package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;


public class TestServo extends TestItem{
    private final ServoImplEx servo;
    private final double min, max;

    public TestServo(String description, ServoImplEx servo, double min, double max, String title) {
        super(description,title);
        this.servo = servo;
        this.min = min;
        this.max = max;
    }

    public void run(boolean on, boolean other, TelemetrySynchronizer telemetrySynchronizer) {
        if (on) {
            servo.setPosition(min);
        } else if (other) {
            servo.setPosition(max);
        }
        telemetrySynchronizer.addData("Servo Config Name", servo.getDeviceName());
        telemetrySynchronizer.addData("Servo Port", servo.getPortNumber());
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Servo Position (0-1)", servo.getPosition());
        telemetrySynchronizer.addData("Servo PWM Range (microseconds)", servo.getPwmRange());
    }
}
