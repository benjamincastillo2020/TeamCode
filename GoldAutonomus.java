import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous
public class GoldAutonomus extends LinearOpMode {
    private ColorSensor Color_Detector;
    private DcMotor Left_Drive;
    private DcMotor Right_Drive;


    @Override

    public void runOpMode() throws InterruptedException {
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Color_Detector = hardwareMap.colorSensor.get("Color");
        Left_Drive.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Color", "Null");
        telemetry.update();
        Color_Detector.enableLed(true);

        waitForStart();//Under this
        readSensor();



    }


    private void moveFoward (long power, double seconds ) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power);
        Left_Drive.setPower(power);
        sleep(secondsI);
    }
    private void turnLeft (long power, double seconds ) {
        power /= 100;
        seconds = 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power);
        Left_Drive.setPower(power * -1);
        sleep(secondsI);
    }

    private void turnRight (long power, double seconds ) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        Right_Drive.setPower(power * -1);
        Left_Drive.setPower(power);
        sleep(secondsI);
    }
    private void readSensor (/*String ColorA ,String ColorB, String ColorC, String Luminosity, String Argb*/) {
        long Red = Color_Detector.red() * 10 ;
        long Green = Color_Detector.green() * 10 ;
        long Blue = Color_Detector.blue() * 10 ;
        long Alpha = Color_Detector.alpha() * 10 ;
        long Argb = Color_Detector.argb()* 10 ;
        long AvRG = (Red + Green) / 2;
        long AvRB = (Red + Blue) / 2;
        long AvGB = (Green + Blue) / 2;

        if (Red > AvRG) {
                telemetry.addData("Color", "RED");
                telemetry.update();

            }

            if (Green > AvRG){
                telemetry.addData("Color", "Green");
                telemetry.update();

        }



    }


    }


