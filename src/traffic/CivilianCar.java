package traffic;

public class CivilianCar extends Vehicle {
    public CivilianCar(String id, int startX, int startY, int destX, int destY) {
        super(id, startX, startY, destX, destY);
    }

    @Override
    public boolean isEmergency() {
        return false;
    }
}
