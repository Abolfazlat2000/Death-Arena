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
        groupA.clear();
        groupB.clear();
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

        graphicsEngine.initialize(groupA,groupB);
        startGameLoop(numOfSoldier);

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

        selectedIndex = RandomHelper.nextInt(numOfSoldier);

        return group.get(selectedIndex);
    }
    public void attack(Soldier soldier1 , Soldier soldier2){
        boolean firstHited = RandomHelper.nextInt(100) < soldier1.getGun().getHitRate();
        boolean secondHited = RandomHelper.nextInt(100) < soldier2.getGun().getHitRate();
        if (firstHited){
            soldier2.setHealth(soldier2.getHealth() - soldier1.getGun().getDamageRng());
            if (soldier2.getHealth() <= 0){
                soldier2.setAlive(false);
            }
            if (soldier2.isAlive()){
                //B's turn
                if (secondHited){
                    soldier1.setHealth(soldier1.getHealth() - soldier2.getGun().getDamageRng());
                    if (soldier1.getHealth() <= 0){
                        soldier1.setAlive(false);
                    }
                } else{
                    //print("B couldn't attack")
                }
            }
        } else if (secondHited){
            //print("A couldn't attack")
            soldier1.setHealth(soldier1.getHealth() - soldier2.getGun().getDamageRng());
            if (soldier1.getHealth() <= 0){
                soldier1.setAlive(false);
            }

        } else {
            //print("tie")
        }
    }

    public boolean deleteDeathSoldier(Soldier a , Soldier b){
        if(!a.isAlive()){
            groupA.remove(a);
            return true;
        }
        if (!b.isAlive()){
            groupB.remove(b);
            return true;
        }
        return false;
    }
    public void startGameLoop(int numOfSoldier) {
        //TODO: Add Game Logic Loop here - Graphics also go here

        while (groupB.size() >= 0 && groupA.size() >= 0) {
            currentASoldier = selectSoldier(groupA, numOfSoldier);
            currentBSoldier = selectSoldier(groupB, numOfSoldier);
//            System.out.println(currentASoldier.toString());
//            System.out.println(currentBSoldier.toString());

            if (aStarting()) {
                // A attacking first
                attack(currentASoldier, currentBSoldier);
            } else {
                attack(currentBSoldier, currentASoldier);
            }
//            System.out.println(currentASoldier.toString());
//            System.out.println(currentBSoldier.toString());
            if (deleteDeathSoldier(currentASoldier, currentBSoldier)){
                numOfSoldier--;
            }
            if (numOfSoldier<0){
                break;
            }

        }
        if (groupA.size() == 0){
            victoryState = VictoryState.WIN_A;
        }else{
            victoryState = VictoryState.WIN_B;
        }

    }


    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}


}
