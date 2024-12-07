package org.firstinspires.ftc.teamcode.Advanced_Practices.Practice_3;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(group = "Advanced")
public class CalculatorOpMode extends OpMode {
    // Here, an object called calculator of type Calculator is being created
    // The Calculator type is what was created in the "Calculator" file
    // The calculator object has all of the functions and methods of the "Calculator" class
    Calculator calculator = new Calculator();

    @Override
    public void init() {}

    @Override
    public void loop() {
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.left_stick_y;

        // For reference
        telemetry.addData("X",gamepad1.left_stick_x);
        telemetry.addData("Y",-gamepad1.left_stick_y);

        // These values will display the value that gets computed after the inputs go through the method
        telemetry.addData("Radius",calculator.cartesianToPolarRadius(x,y));
        telemetry.addData("Angle",calculator.cartesianToPolarTheta(x,y));
    }
}
