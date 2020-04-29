package ir.ac.kntu.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ir.ac.kntu.util.RandomHelper;

public class Director {

    private List<Soldier> groupA ;
    private List<Soldier> groupB ;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;

    //Scanner scanner = new Scanner(System.in);
    public Director(GraphicsEngine graphicsEngine) {
        //TODO: Intialize soldiers
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();

        this.graphicsEngine = graphicsEngine;

        victoryState = VictoryState.NOT_FINISHED;
    }
    public Soldier equipSoldier(int i){
        Soldier soldier;
        if (RandomHelper.nextInt(100) > 30){
            AssultRifle assultRifle = new AssultRifle();
            soldier = new Soldier(i+1,true,assultRifle,RandomHelper.nextInt(90)+10);
            calibreSetter(soldier);
        } else{
            SniperRifle sniperRifle = new SniperRifle(RandomHelper.nextBoolean());
            soldier = new Soldier(i+1,true,sniperRifle,RandomHelper.nextInt(90)+10);
            if (sniperRifle.isScope()){
                soldier.getGun().setHitRate(soldier.getGun().getHitRate() + RandomHelper.nextInt(10) + 5);
            }
            //System.out.println(sniperRifle.isScope());
            calibreSetter(soldier);
        }

        return soldier;

    }
    public void creatTeams(int numOfSoldier) throws InterruptedException, IOException {
        groupA.clear();
        groupB.clear();

        for(int i=0; i < numOfSoldier; i++){
            groupA.add(equipSoldier(i));
            groupB.add(equipSoldier(i));
        }

        graphicsEngine.initialize(groupA,groupB);
        startGameLoop();

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
                }
            }
        } else if (secondHited){
            //print("A couldn't attack")
            soldier1.setHealth(soldier1.getHealth() - soldier2.getGun().getDamageRng());
            if (soldier1.getHealth() <= 0){
                soldier1.setAlive(false);
            }

        }
        graphicsEngine.visualizeFight(soldier1,soldier2,firstHited,secondHited);
    }

    public void deleteDeathSoldier(Soldier a , Soldier b){
        if(!a.isAlive()){
            groupA.remove(a);

        }
        if (!b.isAlive()){
            groupB.remove(b);

        }

    }
    public void startGameLoop() throws InterruptedException, IOException {
        //TODO: Add Game Logic Loop here - Graphics also go here

        while (groupB.size() != 0 && groupA.size() != 0) {

            currentASoldier = selectSoldier(groupA, groupA.size());
            currentBSoldier = selectSoldier(groupB, groupB.size());



            if (aStarting()) {
                // A attacking first
                attack(currentASoldier, currentBSoldier);
            } else {
                attack(currentBSoldier, currentASoldier);
            }

            deleteDeathSoldier(currentASoldier, currentBSoldier);
            //Thread.sleep(1000);
            graphicsEngine.initialize(groupA,groupB);
            System.in.read();

        }
        if (groupA.size() == 0){
            victoryState = VictoryState.WIN_B;
            graphicsEngine.visualizeVictoryCondition(victoryState);
        }else{
            victoryState = VictoryState.WIN_A;
            graphicsEngine.visualizeVictoryCondition(victoryState);
        }

    }


    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}


}
