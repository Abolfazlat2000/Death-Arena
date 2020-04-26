package ir.ac.kntu;
import java.io.IOException;
import java.util.Scanner;
import ir.ac.kntu.logic.ConsoleGraphicsEngine;
import ir.ac.kntu.logic.Director;
import ir.ac.kntu.logic.GraphicsEngine;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        GraphicsEngine engine = new ConsoleGraphicsEngine(); 
        Director director = new Director(engine);
        Scanner scanner = new Scanner(System.in);
        //TODO: Start your game from here
        System.out.println("Hi,Welcome\nplease enter number of soldier you like:");
        int num = scanner.nextInt();
        director.creatTeams(num);
        scanner.close();
    }
    
}
