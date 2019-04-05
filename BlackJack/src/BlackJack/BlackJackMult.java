/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.Scanner;

/**
 *
 * @author line8847
 */
public class BlackJackMult {
    private Playerable[] players;
    private static final int amount = 4;
	public BlackJackMult()
	{
            players = new Playerable[amount];
            players[0] = new Dealer();
	}

	public void playGame()
	{
                Deck deck = new Deck();
                deck.shuffle();
		Scanner keyboard = new Scanner(System.in);
                char answer;
                int playerWins = 0;
                int dealerWins = 0;
                do{
                   
                
                    char choice = 'n';
                    player.addCardToHand(deck.nextCard());
                    player.addCardToHand(deck.nextCard());
                    dealer.addCardToHand(deck.nextCard());
                    dealer.addCardToHand(deck.nextCard());
                    do{
                        System.out.println("Current hand: " + player + " Value: "+ player.getHandValue());
                        System.out.println("Do you want to hit?");
                        choice = keyboard.next().charAt(0);
                        
                        if (choice == 'y'){
                            player.addCardToHand(deck.nextCard());
                        }
                        if (player.getHandValue() > 21){
                            break;
                        }
                    }while(choice != 'n' );
                    
                    while (dealer.getHandValue() < 21){
                        dealer.addCardToHand(deck.nextCard());
                    }
                    System.out.println("Player: \nHand Value: " + player.getHandValue() + "\nHand Size: " + player.getHandSize() + "\nCards: " + player);
                    System.out.println("\n\nDealer: \nHand Value: " + dealer.getHandValue() + "\nHand Size: " + dealer.getHandSize() + "\nCards: " + dealer+"\n\n");
                    if (player.getHandValue() > 21){
                        System.out.println("The player busted! Dealer wins!");
                        dealerWins++;
                        
                    }
                    else if (dealer.getHandValue() > 21){
                        System.out.println("The dealer busted! Player wins!");
                        playerWins++;
                    }
                    else if (player.getHandValue() > dealer.getHandValue()){
                        System.out.println("The player has a bigger hand!");
                        playerWins++;
                    }
                    else if (player.getHandValue() < dealer.getHandValue()){
                        System.out.println("The dealer has a bigger hand!");
                        dealerWins++;
                    }
                    else{
                        System.out.println("Both dealer and player has the same hand values.");
                    }
                    player.setWinCount(playerWins);
                    dealer.setWinCount(dealerWins);
                    System.out.println("Player wins: " + player.getWinCount() + "  Dealer wins: " + dealer.getWinCount());
                    System.out.println("Do you want to play again?");
                    answer= keyboard.next().charAt(0);
                    player.resetHand();
                    dealer.resetHand();
                    deck.shuffle();
                }while(answer != 'n');
}
