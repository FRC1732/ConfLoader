package org.usfirst.frc.team1732.robot.robotConfiguration;

import java.util.HashMap;

public class SystemConf {
	private String name;
	private HashMap<String, Part> parts = new HashMap<>();

	public SystemConf(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addPart(Part value) {
		parts.put(value.getName(), value);
	}

	public Part getPart(String name) {
		return parts.get(name);
	}

	public Motor getMotor(String name) {
		return (Motor) parts.get(name);
	}

	public Piston getPiston(String name) {
		return (Piston) parts.get(name);
	}

	public Joystick getJoystick(String name) {
		return (Joystick) parts.get(name);
	}

}
