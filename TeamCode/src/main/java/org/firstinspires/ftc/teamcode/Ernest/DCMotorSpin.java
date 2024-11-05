package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous()
public class DCMotorSpin extends OpMode {

    public void loop() {

        DcMotor motor;
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setPower(1);
    }
}