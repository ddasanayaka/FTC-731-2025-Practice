package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class TeleOpGamepad extends OpMode {
@Override
    public void init() {
}

@Override
    public void loop() {
telemetry.addData("A button", gamepad1.a);
}

}
