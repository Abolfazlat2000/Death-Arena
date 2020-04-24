package ir.ac.kntu.logic;

import java.util.List;
import java.util.Scanner;

public class Director {

    private List<Soldier> groupA;
    private List<Soldier> groupB;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;
    Scanner scanner = new Scanner(System.in);
    public Director(GraphicsEngine graphicsEngine) {
        //TODO: Intialize soldiers
        System.out.println("Hi,Welcome\nplease enter number of soldier you like:");
        int num = scanner.nextInt();


        this.graphicsEngine = graphicsEngine;

        victoryState = VictoryState.NOT_FINISHED;
    }
    public static void creatTeams(int numOfSoldier){
        for(int i=0; i < numOfSoldier; i++){
            Soldier soldier;


        }
    }
    public void startGameLoop() {
        //TODO: Add Game Logic Loop here - Graphics also go here

    }


    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}


}
