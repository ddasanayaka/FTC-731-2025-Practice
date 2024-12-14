package org.firstinspires.ftc.teamcode.Shrimaan;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(group = "Shrimaan")
@Disabled
public class Practice3 extends OpMode {
    DcMotor motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class , "motor");
    }

    @Override
    public void loop() {
        motor.setPower(-0.5);
    }
}
