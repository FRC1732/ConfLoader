package org.usfirst.frc.team1732.robot.robotConfiguration;

public class Motor extends Part {
	private int can_id;
	private boolean reversed;

	public Motor(String system, String name, int can_id, boolean reversed) {
		super(system, name);
		this.can_id = can_id;
		this.reversed = reversed;
	}

	public int getCan_id() {
		return can_id;
	}

	public boolean isReversed() {
		return reversed;
	}

	void setCan_id(int can_id) {
		this.can_id = can_id;
	}

	void setReversed(boolean reversed) {
		this.reversed = reversed;
	}
}
