package org.firstinspires.ftc.teamcode.Ernest;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(group = "Ernest")
@Disabled
public class opmode extends OpMode {

    DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class,"leftFront");
    DcMotor leftBackMotor = hardwareMap.get(DcMotor.class,"leftBack");
    DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class,"rightFront");
    DcMotor rightBackMotor = hardwareMap.get(DcMotor.class, "rightBack");

    @Override
    public void init() {
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        double forward = 0.5;
        double reverse = -0.5;

        if (gamepad1.a) {
            leftFrontMotor.setPower(reverse);
            leftBackMotor.setPower(reverse);
            rightFrontMotor.setPower(forward);
            rightBackMotor.setPower(forward);

            telemetry.addData("spinning", true);
        }
        else {
            leftFrontMotor.setPower(0);
            leftBackMotor.setPower(0);
            rightFrontMotor.setPower(0);
            rightBackMotor.setPower(0);

            telemetry.addData("spinning", false);
        }

    }
}
