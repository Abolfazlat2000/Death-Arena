package ir.ac.kntu.logic;

public class SniperRifle extends Gun {
    private boolean scope;

    public SniperRifle() {
        this.setDamageRng(20);
        this.setHitRate(60);
    }

    public void setScope(boolean scope) {
        this.scope = scope;
    }
}
