package org.firstinspires.ftc.teamcode.Alex_Wang;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous
public class AutonomousMotor {
private DcMotor motor;

public void init(HardwareMap hwMap){
    motor = hwMap.get(DcMotor.class, "motor");
    motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
}
public void setMotorSpeed(double speed) {
    motor.setPower(1);
    }
}
