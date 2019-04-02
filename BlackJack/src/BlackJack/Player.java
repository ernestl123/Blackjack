package BlackJack;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;



//define Player class here 
public class Player extends AbstractPlayer
{
	//constructors
    public Player(){
        super();
    }

	//hit method goes here
    public boolean hit(){
       return getHandValue() == 21;
    }
    
}