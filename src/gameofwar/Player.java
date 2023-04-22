package gameofwar;

import java.util.ArrayList;

/**
 * Player class
 */
public class Player {
    private String name;
    private ArrayList<Card> deck;

    public Player() {
        deck = new ArrayList<Card>();
    }

    /**
     * Constructor
     * @param name
     */
    public Player(String name){
        this.name = name;
        deck = new ArrayList<Card>();
    }

    /**
     * Adds a card to the players deck
     * @param card
     */
    public void addCardToDeck(Card card){
        deck.add(card);
    }

    /**
     * Checks if the players deck is empty
     * @return
     */
    public boolean isDeckEmpty(){
        return deck.isEmpty();
    }

    /**
     * Gets the amount of cards in the deck
     * @return deck size
     */
    public int getDeckSize(){
        return deck.size();
    }

    /**
     * Flips a card to play from the deck
     * @return card
     */
    public Card flipCard(){
        if(isDeckEmpty()){
            return null;
        }
        return deck.remove(0);
    }

    /**
     * Draws a card from the deck
     * @return
     */
    public Card drawCard(){
        if(isDeckEmpty()){
            return null;
        }
        return deck.remove(deck.size()-1);
    }

    /**
     * Adds a list of cards to the deckk
     * @param cards
     */
    public void addCardsToDeck(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public String getName() {
        return name;
    }
    
    
    
}
