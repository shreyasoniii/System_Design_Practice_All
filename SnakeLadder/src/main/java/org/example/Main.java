package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Dice dice=new Dice(1);
        Player player1=new Player(1,"Shreya");
        Player player2=new Player(2,"Shivansh");
        Queue<Player>nextTurn=new LinkedList<>();
        nextTurn.add(player1);
        nextTurn.add(player2);
        JUMPER snake1 =new JUMPER(44,10);
        JUMPER snake2=new JUMPER(22,5);
        JUMPER ladder1=new JUMPER(3,56);
        JUMPER ladder2=new JUMPER(30,89);
        List<JUMPER> snake=new ArrayList<>();
        List<JUMPER>ladder=new ArrayList<>();
        snake.add(snake1);
        snake.add(snake2);
        ladder.add(ladder1);
        ladder.add(ladder2);
        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Shreya",0);
        playersCurrentPosition.put("Shivansh",0);
        BoardSize game= new BoardSize(dice,snake,ladder,nextTurn,playersCurrentPosition,100);
        game.startGame();

    }
}
