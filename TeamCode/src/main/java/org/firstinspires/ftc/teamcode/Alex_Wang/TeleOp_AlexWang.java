package org.firstinspires.ftc.teamcode.Alex_Wang;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(group = "Alex")
@Disabled
public class TeleOp_AlexWang extends OpMode {
    @Override
    public void init() {
        telemetry.addData("This is a sentence", "that I am writing");
    }
    @Override
    public void loop() {
        
    }
}