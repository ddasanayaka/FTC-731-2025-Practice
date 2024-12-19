package org.firstinspires.ftc.teamcode.Dilan.tests.hardware;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TelemetrySynchronizer;

import java.util.ArrayList;

//@TeleOp(group = "test")
public class HardwareTester extends OpMode {
    HardwareController call;
    ArrayList<TestItem> tests;
    boolean dDownPressed, dUpPressed;
    int testNum;
    TelemetrySynchronizer telemetrySynchronizer = new TelemetrySynchronizer(telemetry);

    @Override
    public void init() {
        call = new HardwareController(hardwareMap);
        tests = call.getTests();
    }

    @Override
    public void loop() {
        // move up in the list of tests
        if (gamepad1.dpad_up && !dUpPressed) {
            testNum--;
            if (testNum < 0) {
                testNum = tests.size() - 1;
            }
        }
        dUpPressed = gamepad1.dpad_up;

        // move down in the list of tests
        if (gamepad1.dpad_down && !dDownPressed) {
            testNum++;
            if (testNum >= tests.size()) {
                testNum = 0;
            }
        }
        dDownPressed = gamepad1.dpad_down;

        telemetrySynchronizer.addLine("Use Up and Down on D-pad to cycle through choices");
        telemetrySynchronizer.addLine("Press A to run test");

        TestItem currTest = tests.get(testNum);
        telemetrySynchronizer.addData("Test:", currTest.getDescription());

        currTest.run(gamepad1.a, gamepad1.b, telemetrySynchronizer);
    }
}
