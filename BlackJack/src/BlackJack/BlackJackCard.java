package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  	//constructors
        public BlackJackCard(){
            super();
        }
        
        public BlackJackCard(int face, String suit){
            super(face, suit);
        }

  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
            if (FACES[getFace()].equals("ACE")){
                return 11;
            }
            else if (getFace() >= 10){
                return 10;
            }
            else{
                return getFace();
            }

  	}
  	
 }