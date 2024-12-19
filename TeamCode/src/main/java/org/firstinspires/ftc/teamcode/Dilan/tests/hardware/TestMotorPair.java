package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

public class TestMotorPair extends TestItem {
    private final double speed;
    private final DcMotorEx forMotor, revMotor;

    protected TestMotorPair(String description, double speed, DcMotorEx forMotor, DcMotorEx revMotor, String title) {
        super(description,title);
        this.speed = speed;
        this.forMotor = forMotor;
        this.revMotor = revMotor;
    }

    @Override
    public void run(boolean on, boolean other, TelemetrySynchronizer telemetrySynchronizer) {
        if (on) {
            forMotor.setPower(speed);
            revMotor.setPower(speed);
        } else if (other) {
            forMotor.setPower(-speed);
            revMotor.setPower(-speed);
        } else {
            forMotor.setPower(0.0);
            revMotor.setPower(0.0);
        }
        telemetrySynchronizer.addData("Motor Config Names", forMotor.getDeviceName(), revMotor.getDeviceName());
        telemetrySynchronizer.addData("Motor Types", forMotor.getMotorType(), revMotor.getMotorType());
        telemetrySynchronizer.addData("Motor Ports", forMotor.getPortNumber(), revMotor.getPortNumber());
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Relative Motor Direction", forMotor.getDirection(), revMotor.getDirection());
        telemetrySynchronizer.addData("Motor Run Mode", forMotor.getMode(), revMotor.getMode());
        telemetrySynchronizer.addData("Behavior When Unpowered", forMotor.getZeroPowerBehavior(), revMotor.getZeroPowerBehavior());
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Supplied Power", forMotor.getPower(), revMotor.getPower());
        telemetrySynchronizer.addData("Encoder Reading (ticks)", forMotor.getCurrentPosition(), revMotor.getCurrentPosition());
        telemetrySynchronizer.addData("Motor Velocity (ticks/s)", forMotor.getVelocity(), revMotor.getVelocity());
        telemetrySynchronizer.addData("Wire Current (mA)", forMotor.getCurrent(CurrentUnit.MILLIAMPS), revMotor.getCurrent(CurrentUnit.MILLIAMPS));
    }
}
