package traffic;

public abstract class Vehicle {
    protected String id;
    protected int currentX;
    protected int currentY;
    protected int destX;
    protected int destY;
    protected int waitTime;

    public Vehicle(String id, int startX, int startY, int destX, int destY) {
        this.id = id;
        this.currentX = startX;
        this.currentY = startY;
        this.destX = destX;
        this.destY = destY;
        this.waitTime = 0;
    }

    public abstract boolean isEmergency();
    
    public void incrementWaitTime() {
        this.waitTime++;
    }
    
    public String getId() { return id; }
    public int getWaitTime() { return waitTime; }
}