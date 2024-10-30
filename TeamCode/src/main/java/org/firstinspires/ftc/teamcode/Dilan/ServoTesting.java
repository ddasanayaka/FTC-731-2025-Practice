package org.firstinspires.ftc.teamcode.Dilan;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Deprecate once final robot mechanisms are created
 */
@TeleOp
public class ServoTesting extends OpMode {
    Servo servo;
    CRServo crServo, crServoR;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class,"servo");
        crServo = hardwareMap.get(CRServo.class,"crservo");
        crServoR = hardwareMap.get(CRServo.class,"crservoR");
        crServoR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            servo.setPosition(1.0);
        }
        else if(gamepad1.b){
            servo.setPosition(0.0);
        }
        else{
            servo.setPosition(0.5);
        }

        if (gamepad1.x) {
            crServo.setPower(1.0);
        }

        if (gamepad2.y) {
            crServoR.setPower(1.0);
        }
    }
}
