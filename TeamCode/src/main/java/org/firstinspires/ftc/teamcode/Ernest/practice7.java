package org.firstinspires.ftc.teamcode.Ernest;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group = "Ernest")
@Disabled
public class practice7 extends OpMode {

    @Override
    public void init() {
    }

    long a = 0;
    @Override
    public void loop() {
        if (gamepad1.a) {
            a = a + 1_000_000_000;
            telemetry.addData("A is", a);
        }
        if (gamepad1.b) {
            a = a - 1_000_000_000;
            telemetry.addData("A is", a);
        }
    }
}
