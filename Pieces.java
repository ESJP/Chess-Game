package chessGame;
/**
 * Write a description of class Chess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface  Pieces
{
   public String getName();
   public void setX(int ix);
   public void setY(int iy);
   public int getX();
   public int getY();
   public boolean isAbleToMove(int tox,int toy);
   public void move(int tox,int toy);
}
