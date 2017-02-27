class WumpusPlayer {
    static final int NORTH=0,EAST=1,SOUTH=2,WEST=3;
    private int direction, colPosition, rowPosition;
    private boolean arrow, gold;
    WumpusPlayer() {
        direction=NORTH;
        arrow=true;
        gold=false;
    }
    void setDirection(int direction) {
        this.direction = direction;
    }
    void setColPosition(int colPosition) {
        this.colPosition = colPosition;
    }
    void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }
    void setArrow(boolean arrow) {
        this.arrow = arrow;
    }
    void setGold(boolean gold) {
        this.gold = gold;
    }
    int getDirection() {
        return direction;
    }
    int getColPosition() {
        return colPosition;
    }
    int getRowPosition() {
        return rowPosition;
    }
    boolean isArrow() {
        return arrow;
    }
    boolean isGold() {
        return gold;
    }
}
