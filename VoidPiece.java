
public class VoidPiece implements Pieces {
	
    public String name ="   ";
    public String GetName(){
        return name;
    }
    public void SetX(int ix){
        return;
    }
    public void SetY(int iy){
        return;
    }
    public int GetX(){
        return -1;
    }
    public int GetY(){
        return -1;
    }
    public Boolean isAbleToMove(int tox,int toy){
        return false;
    }
    public void Move(int tox,int toy){
    	return;
    }

}
