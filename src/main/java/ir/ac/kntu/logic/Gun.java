package ir.ac.kntu.logic;

public class Gun {
    private int damageRng;
    private int hitRate;
    private Calibre calibre;

    public Gun(int damageRng, int hitRate) {
        this.damageRng = damageRng;
        this.hitRate = hitRate;
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

    public void setHitRate(int hitRate) {
        this.hitRate = hitRate;
    }

    public int getHitRate() {
        return hitRate;
    }


}
