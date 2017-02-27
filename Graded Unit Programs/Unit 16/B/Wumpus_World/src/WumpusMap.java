class WumpusMap {

    private static final int NUM_ROWS=10, NUM_COLUMNS =10, NUM_PITS=10;
    private int ladderC, ladderR, temp=0;
    private WumpusSquare[][] grid = new WumpusSquare[NUM_COLUMNS][NUM_ROWS];
    WumpusMap() {
        createMap();
    }
    private void createMap() {
        for(int x=0;x<NUM_COLUMNS;x++) {
            for(int y=0; y<NUM_ROWS;y++) {
                grid[x][y]=new WumpusSquare();
            }
        }
        //Places Pits
        //Place Breeze
        while(temp<NUM_PITS) {
            int y= (int)(Math.random()*NUM_COLUMNS),x=(int)(Math.random()*NUM_ROWS);
            if(!grid[x][y].isPit()) {
                grid[x][y].setPit(true);
                //Evan helped me out with this
                if(x!=0) {grid[x-1][y].setBreeze(true);}
                if(x!=9) {grid[x+1][y].setBreeze(true);}
                if(y!=9) {grid[x][y+1].setBreeze(true);}
                if(y!=0) {grid[x][y-1].setBreeze(true);}
                temp++;
            }
        }
        temp=0;
        //Place Ladder & sets Col and Row of Ladder
        while(true) {
            int y= (int)(Math.random()*NUM_COLUMNS),x=(int)(Math.random()*NUM_ROWS);
            if(grid[x][y].isPit()) {continue;}
            if(!grid[x][y].isLadder()) {
                grid[x][y].setLadder(true);
                ladderC=x;
                ladderR=y;
            }
            break;
        }
        //Place Wumpus
        while(true)
        {
            int y= (int)(Math.random()*NUM_COLUMNS),x=(int)(Math.random()*NUM_ROWS);
            if(grid[x][y].isPit()||grid[x][y].isLadder()) {continue;}
            if(!grid[x][y].isWumpus()) {grid[x][y].setWumpus(true);}
            //Evan helped me out with this
            if(x!=0) {grid[x-1][y].setStench(true);}
            if(x!=9) {grid[x+1][y].setStench(true);}
            if(y!=9) {grid[x][y+1].setStench(true);}
            if(y!=0) {grid[x][y-1].setStench(true);}
            break;
        }
        //Place Gold
        while(true)
        {
            int y= (int)(Math.random()*NUM_COLUMNS),x=(int)(Math.random()*NUM_ROWS);
            if(grid[x][y].isLadder()||grid[x][y].isWumpus()||grid[x][y].isPit()) {continue;}
            if(!grid[x][y].isGold()) {
                grid[x][y].setGold(true);
            }
            break;
        }
    }
    int getLadderRow() {
        return ladderR;
    }
    int getLadderCol() {
        return ladderC;
    }
    WumpusSquare getSquare(int row, int col) {
        if(row>10||row<0||col>10||col<0) {return null;}
        return grid[col][row];
    }
    public String toString() {
        String g= "";
        for(int x=0; x<NUM_ROWS; x++) {
            for(int y=0; y<NUM_COLUMNS;y++) {
                if(grid[x][y].isPit()) {
                    g+="P";
                }
                else if(grid[x][y].isLadder()) {
                    g+="L";
                }
                else if(grid[x][y].isGold()) {
                    g+="G";
                }
                else if(grid[x][y].isWumpus()) {
                    g+="W";
                }
                else {
                    g+="*";
                }
            }
            g+="\n";
        }
        return g;
    }


}
