package pack1;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name, int color) {
        super(name, color);

    }

    @Override
    public int move(ConnectFourGame game) {
        return (int) (Math.random() * 6);
    }
}
