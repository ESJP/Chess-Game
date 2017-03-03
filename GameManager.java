import java.util.*;
public class GameManager 
{
	String blackName;
	String whiteName;
	boolean isBlack = false;
	boolean hasQuit = false;
	Scanner in = new Scanner(System.in);
	
	Board board = new Board();
	
	private void CleanScreen(){
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
        System.out.println("Game Endend.");
	}
    
    private void turn() {
        try {
            String player;
            if(isBlack)player = blackName;else player = whiteName;
            System.out.println(player+",It's your Turn:");
			System.out.println("Please Enter your movement: <quit /goto >");
	        String input = in.nextLine();
	        if(input.length()<5) return;
	        System.out.println(input.substring(0,4));
	        switch (input.substring(0,4)) {
				case "quit":
					hasQuit = true;
					return;
				case "goto":
					move(input);
					return;
				default:
					CleanScreen();
			    	board.printBoard();
					System.out.println("Please enter the correct command.(for example, goto A1,B4)");
					return;
			}
        } catch (Exception e) {
        	CleanScreen();
			System.out.println("Please enter the correct command.(for example, goto A1,B4) :P");
			System.err.println(e);
			return;
        }
             
    }
    private void move(String input) {
    	try {
    		input = input.substring(5);
    		for(int i=0;i<input.length();i++) if(input.substring(i,i+1).equals(",")) {
                String ori=input.substring(0,i);
                String aft=input.substring(i+1);
            	int fromx = ((int)ori.charAt(0))-64;
            	int fromy = ((int)ori.charAt(1))-48;
            	int tox = ((int)aft.charAt(0))-64;
            	int toy = ((int)aft.charAt(1))-48;
            	
            	String player;
            	
                if(isBlack) player = "Black";else player = "White";
                
                if(board.moveChess(fromx, fromy, tox, toy, player))
                	isBlack = !isBlack;
                else 
    				System.out.println("A wrong Move.(Please change, for example ,goto A1,B4)");
	                CleanScreen();
    			    board.printBoard();
                return;
            }
    		System.out.println("A wrong Move.(Please change, for example ,goto A1,B4)");
    		return;
		} catch (Exception e) {
    		System.out.println("A wrong Move.(Please change, for example ,goto A1,B4)");
    		System.err.println(e);
		}
	}
    
}
