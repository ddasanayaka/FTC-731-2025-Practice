package org.firstinspires.ftc.teamcode.Dilan.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Dilan.MecanumDrive;

public class LinearAuto extends LinearOpMode {
    @Override
    public void runOpMode(){
        MecanumDrive drive = new MecanumDrive();
        drive.initialize(hardwareMap);
        ElapsedTime time1 = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

        waitForStart();
        time1.reset();
        drive.drive(1.0,0.0,0.0,false);
        for (double i = 0.0; i <= 1.0; i += 0.05) {
            drive.drive(1.0,i,0.0,false);
        }
        drive.drive(0.0,0.0,0.0,false);
        telemetry.addLine("test");
        telemetry.addLine("other test");
        telemetry.update();
    }
}
