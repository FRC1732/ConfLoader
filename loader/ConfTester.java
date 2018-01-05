package org.usfirst.frc.team1732.robot.robotConfiguration;

public class ConfTester {

	public static void main(String[] args) {
		String file = "C:\\Users\\mattew\\eclipseWorkspace\\MotorControl\\src\\org\\usfirst\\frc\\team1732\\robot\\RobotConfiguration\\test.conf";
		Config c = Config.load(file);
		System.out.println(c.getSystem("driverstation").getJoystick("left").getMajor_axis());
	}

}
