/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class Card {
    //constants
    //SUITS
    public static final int SPADE = 0;
    public static final int CLUB = 1;
    public static final int HEARTS = 2;
    public static final int DIAMONDS = 3;
    
    //RANKS
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    //instance variables
    private int suit;
    private int rank;
    private Colour colour;
    private boolean faceUp;
    
    /**
     * A constructor to create a new playing card
     * @param suit the suit of the playing card
     * @param rank the rank of the playing card
     * @param faceUp is the card face up
     */
    public Card(int suit, int rank, boolean faceUp){
        
        //initializing instance variables
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
        
        //determine card colour
        if(this.suit == Card.SPADE || this.suit == Card.CLUB){
            colour = Colour.BLACK;
        }else{
            colour = Colour.RED;
        }
    }
    
    /**
     * Returns the suit of the playing card
     * @return the suit of the playing card
     */
    public int getSuit(){
        return this.suit;
    } 
    
    /**
     * Returns the rank of the playing card
     * @return the rank of the playing card
     */
    public int getRank(){
        return this.rank;
    }
    
    /**
     * Returns if the card is face up or not
     * @return true if the playing card is face up
     */
    public boolean isFaceUp(){
        return this.faceUp;
    }
    
    /**
     * Returns the colour of the playing card
     * @return the colour of the card
     */
    public Colour getColour(){
        return this.colour;
    }
    
    /**
     * Compares the rank of 2 cards
     * @param c the card to compare rank with
     * @return 0 means the cards are equivalent, less than 0 card is less than c, greater than 0 card is bigger than c
     */
    public int compareTo(Card c){
        return this.rank - c.rank;
    }
    
    /**
     * Flips the card from face up to face down or vice-versa
     */
    public void flipCard(){
        
        //toggle
        faceUp = !faceUp;
    }
    
    /**
     * Pretty String version of the card
     * @return a String representation of the card
     */
    @Override
    public String toString(){
        String suit = "";
        if(this.suit == Card.SPADE){
            suit = "SPADE";
        }else if(this.suit == Card.CLUB){
            suit = "CLUB";
        }else if(this.suit == Card.HEARTS){
            suit = "HEARTS";
        }else{
            suit = "DIAMONDS";
        }
        return "Suit:" + suit + "Rank:" + this.rank + "FaceUp:" + this.faceUp;
    }
}
