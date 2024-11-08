package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous()
public class DCMotorSpin2 extends OpMode {

    DcMotor motor;

    @Override
    public void init() {
    }

    @Override
    public void loop() {

        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setPower(-0.5);
    }

}