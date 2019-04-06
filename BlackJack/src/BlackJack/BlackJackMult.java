/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
/**
 *
 * @author line8847
 */
public class BlackJackMult {
    private ArrayList<Playerable> players;
    private static final int amount = 4;
	public BlackJackMult()
	{
            players = new ArrayList<Playerable>();
            players.add(new Dealer());
            for (int i = 1; i <= amount; i ++){
              players.add(new Player());
            }
	}

	public void playGame()
	{
                Deck deck = new Deck();
                deck.shuffle();
		Scanner keyboard = new Scanner(System.in);
                char answer;
                int[] playerWins = new int[amount+1];
                for (int i = 0; i < amount+1; i++){
                  playerWins[i] = 0;
                }
                int dealerWins = 0;
                do{
                   
                    
                    char choice = 'n';
                    for (Playerable p: players){
                      p.addCardToHand(deck.nextCard());
                      p.addCardToHand(deck.nextCard());
                    }
                    
                    int temp = 1;
                    for (Playerable p: players){
                      System.out.println("Player " + temp);
                      do{
                        
                        System.out.println("Current hand: " + p + " Value: "+ p.getHandValue());
                        System.out.println("Do you want to hit?");
                        choice = keyboard.next().charAt(0);
                        
                        if (choice == 'y'){
                            p.addCardToHand(deck.nextCard());
                        }
                        if (p.getHandValue() > 21){
                            break;
                        }

                      }while(choice != 'n' );
                      temp++;
                    }
                    //Dealer turn
                    while (players.get(0).getHandValue() <= 21){
                        players.get(0).addCardToHand(deck.nextCard());
                    }
                    for (int i = 1; i <= amount; i++){
                        System.out.println("Player" + i + ": \nHand Value: " + players.get(i).getHandValue() + "\nHand Size: " + players.get(i).getHandSize() + "\nCards: " + players.get(i));
                    }
                  
                    System.out.println("\n\nDealer: \nHand Value: " + players.get(0).getHandValue() + "\nHand Size: " + players.get(0).getHandSize() + "\nCards: " + players.get(0)+"\n\n");
                    ArrayList<Integer> values = new ArrayList<Integer>();
                    
                    for (Playerable p: players){
                        if (p.getHandValue() <= 21){
                            
                            values.add(p.getHandValue());
                        }
                        
                    }
                    int big = Collections.max(values);
                 
                    int count = 0;
                    for (Playerable p: players){
                        if (p.getHandValue() == big){
                            if (count == 0){
                                System.out.println("Dealer wins!");
                                playerWins[0]++;
                            }
                            else{
                                System.out.println("Player " + count + " wins!");
                                playerWins[count]++;
                            }
                            
                            break;
                        }
                        count++;
                    }
                   
                    
                    int c = 0;
                    for (Playerable p: players){
                        p.setWinCount(playerWins[c]);
                        if (c == 0){
                            
                            System.out.println("Dealer wins: " + p.getWinCount());
                        }
                        else{
                            System.out.println("Player "+ c + " wins: " + p.getWinCount());
                        }
                        c++;
                    }
                        
                    
                    
                    System.out.println("Do you want to play again?");
                    answer= keyboard.next().charAt(0);
                    for (Playerable p: players){
                        p.resetHand();
                    }
                    deck.shuffle();
                }while(answer != 'n');
        }

        public static void main(String[] args)
	{
		BlackJackMult game = new BlackJackMult();
		game.playGame();
	}
}
