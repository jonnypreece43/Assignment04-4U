
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author preej0747
 */
public class MyArrayList {

    //to store things
    private int[] numbers;
    
    //number of things
    private int numThings;
    
    public MyArrayList(){
        
        //create a blank array with 10 spots
        this.numbers = new int[10];
        
        //number of things to 0
        this.numThings = 0;
    }
    
    //gets the size of the list
    //returns the size of the list
    public int size(){
        return this.numThings;
    }
    
    //returns if list is empty
    //true if empty
    public boolean isEmpty(){
        return this.numThings == 0;
    }
    
    //adds a new number to the list
    //num is the number to add to the list
    public void add(int num){
        
        //no room to add the number in
        if(this.numThings == this.numbers.length){
        
            //make a new array twice as big
            int[] temp = new int[this.numbers.length * 2];
            
            //copy the values over
            for(int i = 0; i < this.numThings; i++){
                temp[i] = this.numbers[i];
            }
       
            //make the numbers array point to temp array
            this.numbers = temp; 
            
            //insert new value
            this.numbers[this.numThings] = num;
            
            //increase the counter
            this.numThings++;
            
        }else{
            
            //put number in array
            this.numbers[this.numThings] = num;
            
            //increase the counter
            this.numThings++;
        }
    }
    
    //removes a number from the list
    //num is the number to remove
    public void remove(int num){
        
        //goes through array
        for(int i = 0; i < this.numThings; i++){
            
            //if the number is found
            if(this.numbers[i] == num){
                
                //shuffle down
                while(i < this.numThings - 1){
                    this.numbers[i] = this.numbers[i + 1];
                    i++;
                }
                
                //decrease counter
                this.numThings--;
                
                //stop searching
                break;
            }
        }
    }
    
    //gets an item from the list
    //i is the position in the list to get
    //returns the number at that position
    public int get(int i){
        if(i >= this.numThings){
            
            //throw an error if not
            throw new IndexOutOfBoundsException();
        }
        
        return this.numbers[i];
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        
        //add some numbers
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(5);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);
        System.out.println("hewe we go!!!");
        //remove some numbers
        list.remove(5);
        
        //print out the list
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        
        ArrayList < Integer > other = new Array<>();
        other.add(7);
    }
}
