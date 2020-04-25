package ir.ac.kntu.logic;

public class SniperRifle extends Gun {
    private boolean scope;

    public SniperRifle() {
        super(20,60);
    }

    public SniperRifle(boolean scope) {
        super(20, 60);
        this.scope = scope;
    }

    public boolean isScope() {
        return scope;
    }

    public void setScope(boolean scope) {
        this.scope = scope;
    }
}
