package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;

public abstract class AbstractPlayer implements Playerable
{
   private ArrayList<Card> hand;
   private int winCount;

   //constructors
   public AbstractPlayer(){
       hand = new ArrayList<Card>();
       winCount = 0;
   }
   public  void addCardToHand( Card temp )
   {
       hand.add(temp);

   }

   public  void resetHand( )
   {
       hand = new ArrayList<Card>();

   }

   public  void setWinCount( int numwins )
   {
       winCount = numwins;

   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
		//great example of polymorphism
      int total=0;
      
      for (Card h: hand){
          total += h.getValue();
      }






      return total;
   }

   public abstract boolean hit();
   public String toString()
   {
      return "hand = " + hand.toString() + " \n-  # wins " + winCount;
   }
}