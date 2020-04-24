package ir.ac.kntu.logic;


import java.util.ArrayList;
import java.util.List;

import ir.ac.kntu.util.RandomHelper;
public class Director {

    private List<Soldier> groupA ;
    private List<Soldier> groupB ;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;


    public Director(GraphicsEngine graphicsEngine) {
        //TODO: Intialize soldiers
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();

        this.graphicsEngine = graphicsEngine;

        victoryState = VictoryState.NOT_FINISHED;
    }
    public void creatTeams(int numOfSoldier){

        for(int i=0; i < numOfSoldier; i++){
            Soldier soldier;
            if (RandomHelper.nextInt(100) > 30){
                AssultRifle assultRifle = new AssultRifle();
                soldier = new Soldier(i+1,true,assultRifle);
            } else{
                SniperRifle sniperRifle = new SniperRifle();
                soldier = new Soldier(i+1,true,sniperRifle);
            }

            groupA.add(soldier);
        }
        for(int i=0; i < numOfSoldier; i++){
            Soldier soldier;
            if (RandomHelper.nextInt(100) > 30){
                AssultRifle assultRifle = new AssultRifle();
                soldier = new Soldier(i+1,false,assultRifle);
            } else{
                SniperRifle sniperRifle = new SniperRifle();
                soldier = new Soldier(i+1,false,sniperRifle);
            }

            groupB.add(soldier);
        }
        startGameLoop(numOfSoldier);
    }
    public void startGameLoop(int numOfSoldier) {
        //TODO: Add Game Logic Loop here - Graphics also go here
        int firstSoldier,secondSoldier;
        do {
            firstSoldier = RandomHelper.nextInt(numOfSoldier);
        }while (!groupA.get(firstSoldier).isAlive());
        do {
            secondSoldier = RandomHelper.nextInt(numOfSoldier);
        }while (!groupB.get(secondSoldier).isAlive());

        currentASoldier = groupA.get(firstSoldier);
        currentBSoldier = groupB.get(secondSoldier);

        firstSoldier++;
        secondSoldier++;

        if(currentASoldier.getGun().getClass() == SniperRifle.class){
            //print Rifle state
            ((SniperRifle) currentASoldier.getGun()).setScope(RandomHelper.nextBoolean());
        }
        if(currentBSoldier.getGun().getClass() == SniperRifle.class){
            //print Rifle state
            ((SniperRifle) currentBSoldier.getGun()).setScope(RandomHelper.nextBoolean());
        }
    }


    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}


}
