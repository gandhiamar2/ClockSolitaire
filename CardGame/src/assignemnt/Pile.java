package assignemnt;

import java.util.ArrayList;

public class Pile {

	ArrayList<Card> piled_cards_up = new ArrayList<>(4);
	ArrayList<Card> piled_cards_down = new ArrayList<>(4);
	
	
	void addCardFaceDown(Card card)
	{
		piled_cards_down.add(card);
	}
	
	Card removeCard()
	{
		Card card =piled_cards_down.get(piled_cards_down.size()-1);
		piled_cards_down.remove(piled_cards_down.size()-1);
		return card;
	}
	
	int getNumberOfFaceDown()
	{
		return piled_cards_down.size();
	}
	
	void addCardFaceUp( Card card)
	{
		piled_cards_up.add(card);
	}
	
	int getNumberOfFaceUp()
	{
		return piled_cards_up.size();
	}
	
	void tosString()
	{
		System.out.print("down: ");
		for (Card card : piled_cards_down) {
			System.out.print(card.toString()+" ");
		}
		
		System.out.print("up:");
		for (Card card : piled_cards_up) {
			System.out.print(card.toString()+" ");
		}
		
		System.out.println();
	}

	@Override
	public String toString() {
		String temp = null;
		
		temp = "down: ";
		for (Card card : piled_cards_down) {
			temp = temp+card.toString()+" ";
			
		}
		
		temp = temp+ "up: ";
		for (Card card : piled_cards_up) {
			temp = temp + card.toString()+" ";
		
		}
		return temp;
	}
}
