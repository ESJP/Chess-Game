
/**
 * Write a description of class Chess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface  Pieces
{
   public String GetName();
   public void SetX(int ix);
   public void SetY(int iy);
   public int GetX();
   public int GetY();
   public Boolean isAbleToMove(int tox,int toy);
   public void Move(int tox,int toy);
}
