package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(group = "Ernest")
@Disabled
public class ErnestTeleOp extends OpMode {
    @Override
    public void init() {
        telemetry.addData("red", "blue");
    }

    @Override
    public void loop() {

    }

}
