package ir.ac.kntu.logic;


import java.util.List;

public class ConsoleGraphicsEngine implements GraphicsEngine {

    //TODO: Implement Graphics Options


    @Override
    public void initialize(List<Soldier> groupA, List<Soldier> groupB) {
        System.out.println("Team A:");
        for (int i = 0 ; i <groupA.size();i++){

            System.out.println(groupA.get(i).toString());
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Team B:");
        for (int i = 0 ; i <groupB.size();i++){

            System.out.println(groupB.get(i).toString());
        }
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
