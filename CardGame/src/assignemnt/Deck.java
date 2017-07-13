package assignemnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Deck {

	Map<Integer, Card> deck_of_cards = new HashMap<>(52);
	int deal_card_pos;

	public Deck(Map<Integer, Card> deck_cards) {
		// TODO Auto-generated constructor stub
		deck_of_cards = deck_cards;
	}

	void shuffle() {
		ArrayList<Card> temp = new ArrayList<>();
		for (Integer i : deck_of_cards.keySet()) {
			temp.add(deck_of_cards.get(i));
		}
		Collections.shuffle(temp);
		int i = 0;
		for (Card card : temp) {
			deck_of_cards.put(i, card);
			i++;
		}
		deal_card_pos = 0;
	}

	Card dealCard() {
		Card card = deck_of_cards.get(deal_card_pos);
		deal_card_pos++;
		return card;
	}

	int cardsLeft() {
		return deck_of_cards.size() - deal_card_pos;
	}

	void tosString() {
		for (int i = 0; i < deal_card_pos; i++) {
			System.out.print("dealt");
			System.out.print(deck_of_cards.get(i).toString() + " ");
		}
		for (int j = deal_card_pos; j < deck_of_cards.size(); j++) {
			System.out.print(deck_of_cards.get(j).toString() + " ");
		}
	}
}
