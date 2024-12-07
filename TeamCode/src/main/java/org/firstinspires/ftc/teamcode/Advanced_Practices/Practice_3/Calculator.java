package org.firstinspires.ftc.teamcode.Advanced_Practices.Practice_3;

// This class contains methods that can be used by objects of type Calculator
public class Calculator {

    // When you see one of these methods being called in CalculatorOpMode, the method will use the defined functionality below

    public double cartesianToPolarRadius(double x, double y) {
        return Math.hypot(x,y);
    }

    public double cartesianToPolarTheta(double x, double y) {
        return Math.atan2(y,x);
    }

    public double polarToCartesianX(double r, double theta) {
        return r*Math.cos(theta);
    }

    public double polarToCartesianY(double r, double theta) {
        return r*Math.sin(theta);
    }
}
