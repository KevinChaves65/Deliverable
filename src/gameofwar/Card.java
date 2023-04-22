package gameofwar;

/**
 * The card class
 */
public class Card {
    private String suit;
    private int value;
    private static final String[] VALUES = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    /**
     * Constructor
     * @param suit
     * @param value
     */
    public Card(String suit, int value){
        this.suit = suit;
        this.value = value;
    }

    /**
     * Gets the suit of the card
     * @return
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * Sets the value of the card
     * @param newValue
     */
    public void setValue(int newValue){
        this.value = newValue;
    }

    /**
     * Gets the value of the card
     * @return
     */
    public int getValue(){
        return this.value;
    }

    /**
     * To string method
     * @return value and suit of the card as a string
     */
    @Override 
    public String toString(){
        return value + " of " + suit;
    }

    /**
     * gets the values of the cards
     * @return
     */
    public static String[] getValues() {
        return VALUES;
    }
    
    
}
