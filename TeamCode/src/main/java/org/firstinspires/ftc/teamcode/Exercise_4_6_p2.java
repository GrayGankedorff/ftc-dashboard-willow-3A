package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Exercise_4_6_p2")

public class Exercise_4_6_p2 extends OpMode {

    double left_joystick_y;
    boolean button_pressed;
    double forward_speed;


    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
    }

    public void loop() {

            left_joystick_y = gamepad1.left_stick_y;
            button_pressed = gamepad1.a;

            if (button_pressed) { //turbo mode
                forward_speed = forward_speed * 2;
            }
            telemetry.addData("X stick: ", left_joystick_y);
            telemetry.addData("A button: ", button_pressed);

        }
    }