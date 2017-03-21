
/**
 * Write a description of class Chess_Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen implements Pieces
{
    public String name ;
    public int x,y;
	public String player;
    public String getName(){
        return name;
    }
    public void setX(int ix){
        x = ix;
    }
    public void setY(int iy){
        y = iy;
    }
    public Queen(int ix,int iy,String player){
        x = ix; y = iy;
		this.player = player;
        name = player+"Qn";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Boolean isAbleToMove(int tox,int toy){
		String player = name.substring(0,1);
		Bishop bp = new Bishop(x,y,player);
		Rook rk = new Rook(x,y,player);
		boolean moveLikeRook = rk.isAbleToMove(tox,toy);
		boolean moveLikeBishop = bp.isAbleToMove(tox,toy);
        return (moveLikeBishop || moveLikeRook);
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
