# Project Statement: Flow State Traffic Simulator

## Problem Statement

Traffic jams cause a lot of frustration for drivers.. For emergency vehicles these delays can lead to serious risks. Many traffic lights today operate on fixed timers. That means they don’t respond to traffic conditions. They also can’t respond quickly when an ambulance needs to pass. This results in response times when every second counts.

## Scope of the Project

I am creating a command-line traffic simulator using Java. No external libraries or graphical user interfaces are allowed. The focus is on the core logic and object-oriented design. The goal is to build an intersection system that tracks waiting cars in real time. It must handle emergency overrides. Log performance data directly to the terminal.

## Target Users

* **Traffic Enthusiasts & City Planners:** People who want to see how dynamic traffic algorithms might improve city flow.

* **Emergency Response Coordinators:** Individuals who care about faster ambulance response times and want to see how automated green-light systems could help.

* **Course Evaluators:** Instructors who want to assess my use of Java concepts, like object-oriented programming, custom exceptions and file handling.

## High-Level Features

* **Smart Traffic Lights:** The system doesn’t use fixed timers. Instead intersections monitor the number of waiting vehicles. Adjust their Red, Yellow and Green signals dynamically.

* **Ambulance Override:** When an emergency vehicle appears in the simulation the system detects it. Immediately clears the way by forcing a green light sequence.

* **Custom Traffic Generation:** The simulation reads a text file to generate a mix of regular cars and ambulances. Each has a defined starting point and destination.

* **Live Metrics Tracking:** During the simulation the system tracks how many vehicles pass through and calculates their wait time. At the end all data is saved to a log file.
