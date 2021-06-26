# AndroidApp
##### Advanced Programming 2 - Assignment 3

This Kotlin code is a Android app that let the user drive a plane.
This Android app connects to Flight-Gear server, and give you a joystick, Rudder and Throttle Sliders to control the plane.

## Application description and goal
Our users are flight researchers or pilots who want to do a test flight form anywhere using thier phone and a PC.

## Prerequisites

- Enable Developers setting and USB Debugging on your Android Phone.
- Download AndroidS/Clion to load this app onto your Android device.
- 
## Getting Started

Clone the project via the command line:
```sh
git clone https://github.com/Linoy345/androidApp.git
```

Now, connect your Android device to your computer and load the app onto your device from your favorate IDE.

Now to use the app- connect to a computer which is currently running Flight Gear and is on the same network as your Android device, then enter this computer public IP and the currently open port on Flight Gear.

A screenshot is attached:

![App_Main_Screen.jpg](Images/App_Main_Screen.jpg)

## Features
- ```IP ``` \ ```Port```. You will be asked to enter IP/Port to a computer the currently run Flight Gear.
- Connect to Flight Gear after entering IP/Port and start controlling the plane.
- Click on ```Disconnect``` to disconnect from the current Flight Gear server if you wish to connect to a new Flight Gear Server.

## Project Hierarchy

The main files in our project are as follow:

- ViewModel:
    - ControlsViewModel
- Model:
    - Client
    - FlightControls.kt
    - FlightModel
- View:
    - Joystick
    - MainActivity

## More documentation
- UML:

## Demo video
https://www.youtube.com/watch?v=Ic3aTA65_wQ
## Writers
- Linoy Sela
- Yair Yardeni












#
