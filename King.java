package chessGame;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Write a description of class Chess_King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King implements Pieces
{
    public String name;
    public int x,y;
    public String getName(){
        return name;
        
    }
    public void setX(int ix){
        x = ix;
    }
    public void setY(int iy){
        y = iy;
    }
    public King(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Kg";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isAbleToMove(int tox,int toy){
    	boolean decide = false;
    	if(isWithinTheProperRange(tox,toy)){
    		if(Board.instance.board[tox-1][toy-1].getName().equals("   ")){
    			decide = true;
    		}
    		}
    	return decide;
    	}
       
    
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }public King() {
		// TODO Auto-generated constructor stub
	}
    
    public boolean isWithinTheProperRange(int tox,int toy){
    	boolean decide = false;
    	if(Math.abs(tox-x)<=1 && Math.abs(toy-y)<=1){
    		decide = true;
    	}
    	return decide;
    }
    }

