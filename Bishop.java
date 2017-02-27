
/**
 * Write a description of class Chess_Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop implements Pieces
{
    public String name ="Bishop";
    public int x,y;
    public String GetName(){
        return name;
    }
    public void SetX(int ix){
        x = ix;
    }
    public void SetY(int iy){
        y = iy;
    }
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
