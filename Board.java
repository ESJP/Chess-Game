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
    HashMap<String,Chess> PlayerA = new HashMap<String,Chess>();
    HashMap<String,Chess> PlayerB = new HashMap<String,Chess>();
    public Board(int ix, int iy){
        x = ix;y=iy;
        PlayerA.put("King",new Chess_King(5,1));
        PlayerA.put("Queen",new Chess_Queen(4,1));
        PlayerA.put("Knight",new Chess_Knight(2,1));
        PlayerA.put("Knight",new Chess_Knight(7,1));
        PlayerA.put("Bishop",new Chess_Bishop(3,1));
        PlayerA.put("Bishop",new Chess_Bishop(6,1));
        PlayerA.put("Rook",new Chess_Rook(1,1));
        PlayerA.put("Rook",new Chess_Rook(8,1));
        PlayerA.put("Pawn1",new Chess_Pawn(1,1));
        PlayerA.put("Pawn2",new Chess_Pawn(2,1));
        PlayerA.put("Pawn3",new Chess_Pawn(3,1));
        PlayerA.put("Pawn4",new Chess_Pawn(4,1));
        PlayerA.put("Pawn5",new Chess_Pawn(5,1));
        PlayerA.put("Pawn6",new Chess_Pawn(6,1));
        PlayerA.put("Pawn7",new Chess_Pawn(7,1));
        PlayerA.put("Pawn8",new Chess_Pawn(8,1));
        
        
        PlayerB.put("King",new Chess_King(5,8));
        PlayerB.put("Queen",new Chess_Queen(4,8));
        PlayerB.put("Knight",new Chess_Knight(2,8));
        PlayerB.put("Knight",new Chess_Knight(7,8));
        PlayerB.put("Bishop",new Chess_Bishop(3,8));
        PlayerB.put("Bishop",new Chess_Bishop(6,8));
        PlayerB.put("Rook",new Chess_Rook(1,8));
        PlayerB.put("Rook",new Chess_Rook(8,8));
        PlayerB.put("Pawn1",new Chess_Pawn(1,8));
        PlayerB.put("Pawn2",new Chess_Pawn(2,8));
        PlayerB.put("Pawn3",new Chess_Pawn(3,8));
        PlayerB.put("Pawn4",new Chess_Pawn(4,8));
        PlayerB.put("Pawn5",new Chess_Pawn(5,8));
        PlayerB.put("Pawn6",new Chess_Pawn(6,8));
        PlayerB.put("Pawn7",new Chess_Pawn(7,8));
        PlayerB.put("Pawn8",new Chess_Pawn(8,8));
    }
    
}
