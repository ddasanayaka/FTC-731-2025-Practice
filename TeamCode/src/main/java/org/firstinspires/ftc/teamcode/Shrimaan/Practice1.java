package org.firstinspires.ftc.teamcode.Shrimaan;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(group = "Shrimaan")
@Disabled
public class Practice1 extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "BigDaddy");
    }

    @Override
    public void loop() {

    }
}
