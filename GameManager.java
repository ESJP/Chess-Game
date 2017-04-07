import java.util.*;
public class GameManager 
{

    Player blackPlayer;
    Player whitePlayer;
	boolean isBlack = false;
	boolean hasQuit;
	Scanner in = new Scanner(System.in);
	
	public static GameManager instance;
	
	Board board;
	
	public GameManager(){
		instance = this;
		board = new Board();
	}
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
        	blackPlayer = new Player(name1);
        	whitePlayer = new Player(name2);
        }else{
        	blackPlayer = new Player(name2);
        	whitePlayer = new Player(name1);
        }

        board.printBoard();
        
        System.out.println(blackPlayer.getName()+", you are the Black Player");
        System.out.println(whitePlayer.getName()+", you are the White Player\n");
        
        while(!hasQuit){
        	turn();
        }
        if(isBlack) System.out.println("White Player"+whitePlayer+"win the game");
        else System.out.println("Black Player"+blackPlayer+" win the game");
        System.out.println("Game Endend.");
	}
    
    private void turn() {
        try {
            String player;
            if(isBlack)
            	player = blackPlayer.getName();
            else 
            	player = whitePlayer.getName();
            
            if(!isBlack) 
            	System.out.print("White Player ");
            else 
            	System.out.print("Black Player ");
            
            System.out.println(player+",It's your Turn:");
			System.out.println("Please Enter your movement: <quit /goto /cast >");
			
	        String input = in.nextLine();
	        if(input.length()<4) return;
	        
	        switch (input.substring(0,4)) {
				case "quit":
					hasQuit = true;
					return;
				case "goto":
					move(input);
					return;
				case "cast":
					board.instance.takeCastingCheck();
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
                
                if(board.moveChess(moveSet[0], moveSet[1], moveSet[2], moveSet[3])){
                	isBlack = !isBlack;
                }else{
                    throw new wrongTurnException("Can't find the Piece you choose");
                }
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
    
    public Pieces dicidePromoteType(){
    	
    	while(true){
	    	System.out.println("Please enter the type you wanted to set.");
	    	String input = in.nextLine();
	    	String thisTurnPlayerName;
	    	if(isBlack) thisTurnPlayerName = "B";else thisTurnPlayerName = "A";
	    	switch (input) {
			case "queen":
				return new Queen(-1, -1, thisTurnPlayerName);
			case "knight":
				return new Knight(-1, -1, thisTurnPlayerName);
			case "rook":
				return new Rook(-1, -1, thisTurnPlayerName);
			case "bishop":
				return new Bishop(-1, -1, thisTurnPlayerName);
			case "pawn":
				return new Pawn(-1, -1, thisTurnPlayerName);
			default:
				System.out.println("invaid type. Please try again.");
				break;
			}
    	}
    }
    
    
}
