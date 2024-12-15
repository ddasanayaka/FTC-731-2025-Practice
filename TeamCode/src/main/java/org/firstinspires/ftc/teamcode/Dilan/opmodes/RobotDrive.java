package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;
import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;
import org.firstinspires.ftc.teamcode.TelemetryHandler;

@TeleOp
public class RobotDrive extends OpMode {
    //ScoringMech scoringMech = new ScoringMech();
    MecanumDrive drive = new MecanumDrive();
    boolean leftStickHeld;
    boolean slowModeActive;
    TelemetryHandler telemetryHandler = new TelemetryHandler(telemetry);

    @Override
    public void init() {
        drive.initialize(hardwareMap);
        //scoringMech.initialize(hardwareMap);
        telemetryHandler.addLine("Control the robot drivetrain with the sticks");
        telemetryHandler.addLine("Motion will be robot-centric");
        telemetryHandler.addLine("This has not been tested");
        telemetryHandler.update();
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
        telemetryHandler.addLine("Use left stick to control forward and lateral movement");
        telemetryHandler.addLine("Use right stick to control rotational movement");
        telemetryHandler.addLine("Click the left stick to enable/disable slow mode");
        telemetryHandler.addLine();
        telemetryHandler.addData("Forward vel",forward);
        telemetryHandler.addData("Lateral vel",strafe);
        telemetryHandler.addData("Angular vel",rotate);
        telemetryHandler.addData("Slow Mode",slowModeActive ? "ACTIVE" : "INACTIVE");
        telemetryHandler.addData("Time (s)",getRuntime());
        telemetryHandler.update();
    }
}
