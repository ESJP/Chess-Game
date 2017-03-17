
/**
 * Write a description of class Chess_Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight implements Pieces
{
	
    public String name;
    public String player;
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
    public Knight(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Kt";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Boolean isAbleToMove(int tox,int toy){
    	if(isSqureShape(tox, toy)) return true;
    	
        return false;
    }
    private boolean isSqureShape(int tox,int toy){
    	if(Math.abs(tox-x)==2&&Math.abs(toy-y)==1) return true;
    	if(Math.abs(tox-x)==1&&Math.abs(toy-y)==2) return true;
    	return false;
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
