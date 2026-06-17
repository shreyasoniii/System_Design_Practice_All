package org.example;
import java.util.*;
public class Dice {
    int numOfDice;

    public Dice(int numOfDice) {
        this.numOfDice = numOfDice;
    }
    int rollDice(){
       int sum=0;
       for (int i=0;i<numOfDice;i++){
           sum+=(int) (Math.random()*6)+1;

       }
       return sum;
    }

    public int getNumOfDice() {
        return numOfDice;
    }

    public void setNumOfDice(int numOfDice) {
        this.numOfDice = numOfDice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return numOfDice == dice.numOfDice;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numOfDice);
    }
}
