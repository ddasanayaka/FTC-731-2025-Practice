package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;

@TeleOp
public class ScoringMechTest extends OpMode {
    ScoringMech scoringMech = new ScoringMech();

    @Override
    public void init() {
        scoringMech.initialize(hardwareMap,2000);
    }

    @Override
    public void loop() {

        scoringMech.constantExtend(1.0,gamepad1.right_trigger > 0);
        scoringMech.constantRetract(1.0,gamepad1.left_trigger > 0);
        telemetry.addData("Extend",gamepad1.right_trigger);
        telemetry.addData("Retract",gamepad1.left_trigger);

        if (gamepad1.back) {
            scoringMech.fullRetract(1.0);
        }
    }
}
