package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

@TeleOp
public class ServoTesting extends OpMode {
    Servo servo;
    ServoImplEx servoImplEx;
    CRServo crServo;
    CRServoImplEx crServoImplEx;


    @Override
    public void init() {
        //servo = hardwareMap.get(Servo.class,"servo");
        servoImplEx = hardwareMap.get(ServoImplEx.class,"servo");
        servoImplEx.setPwmRange(new PwmControl.PwmRange(500,2500));
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            servoImplEx.setPosition(1.0);
        } else if (gamepad1.b) {
            servoImplEx.setPosition(0.0);
        } else if (gamepad1.x) {
            servoImplEx.setPosition(0.5);
        }
    }
}
