package traffic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class MetricsReporter {
    public void saveMetrics(int totalVehicles, int totalWaitTime) {
        String logPath = "data/simulation_metrics.log";
        
        try (FileWriter fw = new FileWriter(logPath, true);
             PrintWriter pw = new PrintWriter(fw)) {
             
            pw.println("=== Simulation Run: " + LocalDateTime.now() + " ===");
            pw.println("Total Vehicles Processed : " + totalVehicles);
            pw.println("Cumulative Wait Time     : " + totalWaitTime + " cycles");
            pw.println("Average Wait Time        : " + (totalVehicles > 0 ? (totalWaitTime / totalVehicles) : 0));
            pw.println("====================================================\n");
            
            System.out.println("📄 Final metrics successfully written to " + logPath);
            
        } catch (IOException e) {
            System.err.println("❌ Critical Error: Could not write to log file.");
        }
    }
}