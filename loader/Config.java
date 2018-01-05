package org.usfirst.frc.team1732.robot.robotConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Config {
	private HashMap<String, SystemConf> systems = new HashMap<>();

	private Config() {}

	private void addSystem(SystemConf s) {
		systems.put(s.getName(), s);
	}

	public SystemConf getSystem(String system) {
		return systems.get(system);
	}

	public static Config load(String file) {
		Config c = new Config();

		int piston_id = 0;
		boolean motor_reversed = false;
		char joystick_major_axis = 'y';
		int joystick_x_axis = 0;
		int joystick_y_axis = 1;
		int joystick_z_axis = 2;


		String raw = readFile(file).trim().toLowerCase()
				.replaceAll("\t", " ").replaceAll("\\s+", " ")
				.replaceAll("\\s\\{", "{").replaceAll("\\s\\(", "(")
				.replaceAll("\\s\\}", "}").replaceAll("\\s\\)", ")")
				.replaceAll("\\{\\s", "{").replaceAll("\\(\\s", "(")
				.replaceAll("\\}\\s", "}").replaceAll("\\)\\s", ")")
				.replaceAll("\\s;", ";").replaceAll("\\s=", "=")
				.replaceAll(";\\s", ";").replaceAll("=\\s", "=")
				.replaceAll("\\s,", ",").replaceAll(",\\s", ",");
		System.out.println(raw);

		SystemConf system;
		String partType = "";
		Part part;

		String[] systems = raw.split("}");
		for(int i = 0; i < systems.length; i++) {
			system = new SystemConf(systems[i].substring(7, systems[i].indexOf('{')));
			c.addSystem(system);
			String[] parts = systems[i].substring(systems[i].indexOf('{')+1).split(";");
			if(system.getName().equals("main")) {
				for(int j = 0; j < parts.length; j++) {
					partType = parts[j].substring(0, parts[j].indexOf('('));
					String[] properties = parts[j].substring(parts[j].indexOf('(')+1, parts[j].length()-1).split(",");
					for(int k = 0; k < properties.length; k++) {
						String[] tmp = properties[k].split("=");
						switch(tmp[0]) {
							case "id":
								if(partType.equals("piston")) {
									piston_id = Integer.parseInt(tmp[1]);
								}
								break;
							case "reversed":
								if(partType.equals("motor")) {
									motor_reversed = Boolean.parseBoolean(tmp[1]);
								}
								break;
							case "major":
								if(partType.equals("joystick")) {
									joystick_major_axis = tmp[1].charAt(0);
								}
								break;
							case "x":
								if(partType.equals("joystick")) {
									joystick_x_axis = Integer.parseInt(tmp[1]);
								}
								break;
							case "y":
								if(partType.equals("joystick")) {
									joystick_y_axis = Integer.parseInt(tmp[1]);
								}
								break;
							case "z":
								if(partType.equals("joystick")) {
									joystick_z_axis = Integer.parseInt(tmp[1]);
								}
								break;

						}
					}
				}
			}else {
				for(int j = 0; j < parts.length; j++) {
					switch(parts[j].substring(0, parts[j].indexOf(' '))) {
						case "piston":part = new Piston(system.getName(), parts[j].substring(parts[j].indexOf(' ')+1, parts[j].indexOf('(')), piston_id, 0);break;
						case "motor":part = new Motor(system.getName(), parts[j].substring(parts[j].indexOf(' ')+1, parts[j].indexOf('(')), 0, motor_reversed);break;
						case "joystick":part = new Joystick(system.getName(), parts[j].substring(parts[j].indexOf(' ')+1, parts[j].indexOf('(')), 0, joystick_major_axis, joystick_x_axis, joystick_y_axis, joystick_z_axis);break;
						default: throw new RuntimeException("The file has bad syntax");
					}
					system.addPart(part);
					String[] properties = parts[j].substring(parts[j].indexOf('(')+1, parts[j].length()-1).split(",");
					for(int k = 0; k < properties.length; k++) {
						String[] tmp = properties[k].split("=");
						switch(tmp[0]) {
							case "id":
								((Motor) part).setCan_id(Integer.parseInt(tmp[1]));
								break;
							case "reversed":
								((Motor) part).setReversed(Boolean.parseBoolean(tmp[1]));
								break;
							case "num":
								((Piston) part).setDevice_number(Integer.parseInt(tmp[1]));
								break;
							case "usb":
								((Joystick) part).setUsb_id(Integer.parseInt(tmp[1]));
								break;
							case "x":
								((Joystick) part).setX_axis(Integer.parseInt(tmp[1]));
								break;
							case "y":
								((Joystick) part).setY_axis(Integer.parseInt(tmp[1]));
								break;
							case "z":
								((Joystick) part).setZ_axis(Integer.parseInt(tmp[1]));
								break;
							case "major":
								((Joystick) part).setMajor_axis(tmp[1].charAt(0));
								break;
						}
					}
				}
			}
		}
		return c;
	}

	public static String readFile(String file) {
		StringBuilder out = new StringBuilder();

		try (BufferedReader re = new BufferedReader(new FileReader(new File(file)))) {
			String cur = re.readLine();
			while(cur != null) {
				out.append(cur);
				cur = re.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return out.toString();
	}
}
