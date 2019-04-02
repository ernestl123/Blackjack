package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
                stackOfCards = new ArrayList<Card>();
		topCardIndex = NUMCARDS-1;
		//loop through suits
			//loop through faces
				//add in a new card
                for (int i = 0; i < NUMSUITS; i ++){
                    for (int j = 1; j <= NUMFACES; j++){
                        stackOfCards.add(new BlackJackCard(j, SUITS[i]));
                    }
                }
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
            Collections.shuffle(stackOfCards);
		//reset variables as needed
            topCardIndex = NUMCARDS;
	}

   //accessors
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
            if (topCardIndex < 0){
                return 0;
            }
		return topCardIndex;
	}

	public Card nextCard()
	{

            topCardIndex--;
            return stackOfCards.get(topCardIndex);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}