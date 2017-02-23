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
    public Board(int ix, int iy){
        x = ix;y=iy;
        PlayerA.put("King",new King(5,1));
        PlayerA.put("Queen",new Queen(4,1));
        PlayerA.put("Knight",new Knight(2,1));
        PlayerA.put("Knight",new Knight(7,1));
        PlayerA.put("Bishop",new Bishop(3,1));
        PlayerA.put("Bishop",new Bishop(6,1));
        PlayerA.put("Rook",new Rook(1,1));
        PlayerA.put("Rook",new Rook(8,1));
        PlayerA.put("Pawn1",new Pawn(1,1));
        PlayerA.put("Pawn2",new Pawn(2,1));
        PlayerA.put("Pawn3",new Pawn(3,1));
        PlayerA.put("Pawn4",new Pawn(4,1));
        PlayerA.put("Pawn5",new Pawn(5,1));
        PlayerA.put("Pawn6",new Pawn(6,1));
        PlayerA.put("Pawn7",new Pawn(7,1));
        PlayerA.put("Pawn8",new Pawn(8,1));
        
        
        PlayerB.put("King",new King(5,8));
        PlayerB.put("Queen",new Queen(4,8));
        PlayerB.put("Knight",new Knight(2,8));
        PlayerB.put("Knight",new Knight(7,8));
        PlayerB.put("Bishop",new Bishop(3,8));
        PlayerB.put("Bishop",new Bishop(6,8));
        PlayerB.put("Rook",new Rook(1,8));
        PlayerB.put("Rook",new Rook(8,8));
        PlayerB.put("Pawn1",new Pawn(1,8));
        PlayerB.put("Pawn2",new Pawn(2,8));
        PlayerB.put("Pawn3",new Pawn(3,8));
        PlayerB.put("Pawn4",new Pawn(4,8));
        PlayerB.put("Pawn5",new Pawn(5,8));
        PlayerB.put("Pawn6",new Pawn(6,8));
        PlayerB.put("Pawn7",new Pawn(7,8));
        PlayerB.put("Pawn8",new Pawn(8,8));
    }
    
}
