package org.firstinspires.ftc.teamcode.Advanced_Practices.Practice_0;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class MethodExample extends OpMode {
    // Consider the math function f(x) = sin(2x)
    // We are going to use a method that turns an input x into an output f(x)
    @Override
    public void loop() {
        double input;
        double output;

        // Here we will assign the value of "input" using Gamepad 1
        if (gamepad1.a) {
            input = Math.PI/12;
        } else if (gamepad1.b) {
            input = Math.PI/4;
        } else {
            input = 0;
        }

        // This is where the method is called
        // At this point in the code, temporarily move to the sineFunction method that is created below
        output = sineFunction(input);

        telemetry.addData("Final Value",output);

        // Since we are within loop(), the OpMode will go back to the start of loop() and run through the code again
    }

    /**
     * This is our custom method that will act as f(x) = sin(2x)
     * @param input input "x"
     * @return f(x) = sin(2x)
     */
    // "private" means that the method is inaccessible outside the class (doesn't matter in this case)
            // "double" is the return value, the function will return a double value
                               // "(double input)" is the parameter, the method takes in an input (a double value) to use in the method
    private double sineFunction(double input) {
        // This is what the method does
        return Math.sin(2*input);
        // Once you reach the end of the method, return to the place where the method was called
    }

    // Notice that the placement of init within the class doesn't matter
    // Methods will only run when called, regardless of placement in the class
    @Override
    public void init() {}
}
