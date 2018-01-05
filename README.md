# ConfLoader
A repository for the code that runs a configuration file loader

## This repository includes:
1. The loader classes, in the loader directory
2. A sample configuration file, sample.conf
3. An explination of the conf file, below

## Features todo
- A network loader, to load conf file from the driverstation

## Sample Conf file
```
System Main {
	Piston (id = 0);
	Motor (reversed = false);
	Joystick (major = x);
}
System Drivetrain {
	Motor Left (id = 1, reversed = false);
	Motor Right (id = 2);
}
System Grabber {
	Motor Main (id = 3);
	Piston Grabber (number = 2);
}
System DriverStation {
	Joystick Left (usb = 1, x = 1, major = y);
}
```

## Explination

The primary purpose of the configuration file is to avoid writing code specific to a robot configuration, so the conf file is modular, and provides a single point to edit.

The conf file is split into parts, called `System`s.
Each system has a set of parts, each of which have a set of properties.
The `Main` system is unique, because it does not set gettable parameters, but rather sets global defaults.
Other systems will automatically use these values, unless a value is explicitly set.
All other systems have a set of parts, each of which have several values.
Parts are mostly straight forward, but `piston` refers to pneumatic pistons.

## Docs
- `*` can be set in Main
### Parts
- `Piston`: a pneumatic piston (`*id` = the can id of the board, `number` = the number on the board)
- `Motor`: a physical motor (`id` = the can id of the motor, `*reversed` = whether the motor should be reversed)
- `Joystick`: a joystick on the driverstation (`usb` = the usb numbers, `*x` = the x axis, `*y` = the y axis, `*z` = the z axis, `*major` = the major axis (the most import axis))
