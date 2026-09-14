package traffic;

import java.util.ArrayList;
import java.util.List;

public class CityGrid {
    private int size;
    private List<Intersection> intersections;

    public CityGrid(int size) {
        this.size = size;
        this.intersections = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            intersections.add(new Intersection("Node-" + i));
        }
    }

    public void addVehicle(Vehicle v) throws InvalidCoordinateException {
        if (v.currentX < 0 || v.currentX >= size || v.currentY < 0 || v.currentY >= size) {
            throw new InvalidCoordinateException("Vehicle " + v.getId() + " placed outside grid bounds!");
        }
        
        if (!intersections.isEmpty()) {
            intersections.get(0).addVehicleToQueue(v);
        }
    }

    public void processGridCycle() {
        for (Intersection intersection : intersections) {
            intersection.evaluateLightState();
            intersection.processTrafficFlow();
        }
    }
}
