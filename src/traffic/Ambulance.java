package traffic;

public class Ambulance extends Vehicle {
    public Ambulance(String id, int startX, int startY, int destX, int destY) {
        super(id, startX, startY, destX, destY);
    }

    @Override
    public boolean isEmergency() {
        return true; 
    }
}