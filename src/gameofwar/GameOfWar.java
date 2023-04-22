package gameofwar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main game application, starts the game
 */
public class GameOfWar {
    
    private static Player player1;
    private static Card card1 = new Card("Hearts", 5);
    private static Card card2 = new Card("Hearts", 5);;
    private static Player player2;
    private static ArrayList<Card> cards = new ArrayList<>();
    private static Player winner;
    
    /**
     * Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);
        
        //create 2 player objects (you and opponent)
        System.out.println("Player one name: ");
        player1 = new Player(scan.nextLine());
        System.out.println("Player two name: ");
        player2 = new Player(scan.nextLine());

        
        //give them each 26 cards of random suit and random value, if the card 
        //is already present in a players hand then generate a different one
        Deck deck = new Deck();
        deck.shuffleCards();
        while(!deck.isEmpty()){
            player1.addCardToDeck(deck.dealCard());
            player2.addCardToDeck(deck.dealCard());
        }

        

        //game loop until someone runs out of cards
        while(!player1.isDeckEmpty()&&!player2.isDeckEmpty()){

        //print number of cards in players deck and flip card when they press enter
        System.out.printf("%s has %d cards remaining. %s has %d cards remaining." 
            + " Press Enter to flip cards: \n", player1.getName(), 
            player1.getDeckSize(), player2.getName(), 
            player2.getDeckSize());
        scan.nextLine();

        //flip the top card from each players deck and print them to screen
        card1 = player1.flipCard(); 
        card2 = player2.flipCard();
        cards.add(card1);
        cards.add(card2);

        System.out.printf(
            "%s played %s of %s, %s played %s of %s.\n",
            player1.getName(), checkValue(card1.getValue()), card1.getSuit(),
            player2.getName(), checkValue(card2.getValue()), card2.getSuit());

        checkWinner(); //check for a winner
        
        }
        scan.close();
        checkGameWinner();
    }
    
    public static void checkGameWinner() {
        //Check whos deck is empty and display the win message
        if(player1.isDeckEmpty()){
            winner = player2;
            System.out.printf("%s ran out of cards, %s wins the game!\n",
                player1.getName(), player2.getName());    
        }
        else{
            winner = player1;
            System.out.printf("%s ran out of cards, %s wins the game!\n",
                player2.getName(), player1.getName());         
        }
    }
    
    /**
     * Checks the winner of the round based on the card values
     */
    public static void checkWinner() {

        //if player one has a higher card they win the round
        if (card1.getValue() > card2.getValue()) {
            System.out.printf("%s wins the round.\n",player1.getName());
            player1.addCardsToDeck(cards);
            cards.clear();
        } 
        
        //if player two has a higher card they win the round
        if (card1.getValue() < card2.getValue()) {
            System.out.printf("%s wins the round.\n", player2.getName());
            player2.addCardsToDeck(cards);
            cards.clear();
        } 
        
        //If the round is a tie (both players have same vlaue card)
        if (card1.getValue() == card2.getValue()) {

            System.out.println("Round was a tie both players have the same" 
                + " card value. Turn three cards and flip the fourth.");
          
            try {
                //each player flips three cards
                for (int i = 0; i < 3; i++) {
                    cards.add(player1.flipCard());
                    cards.add(player2.flipCard());
                }

                //flip another card to be played
                card1 = player1.flipCard();
                card2 = player2.flipCard();
                cards.add(card1);
                cards.add(card2);

                System.out.printf(
                "Your fourth card is %s of %s, your opponents is %s of %s.\n",
                checkValue(card1.getValue()), card1.getSuit(),
                checkValue(card2.getValue()), card2.getSuit());
                checkWinner();
            } catch(NullPointerException ex) {
                System.out.println("Not enough cards.");
            }
        }
    }

    /**
     * Checks the values of the card and returns its string value
     * @param value
     * @return
     */
    private static String checkValue(int value) {
       return Card.getValues()[value-2];
    }   

    public static Card getCard1() {
        return card1;
    }

    public static Card getCard2() {
        return card2;
    }

    public static void setCard1(Card card1) {
        GameOfWar.card1 = card1;
    }

    public static void setCard2(Card card2) {
        GameOfWar.card2 = card2;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player) {
        player1 = player;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player) {
        player2 = player;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        GameOfWar.cards = cards;
    }

    public static Player getWinner() {
        return winner;
    }
    
    
}
