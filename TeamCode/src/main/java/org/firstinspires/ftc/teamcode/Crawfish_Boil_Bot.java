//Don't mind this my computer isn't working so I'm borrowing your repository

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name="CrawfishBoilBot")
//@Disabled
public class Crawfish_Boil_Bot extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotorEx armMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        armMotor = hardwareMap.get(DcMotorEx.class, "arm");

        leftFront.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        //Reset Encoder
        armMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            double drive = - gamepad1.left_stick_y;
            double turn  = gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            leftFront.setPower(leftPower);
            rightFront.setPower(rightPower);

            if(gamepad1.a) {
                armMotor.setTargetPosition(-275); // Go to this position
                armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                armMotor.setVelocity(200); // At this speed
            }
            else {
                armMotor.setTargetPosition(-30); // Go to this position
                armMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                armMotor.setVelocity(200); // At this speed
            }
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Arm Position", armMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}

