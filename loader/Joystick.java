package org.usfirst.frc.team1732.robot.robotConfiguration;

public class Joystick extends Part {

	private int usb_id;
	private char major_axis;
	private int x_axis;
	private int y_axis;
	private int z_axis;

	public Joystick(String system, String name, int usb_id, char major_axis, int x_axis, int y_axis, int z_axis) {
		super(system, name);
		this.usb_id = usb_id;
		this.major_axis = major_axis;
		this.x_axis = x_axis;
		this.y_axis = y_axis;
		this.z_axis = z_axis;
	}

	public int getUsb_id() {
		return usb_id;
	}

	public int getMajor_axis() {
		switch(major_axis) {
			case 'x':return getX_axis();
			case 'y':return getY_axis();
			case 'z':return getZ_axis();
			default: return 0;
		}
	}

	public int getX_axis() {
		return x_axis;
	}

	public int getY_axis() {
		return y_axis;
	}

	public int getZ_axis() {
		return z_axis;
	}

	void setUsb_id(int usb_id) {
		this.usb_id = usb_id;
	}

	void setMajor_axis(char major_axis) {
		this.major_axis = major_axis;
	}

	void setX_axis(int x_axis) {
		this.x_axis = x_axis;
	}

	void setY_axis(int y_axis) {
		this.y_axis = y_axis;
	}

	void setZ_axis(int z_axis) {
		this.z_axis = z_axis;
	}

}
