package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

@TeleOp
@Config
@Disabled
public class ServoImplTestingDash extends OpMode {
    Servo servo;
    ServoImplEx servoImplEx;
    CRServo crServo;
    CRServoImplEx crServoImplEx;
    public static double position;


    @Override
    public void init() {
        //servo = hardwareMap.get(Servo.class,"servo");
        servoImplEx = hardwareMap.get(ServoImplEx.class,"servo");
        servoImplEx.setPwmRange(new PwmControl.PwmRange(500,2500));
    }

    @Override
    public void loop() {
            servoImplEx.setPosition(position);
    }
}
