package assignemnt;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
	
	String symbol;
	int value;
	
	
	public Card(String symbol, int value) {
		super();
		this.symbol=symbol;
		this.value = value;
	}

	Integer getValue()
	{
		return null;
		
	}
	
	String getSuit()
	{
		return null;
	}
	
	public String toString(){
		String print ;
		print = value==0?"A":value==10?"J":value==11?"Q":value==12?"K":(value+1+"");
			
			return(print+symbol);
		
	}
	 void tosString()
	{
	String print ;
	print = value==1?"A":value==11?"J":value==12?"Q":value==13?"K":(value+"");
		
		System.out.println(print+symbol);
	}

}
