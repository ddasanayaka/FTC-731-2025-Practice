package org.firstinspires.ftc.teamcode.Dilan.tests;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;

import org.firstinspires.ftc.teamcode.Dilan.tests.hardware.HardwareController;
import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

import java.util.List;

@TeleOp(group = "test")
public class WheelDirectionTester extends OpMode {
    HardwareController call;
    List<LynxModule> allHubs;
    TelemetrySynchronizer telemetrySynchronizer = new TelemetrySynchronizer(telemetry);

    @Override
    public void init() {
        call = new HardwareController(hardwareMap);
        allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule module : allHubs) {
            module.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
        telemetrySynchronizer.addLine("This OpMode uses the face buttons to check wheel directions.");
        telemetrySynchronizer.addLine("Use the following buttons to check each wheel.");
        telemetrySynchronizer.addLine("Front Left: X  |  Front Right: Y");
        telemetrySynchronizer.addLine("Back Left: A   |   Back Right: B");
        telemetrySynchronizer.addLine("When pressed, each respective wheel should spin forward.");
        telemetrySynchronizer.addLine("Holding all 4 buttons should move the robot relatively forward");
        telemetrySynchronizer.addLine();
        telemetrySynchronizer.addLine("Press START to begin test");
    }

    @Override
    public void loop() {
        for (LynxModule module : allHubs) {
            module.clearBulkCache();
        }
        telemetrySynchronizer.addLine("This OpMode uses the face buttons to check wheel directions.");
        telemetrySynchronizer.addLine("Use the following buttons to check each wheel.");
        telemetrySynchronizer.addLine("Front Left: X  |  Front Right: Y");
        telemetrySynchronizer.addLine("Back Left: A   |   Back Right: B");
        telemetrySynchronizer.addLine("When pressed, each respective wheel should spin forward.");
        telemetrySynchronizer.addLine("Holding all 4 buttons should move the robot relatively forward");
        telemetrySynchronizer.addLine();
        if (gamepad1.x) {
            call.forceLeftFront(0.5);
            telemetrySynchronizer.addData("Front Left Wheel", "ACTIVE");
        } else {
            call.forceLeftFront(0.0);
            telemetrySynchronizer.addData("Front Left Wheel", "STOPPED");
        }
        if (gamepad1.a) {
            call.forceLeftBack(0.5);
            telemetrySynchronizer.addData("Back Left Wheel", "ACTIVE");
        } else {
            call.forceLeftBack(0.0);
            telemetrySynchronizer.addData("Back Left Wheel", "STOPPED");
        }
        if (gamepad1.y) {
            call.forceRightFront(0.5);
            telemetrySynchronizer.addData("Front Right Wheel", "ACTIVE");
        } else {
            call.forceRightFront(0.0);
            telemetrySynchronizer.addData("Front Right Wheel", "STOPPED");
        }
        if (gamepad1.b) {
            call.forceRightBack(0.5);
            telemetrySynchronizer.addData("Back Right Wheel", "ACTIVE");
        } else {
            call.forceRightBack(0.0);
            telemetrySynchronizer.addData("Back Right Wheel", "STOPPED");
        }
    }
}
