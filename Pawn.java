
/**
 * Write a description of class Chess_Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn implements Pieces
{ 
    public String name;
    public int x,y;
    private boolean firstMove;
    private boolean justMove;
    
    public void newturn(){
    	justMove = false;
    }
    public String getName(){
        return name;
    }
    public void setX(int ix){
        if(ix == -1){
        	justMove = false;
        }else{
            x = ix;
        }
    }
    public void setY(int iy){
        y = iy;
    }
    
    public Pawn(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Pn";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Boolean isAbleToMove(int tox,int toy){
        return false;
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
    

    
}
