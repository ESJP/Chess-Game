package chessGame;
/**
 * Write a description of class Chess_Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop implements Pieces
{
	public String name;
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
	public Bishop(int ix,int iy,String player){
		x = ix; y = iy;
		name = player+"Bp";
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public Boolean isAbleToMove(int tox,int toy){
		//Pieces[][] i = Board.ba;
		boolean decide = false;
		decide = checkDirectionAndCheckPathAvailability(tox,toy);
		return decide;
	}


	public void move(int tox,int toy){
		x = tox;
		y = toy;
	}
	public boolean rightUp(int tox,int toy){
		boolean decideRightUp = false;
		int count = -1;
		int j = y;
		for(int i = x;i<tox;i++){
			// j++;
			//System.out.println(Board.board[4][2].getName());
			if(!Board.board[i-1][j-1].getName().equals("   ")){
				//System.out.println(Board.board[i-1][j-1].getName());
				//System.out.println("1");
				count ++;
			}
			j++;
		}
		if(count == 0){
			decideRightUp = true;
		}
		System.out.println(count);
		return decideRightUp;

	}


	public boolean rightDown(int tox,int toy){
		boolean decideRightDown = false;
		int count = -1;
		int j = y;
		for(int i=x;i<tox;i++){

			if(!Board.board[i-1][j-1].getName().equals("   ")){
				count ++;
			}
			j--;
		}
		if(count == 0){
			decideRightDown = true;
		}
		return decideRightDown;
	} 

	public boolean leftUp(int tox,int toy){
		boolean decideLeftUp = false;
		int count = -1;
		int j = y;
		System.out.println(tox);
		System.out.println(toy);
		System.out.println(x);
		System.out.println(y);
		for(int i=x;i>=tox;i--){
			//j++;
			if(!Board.board[i-1][j-1].getName().equals("   ")){
				count ++;
				System.out.println(Board.board[i-1][j-1].getName());
				//System.out.println(Board.board[tox][toy].getName());

			}
			j++;

		}
		//System.out.println("1");
		if(count == 0){
			decideLeftUp = true;
		}
		System.out.println("workbelow");
		System.out.println(count);
		return decideLeftUp;
	}

	public boolean leftDown(int tox,int toy){
		boolean decideLeftDown = true;
		int count = -1;
		int j = y;
		for(int i=x;i>tox;i--){

			if(!Board.board[i-1][j-1].getName().equals("   ")){
				count ++;
			}
			j--;
		}
		if(count == 0){
			decideLeftDown = true;
		}
		return decideLeftDown;

	}
	
	public boolean isPathAvailable(boolean rightUp, boolean rightDown, boolean leftUp, boolean leftDown, int tox,int toy){
		boolean decide = false;
		if(rightUp){
			decide = rightUp(tox,toy);
		}
		else if(rightDown){
			decide = rightDown(tox,toy);
		}
		else if(leftUp){
			decide = leftUp(tox,toy);
		}
		else if(leftDown){
			decide = leftDown(tox,toy);
		}
		return decide;
	}
	
	public boolean checkDirectionAndCheckPathAvailability(int tox,int toy){
		boolean decide = false;
		boolean rightUp = false;
		boolean leftUp = false;
		boolean rightDown = false;
		boolean leftDown = false;
		
		
		
		if( isDiagonal(tox,toy) ){
			if(tox>x){
				if(toy>y){
					rightUp = true;
					//decide = transfer(rightUp,rightDown,leftUp,leftDown,tox,toy);
				}
				else{
					rightDown = true;
					//decide = transfer(rightUp,rightDown,leftUp,leftDown,tox,toy);
				}
			}
			else if(tox<x){
				if(toy>y){
					leftUp = true;
					//decide = transfer(rightUp,rightDown,leftUp,leftDown,tox,toy);
				}
				else{
					leftDown = true;
					//decide = transfer(rightUp,rightDown,leftUp,leftDown,tox,toy);
				}
			}
			decide = isPathAvailable(rightUp,rightDown,leftUp,leftDown,tox,toy);
		}
		else{
			decide = false;
		}
		return decide;
	}
	
	
	private boolean isDiagonal(int tox,int toy) {
		return Math.abs(tox-x)==Math.abs(toy-y);
	}
	
	
}



