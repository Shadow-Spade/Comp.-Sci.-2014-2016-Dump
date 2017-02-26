package pack1;

public class ConnectFourGame {
    public static final int PLAYING = 0, RED_WINS = 1, BLACK_WINS = 2, DRAW = 3, RED = 4, BLACK = 5, EMPTY = 6;
    private int board[][];

    public ConnectFourGame() {
        board = new int[6][7];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = ConnectFourGame.EMPTY;
            }
        }
    }

    public boolean dropPiece(int column, int player) {
        for (int x = 5; x >= 0; x--) {
            if (board[x][column] == ConnectFourGame.EMPTY) {
                board[x][column] = player;
                return true;
            }
        }
        return false;
    }

    public int status() {
        //Horizontal check
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length - 3; y++) {
                if (board[x][y] == RED && board[x][y + 1] == RED && board[x][y + 2] == RED && board[x][y + 3] == RED) {
                    return RED_WINS;
                } else if (board[x][y] == BLACK && board[x][y + 1] == BLACK && board[x][y + 2] == BLACK && board[x][y + 3] == BLACK) {
                    return BLACK_WINS;
                }
            }
        }
        //Vertical check
        for (int x = 0; x < board[0].length; x++) {
            for (int y = 0; y < board.length - 3; y++) {
                if (board[y][x] == RED && board[y + 1][x] == RED && board[y + 2][x] == RED && board[y + 3][x] == RED) {
                    return RED_WINS;
                } else if (board[y][x] == BLACK && board[y + 1][x] == BLACK && board[y + 2][x] == BLACK && board[y + 3][x] == BLACK) {
                    return BLACK_WINS;
                }
            }
        }
        //Diagonal TL t BR check
        for (int x = 0; x < board.length - 3; x++) {
            for (int y = 0; y < board[0].length - 3; y++) {
                if (board[x][y] == RED && board[x + 1][y + 1] == RED && board[x + 2][y + 2] == RED && board[x + 3][y + 3] == RED) {
                    return RED_WINS;
                } else if (board[x][y] == BLACK && board[x + 1][y + 2] == BLACK && board[x + 2][y + 2] == BLACK && board[x + 3][y + 3] == BLACK) {
                    return BLACK_WINS;
                }
            }
        }
        //Diagonal BL t TR check
        for (int x = 0; x < board.length - 3; x++) {
            for (int y = 0; y < board[0].length - 3; y++) {
                if (board[x + 3][y] == RED && board[x + 2][y + 1] == RED && board[x + 1][y + 2] == RED && board[x][y + 3] == RED) {
                    return RED_WINS;
                } else if (board[x + 3][y] == BLACK && board[x + 2][y + 1] == BLACK && board[x + 1][y + 2] == BLACK && board[x][y + 3] == BLACK) {
                    return BLACK_WINS;
                }
            }
        }
        //Playing check
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == EMPTY) {
                    return PLAYING;
                }
            }
        }
        return DRAW;
    }

    public boolean columnFull(int column) {
        for (int x = 5; x >= 0; x--) {
            if (board[x][column] == RED || board[x][column] == BLACK) {
                continue;
            }
            if (board[x][column] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void draw() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == EMPTY) {
                    System.out.print("| ");
                } else if (board[x][y] == RED) {
                    System.out.print("|R");
                } else if (board[x][y] == BLACK) {
                    System.out.print("|B");
                }
                if (y == 6) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        System.out.println("---------------");
    }

    @Deprecated
    public int getSpot(int row, int col) {
        if ((row >= 0 && row <= 6) && (col >= 0 && col <= 7)) {
            return board[row][col];
        }
        return -1;
    }
}
