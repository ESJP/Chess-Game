
/**
 * Write a description of class Chess_Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop implements Pieces
{
    private int x,y;
    public Bishop(int ix,int iy){
        x = ix; y = iy;
    }
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public Boolean isAbleToMove(int tox,int toy){
        return false;
    }
    public void Move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
