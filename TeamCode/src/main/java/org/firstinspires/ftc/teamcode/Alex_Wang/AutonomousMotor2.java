package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous
public class AutonomousMotor2 extends OpMode {
    private DcMotor motor;
    @Override
    public void init() {
        motor.setPower(-0.5);
    }

    @Override
    public void loop() {
        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
