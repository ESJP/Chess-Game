
/**
 * Write a description of class Chess_Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop implements Pieces
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
    public Bishop(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Bp";
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
