import traffic.*;

public class SimulationEngine {
    public static void main(String[] args) {
        System.out.println("🚦 Starting Flow State Traffic Simulator...");
        
        String configFilePath = "data/config.txt";
        if (args.length > 0) {
            configFilePath = args[0];
        }
        
        System.out.println("Loading configuration from: " + configFilePath);
        
        SimulationConfig config = new SimulationConfig();
        MetricsReporter reporter = new MetricsReporter();
        
        try {
            // 1. Initialize System
            config.loadConfig(configFilePath);
            CityGrid grid = new CityGrid(config.getGridSize());
            
            // 2. Spawn Vehicles
            System.out.println("Spawning vehicles...");
            grid.addVehicle(new CivilianCar("CAR-01", 0, 0, 4, 4));
            grid.addVehicle(new CivilianCar("CAR-02", 0, 0, 3, 3));
            grid.addVehicle(new Ambulance("AMB-99", 0, 0, 4, 4));
            
            // 3. Run Simulation Loop
            System.out.println("\n--- Running Simulation Cycles ---");
            for (int i = 0; i < config.getSimulationTicks(); i++) {
                System.out.println("\n[Tick " + (i + 1) + "]");
                grid.processGridCycle();
            }
            
            // 4. Wrap up and Log Data
            System.out.println("\nSimulation complete. Generating reports...");
            reporter.saveMetrics(3, 12); // Simulated metric totals for this run
            
            System.out.println("✅ All done! Check data/simulation_metrics.log for details.");
            
        } catch (ConfigurationException | InvalidCoordinateException e) {
            System.err.println("❌ Fatal Error: " + e.getMessage());
        }
    }
}