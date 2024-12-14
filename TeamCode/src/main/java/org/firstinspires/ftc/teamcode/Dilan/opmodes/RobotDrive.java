package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;
import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;

@TeleOp
public class RobotDrive extends OpMode {
    //ScoringMech scoringMech = new ScoringMech();
    MecanumDrive drive = new MecanumDrive();
    boolean leftStickHeld;
    boolean slowModeActive;

    @Override
    public void init() {
        drive.initialize(hardwareMap);
        //scoringMech.initialize(hardwareMap);
        telemetry.addLine("Control the robot drivetrain with the sticks");
        telemetry.addLine("Motion will be robot-centric");
        telemetry.addLine("This has not been tested");
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
            //telemetry.addData("Slow Mode","Active");
        } else {
            drive.drive(forward,strafe,rotate,1.0);
            //telemetry.addData("Slow Mode","Inactive");
        }
        leftStickHeld = gamepad1.left_stick_button;
/*
        if (gamepad1.right_trigger > 0) {
            scoringMech.constantExtend(0.5,gamepad1.right_trigger > 0);
        }

        if (gamepad1.left_trigger > 0) {
            scoringMech.constantRetract(0.5,gamepad1.left_trigger > 0);
        }

        if (gamepad1.back) {
            scoringMech.fullRetract(0.5);
        }*/
        telemetry.addLine("Use left stick to control forward and lateral movement");
        telemetry.addLine("Use right stick to control rotational movement");
        telemetry.addLine("Click the left stick to enable/disable slow mode");
        telemetry.addLine();
        telemetry.addData("Forward vel",forward);
        telemetry.addData("Lateral vel",strafe);
        telemetry.addData("Angular vel",rotate);
        telemetry.addData("Slow Mode Active",slowModeActive);
        telemetry.addData("Time (s)",getRuntime());
    }
}
