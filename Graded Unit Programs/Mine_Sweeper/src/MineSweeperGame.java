public class MineSweeperGame {
    public static final int PLAYING=0, WIN=1, LOSE=2, NOT_STARTED=3;
    private MineSweeperMap map;
    int numRows, numCols, numMines, numMarked, deadSeconds, state, seconds;
    long startTime;
    public MineSweeperGame(int numCols, int numRows, int numMines){
        this.numCols=numCols;
        this.numRows=numRows;
        this.numMines=numMines;
        numMarked=0;
        state=NOT_STARTED;
    }
    public int getSeconds(){
        if(state==PLAYING){return (int)((System.nanoTime()-startTime)/1000000000);}
        if(state==NOT_STARTED){return 0;}
        return deadSeconds;
    }
    public int getState() {return state;}
    public int getNumMarked() {return numMarked;}
    public int getNumMines() {return numMines;}
    public int getNumCols() {return numCols;}
    public int getNumRows() {return numRows;}
    public int getRegSeconds(){return seconds;}
    public MineSweeperMap getMap() {return map;}
    public void setNumMarked(int numMarked){this.numMarked=numMarked;}
    public void setState(int state){this.state=state;}
    public void reveal(int r, int c){
        if(c<0||r<0||c>=numCols||r>=numRows||map.getSquare(r,c).getState()==MineSweeperSquare.SHOWN){return;}
        map.getSquare(r,c).setState(MineSweeperSquare.SHOWN);
        if(map.getSquare(r,c).getMine()){
            state=LOSE;
            return;
        }
         /*
        * Positions
        *   1 0 7
        *   2 - 6
        *   3 4 5
        *
        *   '-' = grid[x][y]
        */
        else if(map.getSquare(r,c).getNumber()==0){
            reveal(r+1,c);
            reveal(r+1,c-1);
            reveal(r,c-1);
            reveal(r-1,c-1);
            reveal(r-1,c);
            reveal(r-1,c+1);
            reveal(r,c+1);
            reveal(r+1,c+1);
            return;
        }

    }
    public void makeGame(int r, int c){
        map=new MineSweeperMap(numCols,numRows,numMines,r,c);
        reveal(r,c);
        state=PLAYING;
        startTime=System.nanoTime();
    }
    public void check(){
        //TODO updates game if needed
        if(state==LOSE){
            for(int x=0; x<numRows; x++){
                for(int y=0; y<numCols; y++){
                    if(map.getSquare(x,y).getMine()){
                        map.getSquare(x,y).setState(MineSweeperSquare.SHOWN);
                    }
                }
            }
        }
        numMarked=0;
        boolean win = true;
        int numtrueflagged=0, numshown=0;
        if(state==PLAYING){
            for(int x=numRows-1; x>=0; x--){
                for(int y=numCols-1; y>=0; y--){
                    if(map.getSquare(x,y).getState()==MineSweeperSquare.FLAG){
                        numMarked++;
                    }
                    if(map.getSquare(x,y).getState()==MineSweeperSquare.FLAG&&map.getSquare(x,y).getMine()){
                        numtrueflagged++;
                    }
                    if(map.getSquare(x,y).getState()==MineSweeperSquare.UP&&!map.getSquare(x,y).getMine()){
                        win=false;
                    }
                    if(map.getSquare(x,y).getState()==MineSweeperSquare.SHOWN){
                        numshown++;
                    }
                }
            }
        }
        if(numshown+numMines==numCols*numRows){
            state=WIN;
            for(int x=numRows-1; x>=0; x--) {
                for (int y = numCols - 1; y >= 0; y--) {
                    if(map.getSquare(x,y).getMine()){
                        map.getSquare(x,y).setState(MineSweeperSquare.FLAG);
                    }
                }
            }
        }
        else if(numtrueflagged==numMines&&win){
            state=WIN;
        }
    }
}
