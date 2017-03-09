import java.util.*;
public class GameManager 
{
	String blackName;
	String whiteName;
	boolean isBlack = false;
	boolean hasQuit = false;
	Scanner in = new Scanner(System.in);
	
	Board board = new Board();
	
	private void cleanScreen(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public void start(){
		System.out.println("Welcome to Chess game.");
		System.out.println("now Please enter your name.");
        System.out.print("your name here:");
        String name1 = in.nextLine();
        System.out.print("And, another name here:");
        String name2 = in.nextLine();
        if((int)(Math.random()*2)==1){
        	blackName = name1;
        	whiteName = name2;
        }else{
        	blackName = name2;
        	whiteName = name1;
        }

        board.printBoard();
        
        System.out.println(blackName+", you are the Black Player");
        System.out.println(whiteName+", you are the White Player\n");
        
        while(!hasQuit){
        	turn();
        }
        if(isBlack) System.out.println("White Player"+whiteName+"win the game");
        else System.out.println("Black Player"+blackName+"win the game");
        System.out.println("Game Endend.");
	}
    
    private void turn() {
        try {
            String player;
            if(isBlack)
            	player = blackName;
            else 
            	player = whiteName;
            
            
            if(!isBlack) 
            	System.out.print("White Player ");
            else 
            	System.out.print("Black Player ");
            
            System.out.println(player+",It's your Turn:");
			System.out.println("Please Enter your movement: <quit /goto >");
			
	        String input = in.nextLine();
	        if(input.length()<4) return;
	        
	        switch (input.substring(0,4)) {
				case "quit":
					hasQuit = true;
					return;
				case "goto":
					move(input);
					return;
				default:
					cleanScreen();
			    	board.printBoard();
					System.out.println("Please enter the correct command.(for example, goto A1,B4)");
					return;
			}
        } catch (Exception e) {
        	cleanScreen();
			System.out.println("Please enter the correct command.(for example, goto A1,B4) :P");
			System.err.println(e);
			return;
        }
             
    }
    private void move(String input) {
    	try {
    		if(!input.substring(4,5).equals(" ")) return;
    		input = input.substring(5);
    		
    		int[] moveSet = convert(input.toUpperCase());
    		
    		if (moveSet != null) {
    			String player;
    			
                if(isBlack) player = "Black";else player = "White";
                
                if(board.moveChess(moveSet[0], moveSet[1], moveSet[2], moveSet[3], player))
                	isBlack = !isBlack;
                board.printBoard();
                return;
			} else {
				System.out.println("A wrong Move.(Please change, for example ,goto A1,B4)");
                cleanScreen();
			    board.printBoard();
			    return;	
			}
		} catch (Exception e) {
    		System.out.println("A wrong Move.(Please change, for example ,goto A1,B4)");
		    board.printBoard();
    		System.err.println(e);
    		return;
		}
	}
    
    private int[] convert(String input){
    	try {
    		for(int i=0;i<input.length();i++) if(input.substring(i,i+1).equals(",")) {
                String ori=input.substring(0,i);
                String aft=input.substring(i+1);
                
            	int fromx = ((int)ori.charAt(0))-64;
            	int fromy = ((int)ori.charAt(1))-48;
            	int tox = ((int)aft.charAt(0))-64;
            	int toy = ((int)aft.charAt(1))-48;
            	
            	int[] temp = {fromx,fromy,tox,toy};
            	return temp;
    		}
    		return null;
		} catch (Exception e) {
			return null;
		}
    }
    
}
