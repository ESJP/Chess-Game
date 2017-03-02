/**
 * Write a description of class Chess_Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook implements Pieces
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
    public Rook(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Rk";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Boolean isAbleToMove(int tox,int toy){
        boolean decideMove = true;
        if(getX()>tox&&getY()==toy) {
            for(int i=getX();i<tox;i++) {
                if(Board.ba[i][toy].getName()!="   ") {
                    decideMove=false
                }
            }
        }
        else if(getX()<tox&&getY()==toy) {
            for(int i=tox;i<getX();i++) {
                if(Board.ba[i][toy].getName()!="   ") {
                    decideMove=false;
                }
            }
        }
        else if(getX()==tox&&getY()>toy) {
            for(int i=toy;i<getY();i++) {
                if(Board.ba[toX][i].getName()!="   ") {
                    decideMove=false;
                }
            }
        }
        else if(getX()==tox&&getY()<toy) {
            for(int i=getY();i<toy;i++) {
                if(Board.ba[toX][i].getName()!="   ") {
                    decideMove=false;
                }
            }
        }
        else {
            decideMove=false;
        }
        return decideMove;
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
