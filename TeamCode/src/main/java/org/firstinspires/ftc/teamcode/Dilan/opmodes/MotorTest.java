package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
@Config
@Disabled
public class MotorTest extends OpMode {
    DcMotor motor;
    public static double config = 0;
    public static boolean rev;

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class,"motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        if (rev) {
            motor.setPower(-config);
        } else {
            motor.setPower(config);
        }
        telemetry.addLine(String.valueOf(motor.getPower()));
    }
}
