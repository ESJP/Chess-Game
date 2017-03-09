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
        boolean rightUp = false;
        boolean leftUp = false;
        boolean rightDown = false;
        boolean leftDown = false;
        //Board.ba[3][4].GetName
        if(Math.abs(tox-x)==Math.abs(toy-y)){
            if(tox>x){
                if(toy>y){
                	rightUp = true;
                }
                else{
                    rightDown = true;
                }
            }
            else if(tox<x){
                if(toy>y){
                    leftUp = true;
                }
                else{
                    leftDown = true;
                }
            }
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
        }
        else{
            decide = false;
        }
        System.out.println(Board.ba[1][1].getName());
        //System.out.println("1");
        System.out.println(Board.ba[3][1].getName());
        return decide;
        }
    
    
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
    public boolean rightUp(int tox,int toy){
        boolean decideRightUp = false;
        int count = 0;
        int j = y;
        for(int i = x;i<tox;i++){
            j++;
            //System.out.println(Board.ba[4][2].getName());
                if(!Board.ba[i-1][j-1].getName().equals("   ")){
                	//System.out.println(Board.ba[i-1][j-1].getName());
                    //System.out.println("1");
                    count = count +1;
                }
            
        }
        if(count == 0){
        	decideRightUp = true;
        }
        return decideRightUp;
        
        }
    

    public boolean rightDown(int tox,int toy){
        boolean decideRightDown = false;
        int count = 0;
        int j = y;
        for(int i=x;i<tox;i++){
            j--;
                if(!Board.ba[i-1][j-1].getName().equals("   ")){
                	count ++;
                }
            
        }
        if(count == 0){
        	decideRightDown = true;
        }
        return decideRightDown;
    } 

    public boolean leftUp(int tox,int toy){
        boolean decideLeftUp = false;
        int count = 0;
        int j = y;
        for(int i=x;i>tox;i--){
            j++;
                if(!Board.ba[i-1][j-1].getName().equals("   ")){
                	count ++;
                }
            
        }
        if(count == 0){
        	decideLeftUp = true;
        }
        return decideLeftUp;
    }

    public boolean leftDown(int tox,int toy){
        boolean decideLeftDown = true;
        int count = 0;
        int j = y;
        for(int i=x;i>tox;i--){
            j--;
                if(!Board.ba[i-1][j-1].getName().equals("   ")){
                	count ++;
                }
            
        }
        if(count == 0){
        	decideLeftDown = true;
        }
        return decideLeftDown;
        
    }
}

