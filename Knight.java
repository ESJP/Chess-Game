
/**
 * Write a description of class Chess_Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight implements Pieces
{
    private int x,y;
    public Knight(int ix,int iy){
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
