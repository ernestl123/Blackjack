package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
        public Card(){
            face = 0;
            suit = "";
        }
        
        public Card(int face, String suit){
            
            this.face = face;
            this.suit = suit;
        }


	// modifiers
        public void setSuit(String suit){
            this.suit = suit;
        }
        
        public void setFace(int face){
            this.face = face;
        }
 

  	//accessors
        public int getFace(){
            return face;
        }
        
        public String getSuit(){
            return suit;
        }



  	public abstract int getValue();

	public boolean equals(Object obj)
	{
         return obj.toString().equals(this.toString());
	}

  	//toString
  	public String toString(){
            return FACES[face] + " of " + getSuit() + " | value = " + getValue(); 
        }
 }