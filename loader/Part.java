package org.usfirst.frc.team1732.robot.robotConfiguration;

public class Part {
	private String system;
	private String name;

	public Part(String system, String name) {
		this.system = system;
		this.name = name;
	}

	public String getSystem() {
		return system;
	}

	public String getName() {
		return name;
	}
}
