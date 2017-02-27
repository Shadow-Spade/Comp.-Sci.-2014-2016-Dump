class ConnectFourGame
{
	private int[][] board;
	private static final int EMPTY = 0;
	static final int RED = 1;
	static final int BLACK =2;
	static final int DRAW =3;
	static final int RED_WINS =4;
	static final int BLACK_WINS =5;
	static final int PLAYING =6;

	ConnectFourGame() {
		board = new int[6][7];
		for(int r=0; r<6;r++)
		{
			for(int c=0; c<7; c++)
			{
				board[r][c] = EMPTY;
			}
		}
	}
	
	boolean columnFull(int col) {
		return (col<0 || col>6 || board[0][col] != EMPTY);
	}
	
	int getSpot(int c, int r) {
		if(c<0 || r<0 || c>=board[0].length || r>=board.length)
			return -1;
		else
			return board[r][c];
	}

	boolean dropPiece(int c, int piece) {
		for(int r=5; r>=0; r--)
		{
			if(board[r][c] == EMPTY)
			{
				board[r][c] = piece;
				return true;
			}
		}

		return false;
	}

	int status() {
		// horizontal
		for(int r=0; r<6;r++)
		{
			for(int c=0; c<=3; c++)
			{

				if(board[r][c] == RED &&board[r][c+1] == RED
					&&board[r][c+2] == RED &&board[r][c+3] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r][c+1] == BLACK
					&&board[r][c+2] == BLACK &&board[r][c+3] == BLACK)
					return BLACK_WINS;
			}
		}

		// veritical
		for(int r=0; r<=2;r++)
		{
			for(int c=0; c<7; c++)
			{
				if(board[r][c] == RED &&board[r+1][c] == RED
					&&board[r+2][c] == RED &&board[r+3][c] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r+1][c] == BLACK
					&&board[r+2][c] == BLACK &&board[r+3][c] == BLACK)
					return BLACK_WINS;
			}
		}
		      //
		    //
		  //
		//
		for(int r=0; r<=2;r++)
		{
			for(int c=3; c<7; c++)
			{

				if(board[r][c] == RED &&board[r+1][c-1] == RED
					&&board[r+2][c-2] == RED &&board[r+3][c-3] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r+1][c-1] == BLACK
					&&board[r+2][c-2] == BLACK &&board[r+3][c-3] == BLACK)
					return BLACK_WINS;
			}
		}

		//
		 //
		  //
		   //
		for(int r=0; r<=2;r++)
		{
			for(int c=0; c<=3; c++)
			{

				if(board[r][c] == RED &&board[r+1][c+1] == RED
					&&board[r+2][c+2] == RED &&board[r+3][c+3] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r+1][c+1] == BLACK
					&&board[r+2][c+2] == BLACK &&board[r+3][c+3] == BLACK)
					return BLACK_WINS;
			}
		}

		// playing
		for(int r=0; r<6;r++)
		{
			for(int c=0; c<7; c++)
			{

				if(board[r][c] == EMPTY)
					return PLAYING;
			}
		}

		return DRAW;
	}

	public void drawBoard(){
		for(int r=0; r<6;r++) {
			System.out.print("|");
			for(int c=0; c<7; c++) {
				System.out.print(" ");
				if(board[r][c] == EMPTY)
					System.out.print(" ");
				else if(board[r][c] == RED)
					System.out.print("R");
				else
					System.out.print("B");
				System.out.print(" |");
			}
			System.out.print("\n");
		}
		System.out.print("-----------------------------\n");
	}
}