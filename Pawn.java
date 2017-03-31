package chessGame;

/**
 * Write a description of class Chess_Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn implements Pieces
{ 
    public String name;
    public int x,y;
    public int[] enPassantDone = {-1,-1};
    public boolean PnChange;
    public String getName(){
        return name;
    }
    public void setX(int ix){
        x = ix;
    }
    public void setY(int iy){
        y = iy;
    }
    public Pawn(int ix,int iy,String player){
        x = ix; y = iy;
        name = player+"Pn";
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isAbleToMove(int tox,int toy){
        boolean move = false;
        if(isBlackPawn(tox,toy))move = blackPawn(tox,toy);
        else if(isWhitePawn(tox,toy))move = whitePawn(tox,toy);
        if(toy == 8){
        	Board.instance.promote(tox, toy);
        }
        return move;
    }
    
    private boolean isBlackPawn(int tox,int toy){
       if(Board.instance.board[x-1][y-1].getName().equals("BPn")){
           return true;
       }
       else return false;
    }
    private boolean blackPawn(int tox,int toy){
        boolean judge = false;
        if(isBlackPawnNormalMove(tox,toy) || isBlackPawnEatPieces(tox,toy) || isBlackPawnFirstMove(tox,toy)){
            judge = true;
        }
        System.out.print(judge);
        return judge;
    }
    private boolean isBlackPawnNormalMove(int tox,int toy){
        if(isMoveDownOnePieces(tox,toy) && isVoid(tox,toy)){
            return true;
        }
        else return false;
    }
    private boolean isMoveDownOnePieces(int tox,int toy){
        if(tox == x && toy == y - 1){
            return true;
        }
        else return false;
    }
    private boolean isVoid(int tox, int toy){
        if(Board.instance.board[tox-1][toy-1].getName().equals("   ")){
            return true;
        }
        else return false;
    }
    private boolean isBlackPawnEatPieces(int tox,int toy){
        if(hasMoveToEatWhitePieces(tox,toy)){
            if(!(isVoid(tox,toy))){
                return true;
            }
            else{
                return isBlackPawnEnPassant(tox,toy);
            }
        }
        else return false;
    }
    private boolean hasMoveToEatWhitePieces(int tox,int toy){
        if((tox == x + 1 || tox == x - 1) && toy == y - 1){
            return true;
        }
        else return false;
    }
    private boolean isBlackPawnFirstMove(int tox,int toy){
        if(isBlackStartCoord(tox,toy) && isVoid(tox,toy))return true;
        else return false;
    }
    private boolean isBlackStartCoord(int tox,int toy){
        if(y == 7 && toy == 5 && tox == x){
            return true;
        }
        else return false;
    }
    private boolean isBlackPawnEnPassant(int tox,int toy){
        if(Board.instance.board[tox-1][toy].getName().substring(0,1).equals("W") && Board.instance.board[Board.instance.justMove[0]-1][Board.instance.justMove[1]-1].getName().equals("WPn")){
            Board.instance.removeAt(tox,toy+1);
            return true;
        }
        else return false;
    }
    
    private boolean isWhitePawn(int tox,int toy){
       if(Board.instance.board[x-1][y-1].getName().equals("WPn")){
           return true;
       }
       else return false;
    }
    private boolean whitePawn(int tox,int toy){
        boolean judge = false;
        if(isWhitePawnNormalMove(tox,toy) || isWhitePawnEatPieces(tox,toy) || isWhitePawnFirstMove(tox,toy)){
            judge = true;
        }
        return judge;
    }
    private boolean isWhitePawnNormalMove(int tox,int toy){
        if(isMoveUpOnePieces(tox,toy) && isVoid(tox,toy)){
            return true;
        }
        else return false;
    }
    private boolean isMoveUpOnePieces(int tox,int toy){
        if(tox == x && toy == y + 1){
            return true;
        }
        else return false;
    }
    private boolean isWhitePawnEatPieces(int tox,int toy){
        if (hasMoveToEatBlackPieces(tox,toy)){
            if(!(isVoid(tox,toy))){
                return true;
            }
            else return whitePawnEnPassant(tox,toy);
        }
        else return false;
    }
    private boolean hasMoveToEatBlackPieces(int tox,int toy){
        if((tox == x + 1 || tox == x - 1) && toy == y + 1){
            return true;
        }
        else return false;
    }
    private boolean isWhitePawnFirstMove(int tox,int toy){
        if(isWhiteStartCoord(tox,toy) && isVoid(tox,toy)){
            return true;
        }
        else return false;
    }
    private boolean isWhiteStartCoord(int tox,int toy){
        if(y == 2 && toy == 4 && tox == x){
            return true;
        }
        else return false;
    }
    private boolean whitePawnEnPassant(int tox,int toy){
        if(Board.instance.board[tox-1][toy-2].getName().substring(0,1).equals("B") && Board.instance.board[Board.instance.justMove[0]-1][Board.instance.justMove[1]-1].getName().equals("BPn")){
            Board.instance.removeAt(tox,toy-1);
            return true;
        }
        else return false;
    }
    
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
}