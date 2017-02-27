class WumpusSquare {
    private boolean deadWumpus,gold,stench,wumpus,breeze,pit,ladder,visited;
    WumpusSquare() {
        deadWumpus = false;
        gold = false;
        stench = false;
        wumpus = false;
        breeze = false;
        pit = false;
        ladder = false;
        visited = false;
    }
    //Getters
    boolean isDeadWumpus() {
        return deadWumpus;
    }
    boolean isGold() {
        return gold;
    }
    boolean isStench() {
        return stench;
    }
    boolean isWumpus() {
        return wumpus;
    }
    boolean isBreeze() {
        return breeze;
    }
    boolean isPit() {
        return pit;
    }
    boolean isLadder() {
        return ladder;
    }
    boolean isVisited() {
        return visited;
    }
    //Setters
    void setDeadWumpus(boolean deadWumpus) {
        this.deadWumpus = deadWumpus;
    }
    void setGold(boolean gold) {
        this.gold = gold;
    }
    void setStench(boolean stench) {
        this.stench = stench;
    }
    void setBreeze(boolean breeze) {
        this.breeze = breeze;
    }
    void setWumpus(boolean wumpus) {
        this.wumpus = wumpus;
    }
    void setPit(boolean pit) {
        this.pit = pit;
    }
    void setLadder(boolean ladder) {
        this.ladder = ladder;
    }
    void setVisited(boolean visited) {
        this.visited = visited;
    }
    //toString
    public String toString() {
        if(gold) {return "G";}
        else if (deadWumpus) {return "D";}
        else if(wumpus) {return "W";}
        else if(ladder) {return "L";}
        else if(pit) {return "P";}
        else {return "*";}
    }
}
