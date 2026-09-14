package traffic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimulationConfig {
    private int gridSize = 5;
    private int simulationTicks = 10;

    public void loadConfig(String filepath) throws ConfigurationException {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    if (parts[0].equals("GRID_SIZE")) gridSize = Integer.parseInt(parts[1]);
                    if (parts[0].equals("SIMULATION_TICKS")) simulationTicks = Integer.parseInt(parts[1]);
                }
            }
            System.out.println("✅ Configuration loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            throw new ConfigurationException("Invalid or missing config file at: " + filepath);
        }
    }

    public int getGridSize() { return gridSize; }
    public int getSimulationTicks() { return simulationTicks; }
}