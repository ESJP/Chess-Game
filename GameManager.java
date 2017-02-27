import java.util.*;
import java.math.*;
/**
 * Write a description of class Game_Mannger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager 
{
	static String BlackName;
	static String WhiteName;
	static boolean IsBlack = true;
	static boolean HasQuit = false;
	
	static Board board = new Board();
	
	public static void main(String[] args) {
		start();
	}
	private static void CleanScreen(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public static void start(){
		System.out.println("Welcome to Chess game.");
		System.out.println("now Please enter your name.");
        Scanner in = new Scanner(System.in);
        System.out.print("your name here£º");
        String name1 = in.nextLine();
        System.out.print("And, another name here£º");
        String name2 = in.nextLine();
        if((int)(Math.random()*2)==1){
        	BlackName = name1;
        	WhiteName = name2;
        }else{
        	BlackName = name2;
        	WhiteName = name1;
        }

        board.printBoard();
        
        System.out.println(BlackName+", you are the Black Player");
        System.out.println(WhiteName+", you are the White Player\n");
        
        while(!HasQuit){
        	trun();
        }
        System.out.println("Game Endend.");
	}
    Board ba = new Board();
    private static void trun() {
        try {
            String player;
            if(IsBlack)player = BlackName;else player = WhiteName;
            System.out.println(player+",It's your Turn:");
	    	 Scanner in = new Scanner(System.in);
			 System.out.println("Please Enter your movement: <quit./move.>");
	         String input = in.nextLine();
	         if(input.length()<5) return;
	         switch (input.substring(0,5)) {
				case "quit.":
					HasQuit = true;
					return;
				case "move.":
					input = input.substring(5);
					for(int i=0;i<input.length();i++) if(input.substring(i,i+1).equals(",")) {
			             String ori=input.substring(0,i);
			             String aft=input.substring(i+1);
			            	 int fromx = ((int)ori.charAt(0))-64;
			            	 int fromy = ((int)ori.charAt(1))-48;
			            	 int tox = ((int)aft.charAt(0))-64;
			            	 int toy = ((int)aft.charAt(1))-48;
			                 if(IsBlack)player = "Black";else player = "White";
		                     if(board.moveChess(fromx, fromy, tox, toy, player))
		                    	 IsBlack = !IsBlack;
		                     else 
		     					System.out.println("Please enter the correct command.(for example, move.A1,B4)");
		 			    	board.printBoard();
		                     return;
	                 }
			    	board.printBoard();
					System.out.println("Please enter the correct command.(for example, move.A1,B4)");
					return;
				default:
			    	board.printBoard();
					System.out.println("Please enter the correct command.(for example, move.A1,B4)");
					return;
			 }
        } catch (Exception e) {
       	 System.out.println("Please enter the correct command.(for example, move.A1,B4) :P");
       	 return;
        }
             
    }

}
