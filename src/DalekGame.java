
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author preej0747
 */
public class DalekGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //setup of the game

        //create game board
        Board board = new Board(12, 12);

        //create random number generators to ensure the doctors and daleks spawn in random spots
        int docCol = (int) (0 + Math.random() * (11 - 0 + 1));
        int docRow = (int) (0 + Math.random() * (11 - 0 + 1));
        int d1Row = (int) (0 + Math.random() * (11 - 0 + 1));
        int d1Col = (int) (0 + Math.random() * (11 - 0 + 1));
        int d2Row = (int) (0 + Math.random() * (11 - 0 + 1));
        int d2Col = (int) (0 + Math.random() * (11 - 0 + 1));
        int d3Row = (int) (0 + Math.random() * (11 - 0 + 1));
        int d3Col = (int) (0 + Math.random() * (11 - 0 + 1));

        //call up doctor and dalek methods

        //doctor
        Doctor doc = new Doctor(docRow, docCol);
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

        //daleks
        Dalek d1 = new Dalek(d1Row, d1Col);
        board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
        Dalek d2 = new Dalek(d2Row, d2Col);
        board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
        Dalek d3 = new Dalek(d3Row, d3Col);
        board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());

        //restart the game if daleks are on the same square as each other or if daleks are on the same square as the doctor

        //if doctors are on the same spot as daleks
        if (docCol == d1Col
                || docCol == d2Col
                || docCol == d3Col
                && docRow == d1Row
                || docRow == d2Row
                || docRow == d3Row) {
            board.removePeg(docRow, docCol);
            board.putPeg(Color.GREEN, docRow, docCol);
        }

        //if daleks are on the same spot as each other
        if (d1Col == d2Col
                || d1Col == d3Col
                || d2Col == d3Col
                && d1Row == d2Row
                || d1Row == d3Row
                || d2Row == d3Row) {
            board.removePeg(d1Row, d1Col);
            board.removePeg(d2Row, d2Col);
            board.removePeg(d3Row, d3Col);
            board.putPeg(Color.BLACK, d1Row, d1Col);
            board.putPeg(Color.BLACK, d2Row, d2Col);
            board.putPeg(Color.BLACK, d3Row, d3Col);
        }

        //game starts

        //if user wins or loses
        boolean win = false;

        while (win == false) {

            //if daleks crash
            if (d1.hasCrashed(d2) == true) {
                board.putPeg(Color.RED, d1.getRow(), d1.getCol());
            }

            if (d2.hasCrashed(d3) == true) {
                board.putPeg(Color.RED, d2.getRow(), d2.getCol());
            }

            if (d3.hasCrashed(d1) == true) {
                board.putPeg(Color.RED, d3.getRow(), d3.getCol());
            }

            //doctor and dalek take turns moving

            //get click
            Coordinate click = board.getClick();

            //doctor moves first
            board.removePeg(doc.getRow(), doc.getCol());
            doc.move(click.getRow(), click.getCol());
            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());

            //daleks move second

            //d1
            if (d1.hasCrashed(d2) == false
                    || d1.hasCrashed(d3) == false) {
                board.removePeg(d1.getRow(), d1.getCol());
                d1.advanceTowards(doc);
                board.putPeg(Color.BLACK, d1.getRow(), d1.getCol());
            } else {
                d1.crash();
            }

            //d2
            if (d2.hasCrashed(d1) == false
                    || d2.hasCrashed(d3) == false) {
                board.removePeg(d2.getRow(), d2.getCol());
                d2.advanceTowards(doc);
                board.putPeg(Color.BLACK, d2.getRow(), d2.getCol());
            } else {
                d2.crash();
            }

            //d3
            if (d3.hasCrashed(d1) == false
                    || d3.hasCrashed(d2) == false) {
                board.removePeg(d3.getRow(), d3.getCol());
                d3.advanceTowards(doc);
                board.putPeg(Color.BLACK, d3.getRow(), d3.getCol());
            } else {
                d3.crash();
            }

            //if all the daleks crash
            if (d1.hasCrashed(d2) == true
                    && d2.hasCrashed(d3) == true
                    && d3.hasCrashed(d1) == true) {
                win = true;
                board.displayMessage("YOU WIN!");
                break;
            }

            //if doctor gets captured
            if (doc.getRow() == d1.getRow()
                    && doc.getCol() == d1.getCol()
                    && doc.getRow() == d2.getRow()
                    && doc.getCol() == d2.getCol()
                    || doc.getRow() == d1.getRow()
                    && doc.getCol() == d1.getCol()
                    && doc.getRow() == d3.getRow()
                    && doc.getCol() == d3.getCol()
                    || doc.getCol() == d2.getCol()
                    && doc.getRow() == d2.getRow()
                    && doc.getRow() == d3.getRow()
                    && doc.getCol() == d3.getCol()) {
                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                win = false;
                board.displayMessage("You lose!");
                break;
            }
        }
    }
}
