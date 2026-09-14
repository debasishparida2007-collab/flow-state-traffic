# Smart City Traffic Simulation Engine

Smart City Traffic Simulation Engine developed using pure Java (without any external library/frameworks) as part of the project for the Java Course, VITyarthi "Build Your Own Project"

## Description

This project is a command-line simulation of a dynamic urban traffic grid. It enables the user to model autonomous vehicle flow through various intersections, dynamically adjust traffic light timings based on real-time vehicle density, and prioritize emergency vehicles through automated overrides. The system keeps a record of throughput and wait-time metrics for each simulation cycle.

## Key Features

*   **Vehicle Generation and Management:** Dynamic spawning of civilian and emergency vehicles with strict starting coordinates and destinations.
*   **Dynamic Intersection Control:** Calculation of queue lengths at crossroads to automate traffic light states (Red/Yellow/Green).
*   **Emergency Vehicle Override:** Automated detection of ambulances to force green-light sequences, ensuring zero-delay crisis routing.
*   **Metrics and Analytics:** Calculation of total throughput, average wait times, and active vehicle counts.
*   **File-Based Configuration:** Simulation parameters (grid size, spawn rates, time limits) loaded from a local text file.
*   **Data Persistence:** Simulation history and final metrics reports are persisted between runs by storing them in local log files.
*   **Robust Error Handling:** Custom checked exceptions for invalid grid coordinates, malformed configuration files, and routing failures.

## Technologies / Tools Used

*   Java 21 edition builds on the standard edition with focus on the `java.io`, `java.util`, and `java.util.stream` libraries for file management, collections, and queue processing.
*   Fully executable via the command line with no GUI dependencies.
*   No external dependencies or frameworks.

## Project Structure


```text
flow-state-traffic/
├── src/
│   ├── SimulationEngine.java
│   └── traffic/
│       ├── SimulationConfig.java
│       ├── CityGrid.java
│       ├── Intersection.java
│       ├── Vehicle.java
│       ├── CivilianCar.java
│       ├── Ambulance.java
│       ├── MetricsReporter.java
│       ├── InvalidCoordinateException.java
│       └── ConfigurationException.java
├── data/
│   ├── config.txt
│   └── simulation_metrics.log
├── README.md
└── statement.md




## How to Install and Run

1.  **Install Java 21+ (JDK):** See which version of java is installed by running `java -version` in terminal/command prompt. 
2.  **Go into the project folder:**
    ```bash
    cd flow-state-traffic
    ```
3.  **Compile:**
    ```bash
    javac -d out src/traffic/*.java src/SimulationEngine.java
    ```
4.  **Run:**
    ```bash
    java -cp out SimulationEngine
    ```
    *Note: Assume the evaluator has no prior context about your project; these commands will execute the program fully from the terminal. The directory 'data' and the metrics file will be created on the first run.*

## How to Test

The project was hand-tested with a series of commands and configurations being executed in the console to ensure that all features are functioning properly. The following steps have been carried out:
1.  Configured the grid size and spawned a batch of 50 vehicles using `config.txt`.
2.  Ran the simulation and confirmed that standard `CivilianCar` objects correctly stop and wait at red lights, incrementing their wait-time counters.
3.  Introduced an `Ambulance` into the grid and verified that the `Intersection` automatically triggered an emergency override to turn the light green.
4.  Confirmed that vehicles are successfully removed from the active grid arrays once they reach their assigned destination coordinates.
5.  Tested the error handling by intentionally entering out-of-bounds coordinates in the configuration file, ensuring the `InvalidCoordinateException` was thrown and handled gracefully without crashing the program.
6.  Closed the program and checked the `data/simulation_metrics.log` file to ensure the total vehicle throughput, average delay times, and system analytics were correctly appended. 

The application can also be tested using a custom configuration file passed as an argument. Example:
```bash
java -cp out SimulationEngine data/test_config.txt

