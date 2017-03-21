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
        if(x==toX||y==toY) {
            ////System.out.println("true");
            return true;
        }
        else {
            //System.out.println("false");
            return false;
        }
    }

    private String checkDirection(int toX, int toY) {
        if(x>toX&&y==toY) {
            //System.out.println("left");
            return "left";
        }
        else if(x<toX&&y==toY) {
            //System.out.println("right");
            return "right";
        }
        else if(x==toX&&y>toY) {
            //System.out.println("down");
            return "down";
        }
        else if(x==toX&&y<toY) {
            //System.out.println("up");
            return "up";
        }
        return "";
    }

    private boolean checkLeft(int toX, int toY) {
        int count=-1;
        for(int i=toX;i<x;i++) {
            if(!Board.instance.board[toX-1][i-1].getName().equals("   ")) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }

    private boolean checkRight(int toX, int toY) {
        int count=-1;
        for(int i=x;i<toX;i++) {
            if(!Board.instance.board[i-1][toY-1].getName().equals("   ")) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }

    private boolean checkDown(int toX, int toY) {
        int count=-1;
        for(int i=y;i>toY;i--) {
            if(!Board.instance.board[toX-1][i-1].getName().equals("   ")) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }

    private boolean checkUp(int toX, int toY) {
        int count=-1;
        for(int i=y;i<toY;i++) {
            if(!Board.instance.board[toX-1][i-1].getName().equals("   ")) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }

    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
