
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
    public Boolean isAbleTomove(int tox,int toy){
        return false;
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
