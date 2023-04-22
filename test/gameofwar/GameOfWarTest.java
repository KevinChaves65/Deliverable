package gameofwar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Dylan
 */
public class GameOfWarTest {
    private Deck deck = new Deck();
    
    @Test
    public void testDeckSize() {
        assertEquals(52, deck.getDeckSize());
    }
    
    @Test
    public void testCheckWinnerGood() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Card card1 = new Card("Hearts", 13);
        Card card2 = new Card("Spades", 2);
        GameOfWar.setCard1(card1);
        GameOfWar.setCard2(card2);
        GameOfWar.setPlayer1(player1);
        GameOfWar.setPlayer2(player2);

        GameOfWar.checkWinner();
        assertFalse(GameOfWar.getPlayer1().getDeckSize() 
            < GameOfWar.getPlayer2().getDeckSize());
    }
    
    @Test
    public void testCheckWinnerWhenTie() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        GameOfWar.setCard1(new Card("Hearts", 10));
        GameOfWar.setCard2(new Card("Spades", 10));
        GameOfWar.setPlayer1(player1);
        GameOfWar.setPlayer2(player2);
        GameOfWar.checkWinner();
        assertEquals(GameOfWar.getCards().size(), 8);
    }
    
    @Test
    public void testCheckWinnerBoundry() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Card card1 = new Card("Hearts", 11);
        Card card2 = new Card("Spades", 10);
        GameOfWar.setCard1(card1);
        GameOfWar.setCard2(card2);
        GameOfWar.setPlayer1(player1);
        GameOfWar.setPlayer2(player2);
        GameOfWar.getPlayer1().addCardToDeck(card1);
        GameOfWar.getPlayer2().addCardToDeck(card2);
        GameOfWar.checkWinner();
        assertFalse(GameOfWar.getPlayer1().getDeckSize() 
            < GameOfWar.getPlayer2().getDeckSize());
    }
    
    @Test
    public void testCheckWinnerBad() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Card card1 = new Card("Hearts", 16);
        Card card2 = new Card("Spades", 1);
        GameOfWar.setCard1(card1);
        GameOfWar.setCard2(card2);
        GameOfWar.setPlayer1(player1);
        GameOfWar.setPlayer2(player2);
        GameOfWar.getPlayer1().addCardToDeck(card1);
        GameOfWar.getPlayer2().addCardToDeck(card2);
        GameOfWar.checkWinner();
        assertTrue(GameOfWar.getPlayer1().getDeckSize() 
            > GameOfWar.getPlayer2().getDeckSize());
    }
    
    @Test
    public void testEmptyDeck() {
        deck.shuffleCards();
        Card card1 = deck.drawCard();
        Card card2 = deck.dealCard();
        for (int i = 0; i < 50; i++) {
            deck.drawCard();
        }
        assertTrue(deck.isEmpty());
        assertNull(deck.drawCard());
        assertNull(deck.dealCard());
    }
    
    @Test
    public void testGameWinnerPlayer1(){
        GameOfWar.setPlayer1(new Player("Player 1"));
        GameOfWar.setPlayer2(new Player("Player 2"));
        GameOfWar.getPlayer1().addCardToDeck(new Card("Spades", 6));
        GameOfWar.getPlayer1().addCardToDeck(new Card("Spades", 2));
        GameOfWar.checkGameWinner();
        assertEquals(GameOfWar.getPlayer1() , GameOfWar.getWinner());
    }
    
    @Test
    public void testGameWinnerPlayer2(){
        GameOfWar.setPlayer1(new Player("Player 1"));
        GameOfWar.setPlayer2(new Player("Player 2"));
        GameOfWar.getPlayer2().addCardToDeck(new Card("Spades", 6));
        GameOfWar.getPlayer2().addCardToDeck(new Card("Spades", 2));
        GameOfWar.checkGameWinner();
        assertEquals(GameOfWar.getPlayer2() , GameOfWar.getWinner());
    }
    
    @Test
    public void testDeckShuffle() {
        Deck newDeck = new Deck();
        boolean shuffled = false;
        for (int i = 0; i < 10; i++) {
            newDeck.shuffleCards();
            if (!deck.equals(newDeck)) {
                shuffled = true;
                break;
            }
        }
        assertTrue(shuffled);
    }
    
    @Test
    public void testAddCardToDeck() {
        GameOfWar.setPlayer1(new Player());
        GameOfWar.getPlayer1().addCardToDeck(new Card("Hearts", 7));
        assertEquals(1, GameOfWar.getPlayer1().getDeckSize());
    }
    
    @Test 
    public void testCardValueGood() {
        Card card = new Card("Hearts", 3);
        for (int i = 3; i <= 13; i++) {
            card.setValue(i);
            assertEquals(i,card.getValue());
        }
    }
    
    @Test 
    public void testCardValueBoundry() {
        Card card = new Card("Hearts", 2);
        assertEquals(2,card.getValue());
        card.setValue(14);   
        assertEquals(14,card.getValue());
    }
    
    @Test 
    public void testCardValueBad() {
        Card card = new Card("Clubs", 17);
        assertTrue(card.getValue() < 2 || card.getValue() > 14);   
    }

    @Test
    public void testCardHearts() {
        Card card = new Card("Hearts", 14);
        assertEquals("Hearts", card.getSuit());
    }
    
    @Test
    public void testCardClubs() {
        Card card = new Card("Clubs", 14);
        assertEquals("Clubs", card.getSuit());
    }
    
    @Test
    public void testCardSpades() {
        Card card = new Card("Spades", 14);
        assertEquals("Spades", card.getSuit());
    }
    
    @Test
    public void testCardDiamonds() {
        Card card = new Card("Diamonds", 14);
        assertEquals("Diamonds", card.getSuit());
    } 
}
