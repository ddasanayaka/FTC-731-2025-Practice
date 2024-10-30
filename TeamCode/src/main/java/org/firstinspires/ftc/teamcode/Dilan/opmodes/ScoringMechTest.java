package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Dilan.ScoringMech;

@TeleOp
public class ScoringMechTest extends OpMode {
    ScoringMech scoringMech = new ScoringMech();

    @Override
    public void init() {
        scoringMech.initialize(hardwareMap,2000);
        /*
        slideMotor = hardwareMap.get(DcMotor.class,"motor1");

        // Set the motor direction if needed
        slideMotor.setDirection(DcMotor.Direction.FORWARD);
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/
    }

    @Override
    public void loop() {

        scoringMech.constantExtend(gamepad1.right_trigger, gamepad1.right_trigger > 0);
        scoringMech.constantRetract(gamepad1.left_trigger, gamepad1.left_trigger > 0);

        if (gamepad1.a) {
            telemetry.addData("test","working");
        }
/*
        if ((gamepad1.right_trigger == 0) && (gamepad1.left_trigger == 0)) {
            scoringMech.stop();
        }
*/
        if (gamepad1.back) {
            scoringMech.fullRetract(1.0);
        }
    }
/*
    public void fullRetract(double speed) {
        slideMotor.setTargetPosition(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slideMotor.setPower(speed);
        while (slideMotor.isBusy()) {}
        slideMotor.setPower(0);
        slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void constantExtend(double speed, boolean isActive) {
        if (isActive) {
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(speed);
        }else {
            slideMotor.setPower(0);
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public void constantRetract(double speed, boolean isActive) {
        if (isActive) {
            //slideMotor.setDirection(DcMotor.Direction.REVERSE);
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            slideMotor.setPower(-speed);
        }else {
            slideMotor.setPower(0);
            slideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //slideMotor.setDirection(DcMotor.Direction.FORWARD);
        }
    }*/
}
