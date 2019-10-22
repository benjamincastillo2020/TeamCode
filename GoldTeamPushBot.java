import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor ;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.concurrent.TimeUnit;

@TeleOp
public class GoldTeamPushBot extends LinearOpMode {

    private DcMotor Right_Drive;
    private DcMotor Left_Drive;
    private DcMotor Arm_Drive;
    private Servo Extender_Drive;
    private Servo Rotation_Drive;
    private Servo LeftClaw_Drive;
    private Servo RightClaw_Drive;


    @Override
    public void runOpMode() {
        hardwareMap.logDevices();
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Arm_Drive = hardwareMap.get(DcMotor.class, "Arm_Drive");
        Extender_Drive = hardwareMap.get(Servo.class, "Extender_Drive");
        Rotation_Drive = hardwareMap.get(Servo.class, "Rotation_Drive");
        LeftClaw_Drive = hardwareMap.get(Servo.class, "LeftClaw_Drive");
        RightClaw_Drive = hardwareMap.get(Servo.class, "RightClaw_Drive");
        telemetry.addData("Status", "Initialized");
        telemetry.update();


            waitForStart();


            double RightDrive = 0;
            double LeftDrive = 0;
            double ArmDrive = 0;
            while (opModeIsActive()) {
                LeftDrive = (gamepad1.left_stick_y);
                RightDrive = -(gamepad1.right_stick_y);

                Right_Drive.setPower(RightDrive);
                Left_Drive.setPower(LeftDrive);

                if (gamepad1.dpad_up == true)
                    while (gamepad1.dpad_up == true) {
                        ArmDrive = (-0.6);
                        Arm_Drive.setPower(ArmDrive);
                        if (gamepad1.dpad_up == false) {
                            ArmDrive = (0);
                            Arm_Drive.setPower(ArmDrive);
                        }


                    }
                if (gamepad1.dpad_down == true)
                    while (gamepad1.dpad_down == true) {
                        ArmDrive = (0.6);
                        Arm_Drive.setPower(ArmDrive);
                        if (gamepad1.dpad_down == false) {
                            ArmDrive = (0);
                            Arm_Drive.setPower(ArmDrive);
                        }
                    }


            /*if (gamepad1.dpad_left == true)
                while( gamepad1.dpad_left == true) {
                    Extender_Drive . setPower(-0.6);
                    if (gamepad1.dpad_left != true){
                        break;
                    }


                }
            if (gamepad1.dpad_right == true)
                while( gamepad1.dpad_right == true) {
                    Extender_Drive . setPower(0.6);
                    if (gamepad1.dpad_right != true){
                        break;
                    }
                }
    */

                telemetry.addData("Right_Drive", RightDrive);
                telemetry.addData("Left_Drive", LeftDrive);
                telemetry.addData("Status", "Running");
                telemetry.update();
            }


        }
    }

