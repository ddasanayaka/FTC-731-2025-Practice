package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadButton extends OpMode {

    @Override
    public void init() {
    }

    public void loop() {

        if(gamepad1.a){
            telemetry.addData("A pressed on Gamepad 1", "pressed");

        }
    }
}
