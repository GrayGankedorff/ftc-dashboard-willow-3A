package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Exercise_4_6")

public class Exercise_4_6 extends OpMode {
    @Override
    public void init() {
    }

    @Override
    public void loop() {
        double fwdSpeed = gamepad1.left_stick_y;
        double ySpeed = gamepad1.left_stick_y;
        double xSpeed = gamepad1.left_stick_x;

        if (!gamepad1.a) { //turbo button
            fwdSpeed *= 0.5;
        }
        if (gamepad1.a) { //crazy mode
            ySpeed = gamepad1.left_stick_x;
            xSpeed = gamepad1.left_stick_y;
        }
         telemetry.addData("Forward Speed", fwdSpeed);
        telemetry.addData("X Speed", xSpeed);
    }
}