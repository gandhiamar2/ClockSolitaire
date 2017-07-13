package assignemnt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.SchemaOutputResolver;

public class ClockSolitaire {

	Card card_single;
	Deck deck;
	int input_print_type;
	Pile pile;
	String[] symbols = { "s", "h", "d", "c" };
	Map<Integer, Card> deck_of_cards = new HashMap<>(52);
	Map<Integer, Pile> pile_of_cards = new HashMap<>(13);
	ArrayList<Integer> scores;

	public static void main(String[] args) {
		String input_arg = "";
		ClockSolitaire g = new ClockSolitaire();
		int count_games = 4;
		if (args != null && args.length>=1) {
			input_arg = args[0];
			if (args.length == 2) {
				count_games = Integer.parseInt(args[1]);

			}
		}
		g.scores = new ArrayList<>();
		switch (input_arg) {
		case "verbose":
			g.input_print_type = 1;

			break;

		case "normal":
			g.input_print_type = 0;

			break;

		case "silent":
			g.input_print_type = -1;

			break;

		default:
			g.input_print_type = 0;

			break;
		}
		

		for (int i = 0; i < count_games; i++) {
			g.shuffle();
			g.pile_generator();
			g.play();
		}
		
		System.out.println("no.of games played is "+count_games);
		System.out.println("scores:");
		for (int i = 0; i < count_games; i++) {
			System.out.println("game "+i+" score: "+g.scores.get(i));
		}

	}

	Map<Integer, Card> deck_creation() {
		deck_of_cards = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				card_single = new Card(symbols[i], j);
				deck_of_cards.put(deck_of_cards.size(), card_single);
			}
		}

		return deck_of_cards;
	}

	void shuffle() {
		deck = new Deck(deck_creation());
		deck.shuffle();
	}

	void pile_generator() {
		pile_of_cards = new HashMap<>();
		for (int i = 0; i < 13; i++) {
			pile = new Pile();
			pile.addCardFaceDown(deck.dealCard());
			pile.addCardFaceDown(deck.dealCard());
			pile.addCardFaceDown(deck.dealCard());
			pile.addCardFaceDown(deck.dealCard());
			if (input_print_type != -1)
				System.out.println(pile.toString());
			pile_of_cards.put(pile_of_cards.size(), pile);

		}
		if(input_print_type!=-1)
		System.out.println("score at start: 13");
		System.out.println();
	}

	void play() {
		Card card = pile_of_cards.get(12).removeCard();
		play_up_setter(card);

	}

	void play_up_setter(Card card) {
		pile_of_cards.get(card.value).addCardFaceUp(card);
		;
		if (pile_of_cards.get(12).getNumberOfFaceUp() != 4) {
			if (input_print_type == 1) {
				for (int i = 0; i < pile_of_cards.size(); i++) {
					System.out.println(pile_of_cards.get(i).toString());
				}
				System.out.println();
			}
			play_up_setter(pile_of_cards.get(card.value).removeCard());
		} else {
			int score = 0;
			int tep = 0;
			System.out.println("game over");
			
			for (int i = 0; i < pile_of_cards.size(); i++) {
				if (pile_of_cards.get(i).getNumberOfFaceDown() > 0)
					score++;
				if(input_print_type!=-1)
				System.out.println(pile_of_cards.get(i).toString());
			}
//			for (int i = 0; i < 13; i++) {
//				if (pile_of_cards.get(i).getNumberOfFaceDown() > 0)
//					score++;
//				pile_of_cards.get(i).tosString();
//			}
			scores.add(score);
			if(input_print_type!=-1)
			System.out.println("score is " +((score>0)?score+" not win!":score+" it's a win"));
			System.out.println();
		}

	}

}
