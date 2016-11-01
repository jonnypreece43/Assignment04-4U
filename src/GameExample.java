
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class GameExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a game board
        Board board = new Board(12, 12);
        
        //put a coloured peg at row, col
        board.putPeg(Color.RED, 1, 5);
        board.putPeg(Color.YELLOW, 2, 6);
        
        //remove the peg at row, col
        board.removePeg(1, 5);
        
        //put a message on the board
        board.displayMessage("Please click the board");
        
        while(true){
        
            //get a click on the board
        Coordinate click = board.getClick();
        int row = click.getRow();
        int col = click.getCol();
        board.putPeg(Color.MAGENTA, row, col);
        }
        }
        
}
