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
    public Boolean isAbleTomove(int tox,int toy){
    	//Pieces[][] i = Board.ba;
        boolean decide = true;
        boolean RU = false;
        boolean LU = false;
        boolean RD = false;
        boolean LD = false;
        //Board.ba[3][4].GetName
        if(Math.abs(tox-x)==Math.abs(toy-y)){
            if(tox>x){
                if(toy>y){
                    RU = true;
                }
                else{
                    RD = true;
                }
            }
            else if(tox<x){
                if(toy>y){
                    LU = true;
                }
                else{
                    LD = true;
                }
            }
            if(RU){
                decide = RU(tox,toy);
            }
            else if(RD){
                decide = RD(tox,toy);
            }
            else if(LU){
                decide = LU(tox,toy);
            }
            else if(LD){
                decide = LD(tox,toy);
            }
        }
        else{
            decide = false;
        }
        return decide;
    }
    public void move(int tox,int toy){
        x = tox;
        y = toy;
    }
    public boolean RU(int tox,int toy){
        boolean decideRU = true;
        for(int i=x;i<tox;i++){
            for(int j=y;j<toy;j++){
                if(Board.ba[i][j].getName()!="   "){
                    decideRU = false;
                }
            }
        }
        return decideRU;
    }

    public boolean RD(int tox,int toy){
        boolean decideRD = true;
        for(int i=x;i<tox;i++){
            for(int j=y;j>toy;j--){
                if(Board.ba[i][j].getName()!="   "){
                    decideRD = false;
                }
            }
        }
        return decideRD;
    } 

    public boolean LU(int tox,int toy){
        boolean decideLU = true;
        for(int i=x;i>tox;i--){
            for(int j=y;j<toy;j++){
                if(Board.ba[i][j].getName()!="   "){
                    decideLU = false;
                }
            }
        }
        return decideLU;
    }

    public boolean LD(int tox,int toy){
        boolean decideLD = true;
        for(int i=x;i>tox;i--){
            for(int j=y;j>toy;j--){
                if(Board.ba[i][j].getName()!="   "){
                    decideLD = false;
                }
            }
        }
        return decideLD;
    }
}
