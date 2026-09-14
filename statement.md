# Project Statement: Smart City Traffic Simulation Engine

## Problem Statement
Urban traffic congestion leads to severe commuter delays and significantly hinders emergency vehicle response times. Static, timer-based traffic light systems are inefficient at handling fluctuating vehicle density and lack the ability to dynamically prioritize critical routing for crisis management, such as ambulances responding to active emergencies.

## Scope of the Project
This project is a pure Java, command-line simulation designed to model and analyze autonomous vehicle flow across a customizable city grid. The scope includes building a dynamic intersection management system that calculates real-time wait queues to adjust traffic light states. It strictly focuses on backend logic, object-oriented architecture, and terminal-based metrics generation, without relying on external GUI frameworks or third-party libraries.

## Target Users
* **Urban Planners & Traffic Engineers:** Professionals seeking a theoretical model to test dynamic routing algorithms and intersection efficiency.
* **Emergency Response Coordinators:** Users analyzing the impact of automated green-light overrides on ambulance transit times.
* **Academic Evaluators:** Instructors reviewing the application of advanced Java concepts, including inheritance, nested classes, and custom exception handling.

## High-Level Features
* **Dynamic Intersection Control:** Traffic lights automatically transition states (Red/Yellow/Green) by calculating real-time vehicle density at each node.
* **Emergency Override Protocol:** The system automatically detects active ambulance entities and forces an immediate green-light sequence to ensure zero-delay routing.
* **Automated Vehicle Generation:** A configuration-driven engine that spawns civilian and emergency vehicles with validated starting and destination coordinates.
* **Real-Time Metrics Tracking:** Continuous calculation and logging of total vehicle throughput, active grid population, and average delay times to local system files.
