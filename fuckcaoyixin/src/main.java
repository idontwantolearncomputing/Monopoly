package fuckcaoyixin.src;

import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Game game = new Game();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Monopoly game:");
        System.out.println("To start the game, please input your name, starting position , and starting money");
        System.out.println("you can type finish if you finish adding players");

        for (int i = 1;i<=3;i++) {
            System.out.println("(no more than 3 players)");
            System.out.println("Enter player details or 'finish':");
            String input = scan.next();
            if(input.equalsIgnoreCase("finish")){
                break;
            }
            String name = input;
            int position = scan.nextInt();
            int money = scan.nextInt();
            game.addPlayer(i,name,position,money);
            if(game.players.size()==3){
                break;
            }
        }
        System.out.println(game.players.size() + " players are added");
        game.showPlayers();
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            board.setVisible(true);
        });
        if(scan.next().equalsIgnoreCase("info")){
            game.showPlayers();
        }
    }
}
