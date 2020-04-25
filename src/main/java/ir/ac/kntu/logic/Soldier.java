package ir.ac.kntu.logic;

public class Soldier {
    private int health;

    private int id;
    private Gun gun;
    private boolean isAlive = true;
    private boolean gpA;
    public Soldier(int id, boolean gpA, Gun gun, int health) {
        this.id = id;
        this.gpA = gpA;
        this.gun = gun;
        this.health = health;
    }

    public Gun getGun() {
        return gun;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isGpA() {
        return gpA;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "health=" + health +
                ", id=" + id +
                ", gun=" + gun +

                ", Calibre=" + getGun().getCalibre() +
                ", isAlive=" + isAlive +
                ", gpA=" + gpA +
                '}';
    }
}
