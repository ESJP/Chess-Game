/**
 * Write a description of class Chess_Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook implements Pieces
{
    public String name;
    private String player;
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
        this.player = player;
        name = player+"Rk";
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isAbleToMove(int toX,int toY){
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
        decideMove = piecesCastingCheck(toX,toY);
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
            if(!checkVoid(toX,toY)) {
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
            if(!checkVoid(toX,toY)) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }

    private boolean checkUp(int toX, int toY) {
        int count=-1;
        for(int i=y;i<toY;i++) {
            if(!checkVoid(toX,toY)) {
                count+=1;
            }
        }
        if(count==0){return true;}
        else{return false;}
    }
    
   /* private boolean piecesCastingCheckPlace(int toX,int toY,boolean haveDown){
        boolean move = false;
        boolean hasDown = false;
        if(!hasDown){
            move = piecesCastingCheck(toX,toY);
        }
        return move;
    }*/
    
    private boolean checkVoid(int tox,int toy){
        if(checkVoid(tox,toy)){
            return true;
        }
        else return false;
    }
    
    private boolean piecesCastingCheck(int toX, int toY){
        boolean judgeControl = true;
        boolean judgeVoid = true;
        int checkPlayerRookY = 0;
        if(player.equals("B")){
            checkPlayerRookY = 1;
        }
        else{
            checkPlayerRookY = 8;
        }
        if(x < toX && y == 1){
            for(int i=toX;i>x;i--){
                if(judgeControl)judgeControl = piecesCastingControlPower(i,checkPlayerRookY);
                if(judgeVoid)judgeVoid = checkVoid(toX,checkPlayerRookY);
            }
        }
        else if(x > toX && y == 1){
            for(int i=toX;i<x;i++){
                if(judgeControl)judgeControl = piecesCastingControlPower(i,checkPlayerRookY);
                if(judgeVoid)judgeVoid = checkVoid(toX,checkPlayerRookY);
            }
        }
        else {
            judgeControl = false;
            judgeVoid = false;
        }
        return (judgeControl && judgeVoid);
    }
    
    private boolean piecesCastingControlPower(int toX,int checkPlayerRookY){
        boolean judge = true;
        for(int checkY=1;checkY<8;checkY++){
            for(int checkX=1;checkX<8;checkX++){
                if(getPiecesName(checkX,checkY).equals("BPn")){
                    Pawn Pn = new Pawn(checkX,checkY,player);
                    if(judge){
                        judge = Pn.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
                else if(getPiecesName(checkX,checkY).equals("BRk")){
                    Rook Rk = new Rook(checkX,checkY,player);
                    if(judge){
                        judge = Rk.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
                else if(getPiecesName(checkX,checkY).equals("BBp")){
                    Bishop Bp = new Bishop(checkX,checkY,player);
                    if(judge){
                        judge = Bp.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
                else if(getPiecesName(checkX,checkY).equals("BKt")){
                    Knight Kt = new Knight(checkX,checkY,player);
                    if(judge){
                        judge = Kt.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
                else if(getPiecesName(checkX,checkY).equals("BQn")){
                    Queen Qn = new Queen(checkX,checkY,player);
                    if(judge){
                        judge = Qn.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
                else if(getPiecesName(checkX,checkY).equals("BKg")){
                    King Kg = new King(checkX,checkY,player);
                    if(judge){
                        judge = Kg.isAbleToMove(toX,checkPlayerRookY);
                    }
                }
            }
        }
        return judge;
    }
    private String getPiecesName(int checkX,int checkY){
        return Board.instance.board[checkX-1][checkY-1].getName();
    }
    

    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}
