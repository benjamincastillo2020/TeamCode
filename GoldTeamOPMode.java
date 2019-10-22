import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor ;


import static com.sun.tools.doclint.Entity.and;

@TeleOp
public class GoldTeamOPMode extends LinearOpMode {

    private DcMotor Right_Drive;
    private DcMotor Left_Drive;


    @Override
    public void runOpMode() {
        hardwareMap.logDevices();
        Right_Drive = hardwareMap.get(DcMotor.class, "Right Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left Drive");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double RightDrive = 0;
        double LeftDrive = 0;

        String Lift_Status = "IDLE";


        while (opModeIsActive()) {
            LeftDrive = -(gamepad1.left_stick_y);
            RightDrive = (gamepad1.right_stick_y);

            Right_Drive.setPower(RightDrive);
            Left_Drive.setPower(LeftDrive);

            telemetry.addData("Right_Drive", RightDrive);
            telemetry.addData("Left_Drive", LeftDrive);
            telemetry.addData("Status", "Running");
            telemetry.update();
                }
            }
}
