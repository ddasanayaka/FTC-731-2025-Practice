package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;
import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;

@TeleOp
public class RobotDrive extends OpMode {
    ScoringMech scoringMech = new ScoringMech();
    MecanumDrive drive = new MecanumDrive();
    boolean leftStickHeld;
    boolean slowModeActive;

    @Override
    public void init() {
        drive.initialize(hardwareMap);
        scoringMech.initialize(hardwareMap);
    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        if (gamepad1.left_stick_button && !leftStickHeld) {
            slowModeActive = !slowModeActive;
        }
        if (slowModeActive) {
            drive.drive(forward,strafe,rotate,0.3);
            telemetry.addData("Slow Mode","Active");
        } else {
            drive.drive(forward,strafe,rotate,1.0);
            telemetry.addData("Slow Mode","Inactive");
        }
        leftStickHeld = gamepad1.left_stick_button;

        if (gamepad1.right_trigger > 0) {
            scoringMech.constantExtend(0.5,gamepad1.right_trigger > 0);
        }

        if (gamepad1.left_trigger > 0) {
            scoringMech.constantRetract(0.5,gamepad1.left_trigger > 0);
        }

        if (gamepad1.back) {
            scoringMech.fullRetract(0.5);
        }
    }
}
