package org.firstinspires.ftc.teamcode.Shrimaan;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Section2 extends OpMode {
    @Override
    public void init() {
        String myName = "Shrimaan";
        int grade = 10;

        telemetry.addData("Hello" , myName);
        telemetry.addData("Grade" , grade);
    }

    @Override
    public void loop() {

    }
}
