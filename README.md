[![Gradle](https://github.com/Team5430/Command-Based-Startoff/actions/workflows/Build.yml/badge.svg?branch=master)](https://github.com/Team5430/Command-Based-Startoff/actions/workflows/Build.yml)
<br />
This repository contains the command-based code we (Team 5430 Pirate Robolution) have been working on. 
To download the code, download as a zip/Open in Github Desktop, 
`git clone https://github.com/Team5430/2023-USS-Austin.git` in a terminal .

Authors: <br />  

jiolinsangan@gmail.com (Jio A. Linsangan) <br />

erueda0618@gmail.com (Ethan R. Rueda) <br />  

rmon.led@gmail.com (Ramon Ledesma) <br />  

riomaneclang@gmail.com (Rio Maneclang) <br />  

[unfinished]

"java/frc/robot" holds the actual java files.
To access this directory, head over to "src/main"

- Constants -
Holds numbers and values which are not changed and stay constant that are used for code, such as motor ports, joysticks, and numbers used for calculations.

- Main -
Holds the neccessities for the robot to read the rest of the code and function. Do not mess with.

- Robot -
Holds the robot container and command scheduler used by the subsystems in command-based.

- RobotContainer -
Holds the command-based joysticks as well as their command bindings. Also holds the subsystems and default commands for the command scheduler.

Commands
- Autos -
Holds sets of autonomous routines.

Subsystems

- gripperSub -
The subsystem for the Gripper. Contains motors and methods to control the motors

- driveTrain -
The subsystem for Drive. Holds the motor objects for the motors of the drive chassis and methods to control the drive. Also holds the Gyro, alongside methods and variables for reading from and managing the gyro (We use a navX MXP).

- rotationSub -
The subsystem for the shoulder. Holds the motor object for the arm rotation and the methods used to control it.

- extendSub -
Subsystem that contains motors and methods to control said motors.

