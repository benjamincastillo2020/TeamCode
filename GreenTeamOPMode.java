import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor ;
import com.qualcomm.robotcore.hardware.CRServo;
import java.util.concurrent.TimeUnit;

@TeleOp
public class GreenTeamOPMode extends LinearOpMode {

    private DcMotor Right_Drive;
    private DcMotor Left_Drive;
    private DcMotor Arm_Drive;
    private CRServo Extender_Drive;
    private CRServo Rotation_Drive;
    private CRServo LeftClaw_Drive;
    private CRServo RightClaw_Drive;


    @Override
        public void runOpMode() {
        hardwareMap.logDevices();
        Right_Drive = hardwareMap.get(DcMotor.class,"Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Arm_Drive = hardwareMap.get(DcMotor.class, "Arm_Drive");
        Extender_Drive = hardwareMap.get(CRServo.class, "Extender_Drive");
        Rotation_Drive = hardwareMap.get(CRServo.class, "Rotation_Drive");
        LeftClaw_Drive = hardwareMap.get(CRServo.class, "LeftClaw_Drive");
        RightClaw_Drive = hardwareMap.get(CRServo.class, "RightClaw_Drive");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double RightDrive = 0;
        double LeftDrive = 0;
        double ArmDrive = 0;
        double ExtenderR = 0;
        while (opModeIsActive()) {
            LeftDrive = (gamepad1.left_stick_y);
            RightDrive = -(gamepad1.right_stick_y);

            Right_Drive.setPower(RightDrive);
            Left_Drive.setPower(LeftDrive);

            if (gamepad1.dpad_up == true)
                while( gamepad1.dpad_up == true) {
                    ArmDrive = (0.6);
                    Arm_Drive.setPower(ArmDrive);


            }
            if (gamepad1.dpad_down == true)
                while( gamepad1.dpad_down == true) {
                    ArmDrive = (-0.6);
                    Arm_Drive.setPower(ArmDrive);

                }






            telemetry.addData("Right_Drive", RightDrive);
            telemetry.addData("Left_Drive", LeftDrive);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}

