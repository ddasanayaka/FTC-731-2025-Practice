package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;
import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;
import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

@TeleOp
public class FieldDrive extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    //ScoringMech scoringMech = new ScoringMech();
    IMU imu;
    boolean leftStickHeld;
    boolean slowModeActive;
    TelemetrySynchronizer telemetrySynchronizer = new TelemetrySynchronizer(telemetry);

    @Override
    public void init() {
        drive.initialize(hardwareMap);
        //scoringMech.initialize(hardwareMap);

        imu = hardwareMap.get(IMU.class,"imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot =
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot
                                .LogoFacingDirection.UP,
                        RevHubOrientationOnRobot
                                .UsbFacingDirection.FORWARD
                );
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
        telemetrySynchronizer.addLine("Control the robot drivetrain with the sticks");
        telemetrySynchronizer.addLine("Motion will be field-centric");
        telemetrySynchronizer.addLine("This has not been tested");
        telemetrySynchronizer.update();
    }

    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double right = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        if (gamepad1.left_stick_button && !leftStickHeld) {
            slowModeActive = !slowModeActive;
        }
        if (slowModeActive) {
            driveFieldCentric(forward,right,rotate,0.3);
            //telemetry.addData("Slow Mode","Active");
        } else {
            driveFieldCentric(forward,right,rotate,1.0);
            //telemetry.addData("Slow Mode","Inactive");
        }
        leftStickHeld = gamepad1.left_stick_button;

        //telemetry.addData("Heading",driveFieldCentric(forward,right,rotate,0.0));
/*
        boolean rightTriggerActive = gamepad1.right_trigger > 0;
        boolean leftTriggerActive = gamepad1.left_trigger > 0;

        if (gamepad1.right_trigger > 0) {
            scoringMech.constantExtend(0.5,rightTriggerActive);
        }

        if (gamepad1.left_trigger > 0) {
            scoringMech.constantRetract(0.5,leftTriggerActive);
        }

        if (gamepad1.back) {
            scoringMech.fullRetract(1);
        }*/
        telemetrySynchronizer.addLine("Use left stick to control forward and lateral movement");
        telemetrySynchronizer.addLine("Use right stick to control rotational movement");
        telemetrySynchronizer.addLine("Click the left stick to enable/disable slow mode");
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addData("Forward vel",forward);
        telemetrySynchronizer.addData("Lateral vel",right);
        telemetrySynchronizer.addData("Angular vel",rotate);
        telemetrySynchronizer.addData("Slow Mode",slowModeActive ? "ACTIVE" : "INACTIVE");
        telemetrySynchronizer.addData("Time (s)",getRuntime());
        telemetrySynchronizer.addData("Heading?",driveFieldCentric(forward,right,rotate,0.0));
        telemetrySynchronizer.update();
    }

    /**
     * Converts robot centric drive inputs to field centric inputs
     * @param forward amount of forward input
     * @param right amount of strafe input
     * @param rotate amount of rotational input
     * @param slowModeScalar activates slow mode at provided value
     * @return current robot heading
     */
    private double driveFieldCentric(double forward, double right, double rotate, double slowModeScalar) {
        double robotAngle = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        // convert to polar
        double theta = Math.atan2(forward, right);
        double r = Math.hypot(forward, right);
        // rotate robot angle
        theta = AngleUnit.normalizeRadians(theta - robotAngle);
        // convert back to cartesian
        double newForward = r * Math.sin(theta);
        double newRight = r * Math.cos(theta);
        // new mecanum drive components
        drive.drive(newForward, newRight, rotate, slowModeScalar);

        return Math.toDegrees(robotAngle);
    }
}
