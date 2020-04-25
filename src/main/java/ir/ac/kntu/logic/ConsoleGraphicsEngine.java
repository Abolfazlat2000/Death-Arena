package ir.ac.kntu.logic;

import java.util.ArrayList;

public class ConsoleGraphicsEngine implements GraphicsEngine {

    //TODO: Implement Graphics Options


    @Override
    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB) {
        System.out.println("Team A:");
        System.out.println(groupA);
        System.out.println("-----------------------------------------------------");
        System.out.println("Team B:");
        System.out.println(groupB);
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier) {

    }

    @Override
    public void visualizeDeath() {

    }

    @Override
    public void visualizeVictoryCondition(Director.VictoryState victoryState) {

    }
}
