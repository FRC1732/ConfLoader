package org.usfirst.frc.team1732.robot.robotConfiguration;

public class Piston extends Part {
	private int can_id;
	private int device_number;

	public Piston(String system, String name, int can_id, int device_number) {
		super(system, name);
		this.can_id = can_id;
		this.device_number = device_number;
	}
	public int getCan_id() {
		return can_id;
	}

	public int getDevice_number() {
		return device_number;
	}

	void setCan_id(int can_id) {
		this.can_id = can_id;
	}

	void setDevice_number(int device_number) {
		this.device_number = device_number;
	}

}
