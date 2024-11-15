package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(group = "Ernest")
public class DCMotorSpin extends OpMode {

    DcMotor motor;

    @Override
    public void init() {
    }

    @Override
    public void loop() {

        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setPower(1);
    }

}