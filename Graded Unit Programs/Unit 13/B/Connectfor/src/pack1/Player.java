package pack1;

public abstract class Player {
    String name;
    int color;

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    abstract int move(ConnectFourGame game);
}
