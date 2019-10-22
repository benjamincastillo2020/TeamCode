import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class GoldTeamPushBotAuto extends LinearOpMode  {
    private ElapsedTime     runtime = new ElapsedTime();
    ColorSensor colorSensor;

    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.8;
    static final double     TURN_SPEED              = 0.4;

    private DcMotor Right_Drive;
    private DcMotor Left_Drive;

    @Override
    public void runOpMode() {



        telemetry.update();

        hardwareMap.logDevices();
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");

        Left_Drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Right_Drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Left_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Right_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Path0",  "Starting at %7d :%7d",
                Left_Drive.getCurrentPosition(),
                Right_Drive.getCurrentPosition());
        telemetry.update();

        waitForStart();

        encoderDrive(DRIVE_SPEED,11,  -11,0.6);
        sleep(100);
        encoderDrive(TURN_SPEED,   11, 11,0.78);
        sleep(100);
        encoderDrive(DRIVE_SPEED,12,  -12,1.7);
        sleep(100);
        encoderDrive(TURN_SPEED,   11, 11,0.7  );


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void encoderDrive(double speed,double leftInches, double rightInches, double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        if (opModeIsActive()) {

            newLeftTarget = Left_Drive.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightTarget = Right_Drive.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            Left_Drive.setTargetPosition(newLeftTarget);
            Right_Drive.setTargetPosition(newRightTarget);

            Left_Drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Right_Drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            Left_Drive.setPower(Math.abs(speed));
            Right_Drive.setPower(Math.abs(speed));
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (Left_Drive.isBusy() && Right_Drive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftTarget,  newRightTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d",
                        Left_Drive.getCurrentPosition(),
                        Right_Drive.getCurrentPosition());
                telemetry.update();
            }
            Left_Drive.setPower(0);
            Right_Drive.setPower(0);
            Left_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Right_Drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        }

        }
    }


