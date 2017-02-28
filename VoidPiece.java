
public class VoidPiece implements Pieces {
	
    public String name ="   ";
    public String getName(){
        return name;
    }
    public void setX(int ix){
        return;
    }
    public void setY(int iy){
        return;
    }
    public int getX(){
        return -1;
    }
    public int getY(){
        return -1;
    }
    public Boolean isAbleTomove(int tox,int toy){
        return false;
    }
    public void move(int tox,int toy){
    	return;
    }

}
