package ir.ac.kntu.logic;

public class Gun {
    private int damageRng;
    private int hitRate;
    private Calibre calibre;

    public Gun() {
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }

    public int getDamageRng() {
        return damageRng;
    }

    public void setDamageRng(int damageRng) {
        this.damageRng = damageRng;
    }

    public int getHitRate() {
        return hitRate;
    }

    public void setHitRate(int hitRate) {
        this.hitRate = hitRate;
    }
}
