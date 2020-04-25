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
    public void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier,boolean firstHited,boolean secondHited) {
        String teamName = "";
        String enemyName = "";
        if (currentASoldier.isGpA()){
            teamName = "A";
            enemyName = "B";
        }else {
            teamName = "B";
            enemyName = "A";
        }
        System.out.println("fight is running");
        System.out.println("-----------------------------------------------------");
        if (firstHited){
            System.out.println(teamName+"'s turn:");
            System.out.println(teamName+" attacked "+enemyName+" and "+enemyName +" took "+currentASoldier.getGun().getDamageRng()+" damage!");
            if (currentBSoldier.getHealth() <= 0){
                System.out.println("Oh "+enemyName+" dead!!");
            }
            if (currentBSoldier.isAlive()){
                //B's turn
                System.out.println("Now "+enemyName+"'s turn:");
                if (secondHited){
                    System.out.println(enemyName+" attacked "+teamName+" and "+teamName +" took "+currentBSoldier.getGun().getDamageRng()+" damage!");
                    if (currentASoldier.getHealth() <= 0){
                        System.out.println("Oh "+teamName+" dead!!");
                    }
                } else{
                    //print("B couldn't attack")
                    System.out.println(enemyName+" failed to attack");
                }
            }
        } else if (secondHited){
            //print("A couldn't attack")
            System.out.println(teamName+" failed to attack");
            System.out.println(enemyName+" attacked "+teamName+" and "+teamName +" took "+currentASoldier.getGun().getDamageRng()+" damage!");
            if (currentASoldier.getHealth() <= 0){
                System.out.println("Oh "+teamName+" dead!!");
            }

        } else {
            //print("tie")
            System.out.println("Tie");
        }
    }

    @Override
    public void visualizeDeath() {

    }

    @Override
    public void visualizeVictoryCondition(Director.VictoryState victoryState) {
        System.out.println("*************************************************");
        System.out.println("Game finished!");
        System.out.println(victoryState);
        System.out.println("*************************************************");
    }
}
