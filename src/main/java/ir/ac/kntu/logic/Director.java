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
                soldier = new Soldier(i+1,true,assultRifle,RandomHelper.nextInt(90)+10);
                calibreSetter(soldier);
            } else{
                SniperRifle sniperRifle = new SniperRifle(RandomHelper.nextBoolean());
                soldier = new Soldier(i+1,true,sniperRifle,RandomHelper.nextInt(90)+10);
                //System.out.println(sniperRifle.isScope());
                calibreSetter(soldier);
            }

            groupA.add(soldier);
        }

        for(int i=0; i < numOfSoldier; i++){
            Soldier soldier;
            if (RandomHelper.nextInt(100) > 40){
                AssultRifle assultRifle = new AssultRifle();
                soldier = new Soldier(i+1,false,assultRifle,RandomHelper.nextInt(90)+10);
                calibreSetter(soldier);
            } else{
                SniperRifle sniperRifle = new SniperRifle(RandomHelper.nextBoolean());
                soldier = new Soldier(i+1,false,sniperRifle,RandomHelper.nextInt(90)+10);
                //System.out.println(sniperRifle.isScope());
                calibreSetter(soldier);
            }

            groupB.add(soldier);
        }
        startGameLoop(numOfSoldier);
        /*
        for (int i = 0; i < numOfSoldier; i++){
            System.out.println(groupA.get(i).toString());
            System.out.println(groupB.get(i).toString());
        }
        */
    }
    public void calibreSetter(Soldier soldier){
        if (RandomHelper.nextBoolean()){
            soldier.getGun().setCalibre(Calibre.HIGH);
            soldier.getGun().setHitRate(soldier.getGun().getHitRate() - 10);
            soldier.getGun().setDamageRng(soldier.getGun().getDamageRng() + 10);
        }else{
            soldier.getGun().setCalibre(Calibre.LOW);
            soldier.getGun().setHitRate(soldier.getGun().getHitRate() + 15);
        }

    }
    public boolean aStarting(){
        return RandomHelper.nextBoolean();
    }
    public Soldier selectSoldier(List<Soldier> group , int numOfSoldier){
        int selectedIndex ;
        do {
            selectedIndex = RandomHelper.nextInt(numOfSoldier);
        }while (!group.get(selectedIndex).isAlive());
        return group.get(selectedIndex);
    }
    public void startGameLoop(int numOfSoldier) {
        //TODO: Add Game Logic Loop here - Graphics also go here


        currentASoldier = selectSoldier(groupA, numOfSoldier);
        currentBSoldier = selectSoldier(groupB, numOfSoldier);
//        System.out.println(currentASoldier.toString());
//        System.out.println(currentBSoldier.toString());

        if (aStarting()){
            // A attacking first

        }


    }


    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}


}
