package traffic;

import java.util.LinkedList;
import java.util.Queue;

public class Intersection {
    private String id;
    private Queue<Vehicle> waitingQueue;
    private boolean isGreenLight;

    public Intersection(String id) {
        this.id = id;
        this.waitingQueue = new LinkedList<>();
        this.isGreenLight = false; 
    }

    public void addVehicleToQueue(Vehicle v) {
        waitingQueue.add(v);
        System.out.println("Queue at " + id + " increased. Total waiting: " + waitingQueue.size());
    }

    public void evaluateLightState() {
        for (Vehicle v : waitingQueue) {
            if (v.isEmergency()) {
                isGreenLight = true;
                System.out.println("🚨 EMERGENCY OVERRIDE at " + id + ": Light forced GREEN for " + v.getId());
                return;
            }
        }

        if (waitingQueue.size() > 3) {
            isGreenLight = true;
            System.out.println("🚦 Heavy traffic at " + id + ": Light turned GREEN.");
        } else {
            isGreenLight = !isGreenLight;
        }
    }

    public void processTrafficFlow() {
        if (isGreenLight && !waitingQueue.isEmpty()) {
            Vehicle clearedVehicle = waitingQueue.poll();
            System.out.println("✅ " + clearedVehicle.getId() + " passed through " + id);
        } else if (!isGreenLight && !waitingQueue.isEmpty()) {
            for (Vehicle v : waitingQueue) {
                v.incrementWaitTime();
            }
        }
    }
}