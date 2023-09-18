package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Gamepad_Testing")

public class Gamepad_Testing extends OpMode {

    double left_joystick_y;
    boolean button_pressedA; // x = a
    boolean button_pressedX; // [] = x
    double forward_speed;
    private DcMotor testMotor1;

    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        testMotor1  = hardwareMap.get(DcMotor.class, "testMotor1");
    }



    public void loop() {

        left_joystick_y = gamepad1.left_stick_y;
        button_pressedA = gamepad1.a; // x = a
        button_pressedX = gamepad1.x; // [] = x

        //Turbo Mode
        if (button_pressedA) { //turbo mode
            forward_speed = forward_speed * 2;
        }

        //If Drive Presses B, Runs motor1
        if (gamepad1.b) {
            testMotor1.setPower(1);

        }
        if (gamepad1.x) {
            testMotor1.setPower(0);
        }

        telemetry.addData("X stick: ", left_joystick_y);
        telemetry.addData("A button: ", button_pressedA); // x = a
        telemetry.addData("X Button: ", button_pressedX); // [] = x
        telemetry.update();

    }

}
