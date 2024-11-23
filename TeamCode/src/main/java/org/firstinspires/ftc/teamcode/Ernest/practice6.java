package org.firstinspires.ftc.teamcode.Ernest;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group = "Ernest")

public class practice6 extends OpMode {

    @Override
    public void init() {
    }

    int a = 0;
    @Override
    public void loop() {
        if (gamepad1.a) {
            a = a + 1;
            telemetry.addData("A is", a);
        }
        if (gamepad1.b) {
            a = a - 1;
            telemetry.addData("A is", a);
        }
    }
}
