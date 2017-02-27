import java.util.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{	
    int x,y; 
    HashMap<String,Pieces> PlayerA = new HashMap<String,Pieces>();
    HashMap<String,Pieces> PlayerB = new HashMap<String,Pieces>();
    public static Pieces[][] ba = new Pieces[8][8];
    
    public Board(){
        PlayerA.put("Rook1",new Rook(1,1,"B"));
        PlayerA.put("Knight1",new Knight(2,1,"B"));
        PlayerA.put("Bishop1",new Bishop(3,1,"B"));
        PlayerA.put("Queen",new Queen(4,1,"B"));
        PlayerA.put("King",new King(5,1,"B"));
        PlayerA.put("Bishop2",new Bishop(6,1,"B"));
        PlayerA.put("Knight2",new Knight(7,1,"B"));
        PlayerA.put("Rook2",new Rook(8,1,"B"));
        
        PlayerA.put("Pawn1",new Pawn(1,2,"B"));
        PlayerA.put("Pawn2",new Pawn(2,2,"B"));
        PlayerA.put("Pawn3",new Pawn(3,2,"B"));
        PlayerA.put("Pawn4",new Pawn(4,2,"B"));
        PlayerA.put("Pawn5",new Pawn(5,2,"B"));
        PlayerA.put("Pawn6",new Pawn(6,2,"B"));
        PlayerA.put("Pawn7",new Pawn(7,2,"B"));
        PlayerA.put("Pawn8",new Pawn(8,2,"B"));

        PlayerB.put("Rook1",new Rook(1,8,"W"));
        PlayerB.put("Knight1",new Knight(2,8,"W"));
        PlayerB.put("Bishop1",new Bishop(3,8,"W"));
        PlayerB.put("Queen",new Queen(4,8,"W"));
        PlayerB.put("King",new King(5,8,"W"));
        PlayerB.put("Bishop2",new Bishop(6,8,"W"));
        PlayerB.put("Knight2",new Knight(7,8,"W"));
        PlayerB.put("Rook2",new Rook(8,8,"W"));
        
        PlayerB.put("Pawn1",new Pawn(1,7,"W"));
        PlayerB.put("Pawn2",new Pawn(2,7,"W"));
        PlayerB.put("Pawn3",new Pawn(3,7,"W"));
        PlayerB.put("Pawn4",new Pawn(4,7,"W"));
        PlayerB.put("Pawn5",new Pawn(5,7,"W"));
        PlayerB.put("Pawn6",new Pawn(6,7,"W"));
        PlayerB.put("Pawn7",new Pawn(7,7,"W"));
        PlayerB.put("Pawn8",new Pawn(8,7,"W"));
    }

    public Boolean moveChess(int ox,int oy,int tox,int toy,String player){
        HashMap<String,Pieces> setH;
        HashMap<String,Pieces> elseH;
        if(player.equals("Black")){
            setH = PlayerA;
            elseH = PlayerB;
        }else{
            setH = PlayerB;
            elseH = PlayerA;
        }
        Boolean have = false;
        Pieces theP = new King(-1,-1,"");
        for (String key : setH.keySet()) {  
            Pieces pi = setH.get(key);  
            if(pi.GetX()==ox&&pi.GetY()==oy) {
                have = true;
                theP = pi;
            }
            if(pi.GetX()==tox&&pi.GetY()==toy){
                return false;
                //如果要去的地方有自己的棋子
            }
        }
        //如果这个位置有己方的棋子
        if(have){
            for (String key : elseH.keySet()) {  
                Pieces pi = elseH.get(key);  
                if(pi.GetX()==tox&&pi.GetY()==toy) {
                    elseH.remove(key);
                    break;
                }//删除敌方的棋子
            }
            theP.SetX(tox);
            theP.SetY(toy);
            return true;

        }else{
            return false;
            //如果这个地方没有棋子
        }
    }

    private void refreshBoard(){
    	for (int i = 0; i < ba.length; i++) for (int j = 0; j < ba[i].length; j++) 
			ba[i][j] = new VoidPiece();
			
        for (String key : PlayerA.keySet()) {  
            Pieces pi = PlayerA.get(key);  
            ba[8-pi.GetY()][8-pi.GetX()] = pi;
        }
        for (String key : PlayerB.keySet()) {  
            Pieces pi = PlayerB.get(key);    
            ba[8-pi.GetY()][8-pi.GetX()] = pi;
        }
    }
    public void printBoard(){
        refreshBoard();
        //直接打印出目前板子上的棋子
    	for (int i = 0; i <=7; i++) {
    		System.out.print(8-i);
    		for (int j = 7; j >=0; j--) 
    			System.out.print("  ["+ba[i][j].GetName()+"] ");
    		System.out.println("\n");
    	}
    	System.out.println("     A       B       C       D       E       F       G       H\n\n");
        }

    }

