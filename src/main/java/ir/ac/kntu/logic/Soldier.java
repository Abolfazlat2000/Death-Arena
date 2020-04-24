package ir.ac.kntu.logic;

public class Soldier {
    private int health;
    private int damage;
    private int id;
    private Gun gun;
    private boolean isAlive = true;
    private boolean gpA;
    public Soldier(int id, boolean gpA, Gun gun) {
        this.id = id;
        this.gpA = gpA;
        this.gun = gun;
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

    public int getDamage() {
        return this.damage;
    }
}
