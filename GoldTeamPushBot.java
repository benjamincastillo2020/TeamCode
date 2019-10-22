package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor ;


@TeleOp
public class GoldTeamPushBot extends LinearOpMode {

    private DcMotor Right_Drive;
    private DcMotor Left_Drive;
    private DcMotor Arm_Drive;
    private CRServo Extender_sDrive;
    private CRServo Rotation_sDrive;
    private CRServo LeftClaw_sDrive;
    private CRServo RightClaw_sDrive;


    @Override
    public void runOpMode() {
        hardwareMap.logDevices();
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Arm_Drive = hardwareMap.get(DcMotor.class, "Arm_Drive");
        Extender_sDrive = hardwareMap.get(CRServo.class, "Extender_Drive");
        Rotation_sDrive = hardwareMap.get(CRServo.class, "Rotation_Drive");
        LeftClaw_sDrive = hardwareMap.get(CRServo.class, "LeftClaw_Drive");
        RightClaw_sDrive = hardwareMap.get(CRServo.class, "RightClaw_Drive");
        telemetry.addData("Status", "Initialized");
        telemetry.update();


            waitForStart();


            double RightDrive;
            double LeftDrive;
            double ArmDrive;
            //double Extender_Drive = 0;
            //double Rotation_Drive = 0;
            //double LeftClaw_Drive = 0;
            //double RightClaw_Drive = 0;

            while (opModeIsActive()) {

                LeftDrive = (gamepad1.left_stick_y);
                RightDrive = -(gamepad1.right_stick_y);

                //converts long to double
                double Righttrigger = (gamepad1.right_trigger);

                //converts Long to double
                double Lefttrigger = (gamepad1.left_trigger);


                Right_Drive.setPower(RightDrive);
                Left_Drive.setPower(LeftDrive);
                //Arm Motor Up Code
                if (gamepad1.dpad_up == true)
                    while (gamepad1.dpad_up ) {
                        ArmDrive = (-0.6);
                        Arm_Drive.setPower(ArmDrive);
                        if (gamepad1.dpad_up == false) {
                            ArmDrive = (0);
                            Arm_Drive.setPower(ArmDrive);
                        }

                //Arm Motor Down Code
                    }
                if (gamepad1.dpad_down == true)
                    while (gamepad1.dpad_down ) {
                        ArmDrive = (0.6);
                        Arm_Drive.setPower(ArmDrive);
                        if (gamepad1.dpad_down == false) {
                            ArmDrive = (0);
                            Arm_Drive.setPower(ArmDrive);
                        }
                    }

                //Servo Extender In
                if (gamepad1.dpad_left == true)
                while( gamepad1.dpad_left ) {
                    Extender_sDrive.setPower(-1);

                    if (gamepad1.dpad_left != true){
                        Extender_sDrive.setPower(0);
                        break;
                    }
                }

                //Rotation Drive Down
                if (gamepad1.y == true)
                    while( gamepad1.y ) {
                        Rotation_sDrive.setPower(-0.5);

                        if (gamepad1.y != true){
                            Rotation_sDrive.setPower(0);
                            break;
                        }
                    }
                //Rotation Drive up
                if (gamepad1.a == true)
                    while( gamepad1.a ) {
                        Rotation_sDrive.setPower(0.5);

                        if (gamepad1.a != true){
                            Rotation_sDrive.setPower(0);
                            break;
                        }
                    }
                //Claw Drive Right Hand Out
                if (gamepad1.right_bumper == true) {
                    while (gamepad1.right_bumper) {
                        RightClaw_sDrive.setPower(-1);

                        if (gamepad1.right_bumper != true) {
                            RightClaw_sDrive.setPower(0);
                            break;
                        }
                    }

                }
                //Claw Drive Right Hand In
                if (gamepad1.right_trigger != 0) {
                    while (gamepad1.right_trigger != 0){
                        RightClaw_sDrive.setPower(Righttrigger);

                        if (gamepad1.right_trigger == 0){
                            RightClaw_sDrive.setPower(0);
                            break;
                        }
                    }
                }
                //Claw Drive Left Hand Out
                if (gamepad1.left_bumper == true) {
                    while (gamepad1.left_bumper) {
                        LeftClaw_sDrive.setPower(-1);

                        if (gamepad1.left_bumper != true) {
                            LeftClaw_sDrive.setPower(0);
                            break;
                        }
                    }

                }
                //Claw Drive Left Hand In
                if (gamepad1.left_trigger != 0) {
                    while (gamepad1.left_trigger != 0){
                        LeftClaw_sDrive.setPower(Lefttrigger);

                        if (gamepad1.left_trigger == 0){
                            LeftClaw_sDrive.setPower(0);
                            break;
                        }
                    }
                }





                telemetry.addData("Right_Drive", RightDrive);
                telemetry.addData("Left_Drive", LeftDrive);
                telemetry.addData("Status", "Running");
                telemetry.update();
            }


        }
    }

