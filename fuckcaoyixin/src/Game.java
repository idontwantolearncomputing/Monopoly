package fuckcaoyixin.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    List<Player> players;
    public Game(){
        players = new ArrayList<>();
    }
    public void addPlayer(int playerID ,String name, int startingPosition, int startingMoney){
        Player player = new Player(playerID,name, startingPosition,startingMoney);
        players.add(player);
    }
    public void playRound(){
        for(Player player : players){
            int moveSpaces = (int)(Math.random()*6)+1;
            player.move(moveSpaces);
            System.out.println(player.getName() + "moved to postion" + player.getPosition());
        }
    }
    public void showPlayers(){
        for(Player player:players){
            System.out.println("Player "+player.getPlayerID()+": "+player.getName()+" Position: " + player.getPosition() + ", Money: " + player.getMoney());
        }
    }

}
