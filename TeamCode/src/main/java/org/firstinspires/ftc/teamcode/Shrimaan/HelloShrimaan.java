package org.firstinspires.ftc.teamcode.Shrimaan;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(group = "Shrimaan")
@Disabled
public class HelloShrimaan extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello" , "Shrimaan");

    }

    @Override
    public void loop() {

    }
}
