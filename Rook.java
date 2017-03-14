/**
 * Write a description of class Chess_Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook //implements Pieces
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

    public Boolean isAbleToMove(int toX,int toY){
        boolean decideMove = false;
        String direction = checkDirection(toX,toY);
        if(checkStraightLine(toX,toY)) {
            if(direction.equals("left")) {
                decideMove = checkLeft(toX,toY);
            }
            else if(direction.equals("right")) {
                decideMove = checkRight(toX,toY);
            }
            else if(direction.equals("down")) {
                decideMove = checkDown(toX,toY);
            }
            else if(direction.equals("up")) {
                decideMove = checkUp(toX,toY);
            }
        }
        return decideMove;
    }

    private boolean checkStraightLine(int toX, int toY) {
        if(getX()==toX||getY()==toY) {
            return true;
        }
        else {
            return false;
        }
    }

    private String checkDirection(int toX, int toY) {
        if(getX()>toX&&getY()==toY) {
            return "left";
        }
        else if(getX()<tox&&getY()==toy) {
            return "right";
        }
        else if(getX()==tox&&getY()>toy) {
            return "down";
        }
        else if(getX()==tox&&getY()<toy) {
            return "up";
        }
    }

    private boolean checkLeft(int toX, int toY) {
        for(int i=toX;i<getX();i++) {
            if(Board.ba[i][toY].getName().equals("   ")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRight(int toX, int toY) {
        for(int i=getX();i<toX;i++) {
            if(Board.ba[i][toY].getName().equals("   ")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDown(int toX, int toY) {
        for(int i=toX;i<getX();i++) {
            if(Board.ba[toX][i].getName().equals("   ")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUp(int toX, int toY) {
        for(int i=getY();i<toy;i++) {
            if(Board.ba[tox][i].getName().equals("   ")) {
                decideMove=true;
            }
        }
    }

    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
