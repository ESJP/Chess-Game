
/**
 * Write a description of class Chess_Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight implements Pieces
{
    public String name ="Knight";
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
    public Knight(int ix,int iy){
        x = ix; y = iy;
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
