package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
public class Dealer extends AbstractPlayer{	
	
	
	
	//instance variable - Deck 
        private Deck d;




	//constructors
    public Dealer(){
        super();
        d = new Deck();
        
    }




	//method to shuffle
    public void shuffle(){
        d.shuffle();
    }





	//method to deal a card

    public Card deal(){
        return d.nextCard();
    }



	//hit method goes here
    public boolean hit(){
        return getHandValue() == 21;
    }
    
}