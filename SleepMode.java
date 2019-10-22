import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor ;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class SleepMode extends LinearOpMode {
    DigitalChannel digitalTouch;
    private volatile boolean Sleep = false;
    private DcMotor Right_Drive;
    private DcMotor Left_Drive;


    @Override
    public void runOpMode() {
        hardwareMap.logDevices();
        Right_Drive = hardwareMap.get(DcMotor.class,"Right Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left Drive");
        telemetry.addData("Status", "Ready");
        telemetry.update();
        digitalTouch = hardwareMap.get(DigitalChannel.class, "sensor_digital");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        if (digitalTouch.getState() == true) {
            telemetry.addData("Digital Touch", "Awake");
            Sleep = false;
        } else {
            telemetry.addData("Digital Touch", "Asleep");
            Sleep = true;
        }
            telemetry.update();
        Sleep();

        while (opModeIsActive()) {

        }


    }
    void Sleep(){
        if (Sleep == false) {

                waitForStart();

        } else if (Sleep == true) {
                Sleep();
        }
    }
}