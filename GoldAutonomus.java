package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;


@Autonomous
public class GoldAutonomus extends LinearOpMode {
    private ColorSensor Color_Detector;
    private DcMotor Left_Drive;
    private DcMotor Right_Drive;
    private CRServo Extender_sDrive;
    private CRServo Rotation_sDrive;
    private CRServo LeftClaw_sDrive;
    private CRServo RightClaw_sDrive;


    @Override

    public void runOpMode() throws InterruptedException {
        Right_Drive = hardwareMap.get(DcMotor.class, "Right_Drive");
        Left_Drive = hardwareMap.get(DcMotor.class, "Left_Drive");
        Color_Detector = hardwareMap.colorSensor.get("Color");
        Left_Drive.setDirection(DcMotor.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.addData("Color", "Null");
        Extender_sDrive = hardwareMap.get(CRServo.class, "Extender_Drive");
        Rotation_sDrive = hardwareMap.get(CRServo.class, "Rotation_Drive");
        LeftClaw_sDrive = hardwareMap.get(CRServo.class, "LeftClaw_Drive");
        RightClaw_sDrive = hardwareMap.get(CRServo.class, "RightClaw_Drive");
        telemetry.update();
        Color_Detector.enableLed(true);

        waitForStart();
        //place code under here
        moveFoward(100, 5);
        readSensor();


        //end
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
        seconds *= 1000;
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
    //True = Up ; False = Down
    private void extenderDrive (long power , double seconds, boolean direction) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        if (direction==true) {
            
            Extender_sDrive.setPower(power);
            sleep(secondsI);
            
        }

        if (direction==false) {
            Extender_sDrive.setPower(-power);
            sleep(secondsI);
        }

    }

    //True = Up ; False = Down
    private void rotationDrive (long power, double seconds, boolean direction) {
        power /= 100;
        seconds *= 1000;
        long secondsI = (long)seconds;
        if (direction == true) {
            Rotation_sDrive.setPower(power);
            sleep(secondsI);
        }
        
        if (direction == false) {
            Rotation_sDrive.setPower(-power);
            sleep(secondsI);
        }

    }

    //True = In False = Out
    private void clawDriver (double seconds, boolean direction) {
        double power = 0.65;
        seconds *= 1000;
        long secondsI = (long)seconds;
        if (direction == true) {
            LeftClaw_sDrive.setPower(power);
            Right_Drive.setPower(-power);
            sleep(secondsI);
            LeftClaw_sDrive.setPower(0);
            RightClaw_sDrive.setPower(0);
        }

        if (direction == false) {
            LeftClaw_sDrive.setPower(-power);
            Right_Drive.setPower(power);
            sleep(secondsI);
            LeftClaw_sDrive.setPower(0);
            RightClaw_sDrive.setPower(0);
        }
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


