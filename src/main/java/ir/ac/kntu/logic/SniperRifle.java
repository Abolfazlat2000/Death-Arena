package ir.ac.kntu.logic;

public class SniperRifle extends Gun {
    private boolean scope;


    public SniperRifle(boolean scope) {
        super(20, 60);
        this.scope = scope;
    }

    public boolean isScope() {
        return scope;
    }

}
