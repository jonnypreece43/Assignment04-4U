/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class Dalek {
    //instance variables
    private int row;
    private int col;
    private boolean hasCrashed = false;
    
    //constructor
    public Dalek(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    //class methods
    public void advanceTowards(Doctor Doc){
        //variables indicate the doctors row and column
        int docRow = Doc.getRow();
        int docCol = Doc.getCol();
        
        //make loops to ensure the daleks move closer toward the doctor
        if(hasCrashed == false){
            if(docRow > this.row){
                this.row = this.row + 1;
            }
            if(docRow < this.row){
                this.row = this.row - 1;
            }
            if(docCol > this.col){
                this.col = this.col + 1;
            }
            if(docCol < this.col){
                this.col = this.col - 1;
            }
        }
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public boolean hasCrashed(Dalek d){
        if(row == d.row && col == d.col){
            hasCrashed = true;
        }
        return hasCrashed;
    }
    
    public void crash(){
        hasCrashed = true;
    }
}
