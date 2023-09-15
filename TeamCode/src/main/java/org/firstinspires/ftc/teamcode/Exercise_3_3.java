package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Exercise_3_3")

public class Exercise_3_3 extends OpMode {
    @Override
    public void init() {
    }

    @Override
    public void loop() {
        telemetry.addData("Diff left y and right y",
                gamepad1.left_stick_y - gamepad1.right_stick_y);
        telemetry.addData("sum triggers",
                gamepad1.left_trigger + gamepad1.right_trigger);
    }
}