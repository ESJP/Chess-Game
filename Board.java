import java.util.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{	
    HashMap<String,Pieces> PlayerA = new HashMap<String,Pieces>();
    HashMap<String,Pieces> PlayerB = new HashMap<String,Pieces>();
    HashMap<String,Pieces> PlayerAT = new HashMap<String,Pieces>();
    HashMap<String,Pieces> PlayerBT = new HashMap<String,Pieces>();
    
    Set<String> Moved =new HashSet<String>();
    
    public Pieces[][] board = new Pieces[8][8];
    public int[] justMove = {-1,-1};
    
    public static Board instance;
    
    public Board(){
    	instance = this;
        PlayerA.put("Rook1",new Rook(1,8,"B"));
        PlayerA.put("Knight1",new Knight(2,8,"B"));
        PlayerA.put("Bishop1",new Bishop(3,8,"B"));
        PlayerA.put("Queen",new Queen(4,8,"B"));
        PlayerA.put("King",new King(5,8,"B"));
        PlayerA.put("Bishop2",new Bishop(6,8,"B"));
        PlayerA.put("Knight2",new Knight(7,8,"B"));
        PlayerA.put("Rook2",new Rook(8,8,"B"));
        
        PlayerA.put("Pawn1",new Pawn(1,7,"B"));
        PlayerA.put("Pawn2",new Pawn(2,7,"B"));
        PlayerA.put("Pawn3",new Pawn(3,7,"B"));
        PlayerA.put("Pawn4",new Pawn(4,7,"B"));
        PlayerA.put("Pawn5",new Pawn(5,7,"B"));
        PlayerA.put("Pawn6",new Pawn(6,7,"B"));
        PlayerA.put("Pawn7",new Pawn(7,7,"B"));
        PlayerA.put("Pawn8",new Pawn(8,7,"B"));

        PlayerB.put("Rook1",new Rook(1,1,"W"));
        PlayerB.put("Knight1",new Knight(2,1,"W"));
        PlayerB.put("Bishop1",new Bishop(3,1,"W"));
        PlayerB.put("Queen",new Queen(4,1,"W"));
        PlayerB.put("King",new King(5,1,"W"));
        PlayerB.put("Bishop2",new Bishop(6,1,"W"));
        PlayerB.put("Knight2",new Knight(7,1,"W"));
        PlayerB.put("Rook2",new Rook(8,1,"W"));
        
        PlayerB.put("Pawn1",new Pawn(1,2,"W"));
        PlayerB.put("Pawn2",new Pawn(2,2,"W"));
        PlayerB.put("Pawn3",new Pawn(3,2,"W"));
        PlayerB.put("Pawn4",new Pawn(4,2,"W"));
        PlayerB.put("Pawn5",new Pawn(5,2,"W"));
        PlayerB.put("Pawn6",new Pawn(6,2,"W"));
        PlayerB.put("Pawn7",new Pawn(7,2,"W"));
        PlayerB.put("Pawn8",new Pawn(8,2,"W"));
    }

    public Boolean moveChess(int ox,int oy,int tox,int toy) throws invalidMoveException{
        HashMap<String,Pieces> setH;
        HashMap<String,Pieces> elseH;
        if(GameManager.instance.isBlack){
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
            if(pi.getX()==ox&&pi.getY()==oy) {
                have = true;
                theP = pi;
                if(!theP.isAbleToMove(tox, toy)) return false;
            }
            if(pi.getX()==tox&&pi.getY()==toy) return false;
                //如果要去的地方有自己的棋子
        }
        //如果这个位置有己方的棋子
        if(have){
            for (String key : elseH.keySet()) {  
                Pieces pi = elseH.get(key);  
                if(pi.getX()==tox&&pi.getY()==toy) {
                    elseH.remove(key);
                    break;
                }//删除敌方的棋子
            }
            theP.setX(tox);
            theP.setY(toy);
            
            justMove[0]= tox;justMove[1]= toy;
            
            Moved.add(theP.getName());
            return true;

        }else{
            return false;
            //如果这个地方没有棋子
        }
    }

    private void refreshBoard(){
    	for (int i = 0; i < board.length; i++) for (int j = 0; j < board[i].length; j++) 
			board[i][j] = new VoidPiece();
			
    	
        for (String key : PlayerA.keySet()) {  
            Pieces pi = PlayerA.get(key);  
            board[pi.getX()-1][pi.getY()-1] = pi;
        }
        
        for (String key : PlayerB.keySet()) {  
            Pieces pi = PlayerB.get(key);    
            board[pi.getX()-1][pi.getY()-1] = pi;
        }
    }
    
    public void printBoard(){
        refreshBoard();
        System.out.println("______________________________________________________________________\n|                                                                    |");
    	for (int i = 7; i >=0; i--) {
    		System.out.println("|                                                                    |");
    		System.out.print("| "+(i+1));
    		
    		for (int j = 0; j <=7; j++) 
    			//System.out.print("  ["+j+i+","+board[j][i].getName()+","+board[j][i].getX()+board[j][i].getY()+"] ");
    			System.out.print("  ["+board[j][i].getName()+"] ");
    		
    		System.out.print("  | \n|                                                                    |\n");
    	}
    	System.out.println("|      A       B       C       D       E       F       G       H     |");
		System.out.println("|                                                                    |");
        System.out.println("|____________________________________________________________________|\n\n");
        
    }
    
    public void removeAt(int x,int y){
    	for (String key : PlayerA.keySet()) {
            Pieces pi = PlayerA.get(key);  
            if(pi.getX()==x&&pi.getY()==y){
            	PlayerA.remove(key);
            	return;
            }
        }
    	for (String key : PlayerB.keySet()) {
            Pieces pi = PlayerB.get(key);  
            if(pi.getX()==x&&pi.getY()==y){
            	PlayerB.remove(key);
            	return;
            }
        }
    }
    
    public void promote(int x,int y){

    	Pieces change = GameManager.instance.dicidePromoteType();
    	
    	for (String key : PlayerA.keySet()) {
            Pieces pi = PlayerA.get(key);  
            if(pi.getX()==x&&pi.getY()==y){
            	change.setX(pi.getX());change.setY(pi.getY());
            	PlayerA.remove(key);
            	PlayerA.put(key+"upto"+change.getName(), change);
            	return;
            }
        }
    	for (String key : PlayerB.keySet()) {
            Pieces pi = PlayerB.get(key);  
            if(pi.getX()==x&&pi.getY()==y){
            	change.setX(pi.getX());change.setY(pi.getY());
            	PlayerB.remove(key);
            	PlayerB.put(key+"upto"+change.getName(), change);
            	return;
            }
        }
    }

    public boolean check(){
    	if(GameManager.instance.isBlack)
    		return checkBySide(PlayerA,PlayerB);
	        
    	else
    		return checkBySide(PlayerB,PlayerA);
    }
    
    public Set<String> getHasMoved(){
		return Moved;
    }
    
    private boolean checkBySide(HashMap<String, Pieces> mapThis,HashMap<String, Pieces> mapOps){
    	int x = 0,y = 0;
		Pieces pieces = findPiece(mapThis, x, y, "King");

		x = pieces.getX();
		y = pieces.getY();
		
		for(String key : mapOps.keySet()){
			try {
				if(mapOps.get(key).isAbleToMove(x, y))
					return true;
			} catch (invalidMoveException e) {
				continue;
			}
		}
		return false;
    }
    public boolean checkWin(){
    	/*检测将死
    	将死的逻辑：
    		-移动任何棋子都无法取消
    	所以要遍历全部己方棋子，遍历其可以走的位置（isabletomove）？
    	然后用模拟的环境再判断有没有将死？*/
    	PlayerAT = new HashMap<>(PlayerA);
    	PlayerBT = new HashMap<>(PlayerB);
    	//先储存好起初的棋子位置，然后开始测试
    	
    	if(GameManager.instance.isBlack)
    		return checkWinBySide(PlayerA);
	        
    	else
    		return checkWinBySide(PlayerB);
    }

	private boolean checkWinBySide(HashMap<String, Pieces> playerA2) {
		for (String key : playerA2.keySet()) {
			int x=-1,y=-1;
			Pieces pieces = playerA2.get(key);
			x = pieces.getX();
			y = pieces.getY();
			//存储一开始的坐标值
			for (int i = 0; i < board.length; i++) 
				for (int j = 0; j < board[1].length; j++) {
					if(!findPiece(playerA2, i, j)){
						try {
							pieces.isAbleToMove(i, j);
						} catch (invalidMoveException e) {
							break;
						}
						pieces.setX(i);
						pieces.setY(j);
						refreshBoard();
					}
					if(check()) {
						pieces.setX(x);
						pieces.setY(y);
						refreshBoard();
						break;
					} else {
				    	PlayerA = new HashMap<>(PlayerAT);
				    	PlayerB = new HashMap<>(PlayerBT);
						return false;
					}
					//检测该位置，如果仍将军，换下一个位置
				}
				 
					
		}
		return true;
	}
	private boolean findPiece(HashMap<String, Pieces> List,int x,int y){
    	for (String key : List.keySet()) {
            Pieces pi = List.get(key);  
            if(pi.getX()==x&&pi.getY()==y) return true;
        }
    	return false;
	}
	private Pieces findPiece(HashMap<String, Pieces> List,int x,int y,String Name){
    	for (String key : List.keySet()) {
            if(key.equals(Name)) return List.get(key);
        }
    	return null;
	}
}

