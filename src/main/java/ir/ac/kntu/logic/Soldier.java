package ir.ac.kntu.logic;

public class Soldier {
    private int health;
    private int damage;
    private int id;
    //private Gun gun;
    private boolean isAlive = true;

    public Soldier(int health, int damage, int id) {
        this.health = health;
        this.damage = damage;
        this.id = id;
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
