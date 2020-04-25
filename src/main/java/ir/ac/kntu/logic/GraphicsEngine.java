package ir.ac.kntu.logic;


import java.util.List;

public interface GraphicsEngine {


    public void initialize(List<Soldier> groupA, List<Soldier> groupB);

    public void visualizeFight(Soldier currentASoldier,Soldier currentBSoldier,boolean firstHited,boolean secondHited);

    public void visualizeDeath();

    public void visualizeVictoryCondition(Director.VictoryState victoryState);
}
