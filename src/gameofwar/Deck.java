package gameofwar;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck class
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Constructor
     */
    public Deck(){
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        cards = new ArrayList<Card>();
        for(String suit:suits){
            for(int value:values){
                cards.add(new Card(suit, value));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getDeckSize() {
        return cards.size();
    }
    
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Shuffles the deck
     */
    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    /**
     * checks if the cards list is empty
     * @return
     */
    public boolean isEmpty(){
        return cards.isEmpty();
    }

    /**
     * Draws a card from a deck
     * @return Card
     */
    public Card drawCard(){
        if(isEmpty()){
            return null;
        }
        return cards.remove(0);
    }

    /**
     * Deals a card from the deck
     * @return
     */
    public Card dealCard(){
        if(isEmpty()){
            return null;
        }
        return cards.remove(cards.size()-1);
    } 
}
