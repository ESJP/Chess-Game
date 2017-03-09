package chessGame;
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
    public Boolean isAbleToMove(int tox,int toy){
    	boolean decide = true;
    	/*String newLocation = "";
    	String nowLocation = "";
    	//String sideNow = "";
    	//String sideNew = "";
    	if(Math.abs(tox-x)<=1 && Math.abs(toy-y)<=1){
    	  if(Board.ba[tox-1][toy-1].getName()!="   "){
    		//newLocation=Board.ba[tox][toy].getName();
    		//nowLocation=Board.ba[x][y].getName();
    		if( nowLocation.substring(0,1)==newLocation.substring(0,1))decide = false;
    	}
    	}
    	else{
    		decide = false;
    	}
    	*/
    	return decide;
    	
    	}
       
    
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
