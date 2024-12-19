package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

public class TestMotor extends TestItem{
    private final double speed;
    private final DcMotorEx motor;

    public TestMotor(String description, double speed, DcMotorEx motor, String title) {
        super(description,title);
        this.speed = speed;
        this.motor = motor;
    }

    @Override
    public void run(boolean on, boolean other, TelemetrySynchronizer telemetrySynchronizer) {
        if (on) {
            motor.setPower(speed);
        } else if (other) {
            motor.setPower(-speed);
        } else {
            motor.setPower(0.0);
        }
        telemetrySynchronizer.addData("Motor Config Name", motor.getDeviceName());
        telemetrySynchronizer.addData("Motor Type", motor.getMotorType());
        telemetrySynchronizer.addData("Motor Port", motor.getPortNumber());
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Relative Motor Direction", motor.getDirection());
        telemetrySynchronizer.addData("Motor Run Mode", motor.getMode());
        telemetrySynchronizer.addData("Behavior When Unpowered", motor.getZeroPowerBehavior());
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Supplied Power", motor.getPower());
        telemetrySynchronizer.addData("Encoder Reading (ticks)", motor.getCurrentPosition());
        telemetrySynchronizer.addData("Motor Velocity (ticks/s)", motor.getVelocity());
        telemetrySynchronizer.addData("Wire Current (mA)", motor.getCurrent(CurrentUnit.MILLIAMPS));
    }
}
