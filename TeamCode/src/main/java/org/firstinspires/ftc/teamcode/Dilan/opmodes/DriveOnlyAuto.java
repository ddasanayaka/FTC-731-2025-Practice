package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;

@Autonomous(preselectTeleOp = "RobotDrive")
@Disabled
public class DriveOnlyAuto extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    //double runTime;

    enum Step {
        FORWARD, // bot moves forward
        STRAFE, // bot moves left
        TURN_RIGHT, // bot turns right
        SPLINE, // bot splines right and up
        SPIN // bot spins in place
    }
    Step step = Step.FORWARD;

    @Override
    public void init() {
        drive.initialize(hardwareMap);
    }

    @Override
    public void start() {
        step = Step.FORWARD;
        resetRuntime();
        //runTime = getRuntime();
    }

    @Override
    public void loop() {
        telemetry.addData("Current Step", step);
        telemetry.addData("Runtime", getRuntime());
        switch (step) {
            case FORWARD:
                drive.drive(1.0,0.0,0.0,1.0);
                if (getRuntime() >= 2.0) {
                    step = Step.STRAFE;
                    drive.drive(0.0,0.0,0.0,1.0);
                }
                break;
            case STRAFE:
                drive.drive(0.0,-1.0,0.0,1.0);
                if (getRuntime() >= 4.0) {
                    step = Step.TURN_RIGHT;
                    drive.drive(0.0,0.0,0.0,1.0);
                }
                break;
            case TURN_RIGHT:
                drive.drive(0.0,0.0,1.0,1.0);
                if (getRuntime() >= 4.5) {
                    step = Step.SPLINE;
                    drive.drive(0.0,0.0,0.0,1.0);
                }
                break;
            case SPLINE:
                for (double i = 0.0; i <= 1.0; i += 0.05) {
                    drive.drive(1.0,i,0.0,1.0);
                    telemetry.update();
                }
                step = Step.SPIN;
                drive.drive(0.0,0.0,0.0,1.0);
                break;
            case SPIN:
                drive.drive(0.0,0.0,-1.0,1.0);
                break;
        }
    }
}
