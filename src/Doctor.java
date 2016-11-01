/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class Doctor {
    //instance variables
    private int row;
    private int col;
    
    //constructor
    public Doctor(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    //class methods
    public void move(int newRow, int newCol){        
        
        //if user clicks on a random spot on the board that isn't adjacent with the doctor
        if(newRow > row + 1
                || newCol > col + 1
                || newRow < row - 1
                || newCol < col - 1){
            this.row = (int) (0 + Math.random() * (11 - 0 + 1));
            this.col = (int) (0 + Math.random() * (11 - 0 + 1));
        }
        
        //if user clicks on spot that is adjacent to doctor
        if(newRow == row + 1){
            this.row = row + 1;
        }
        
        if(newCol == col + 1){
            this.col = col + 1;
        }
        
        if(newRow == row - 1){
            this.row = row - 1;
        }
        
        if(newCol == col - 1){
            this.row = row - 1;
        }
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
}
