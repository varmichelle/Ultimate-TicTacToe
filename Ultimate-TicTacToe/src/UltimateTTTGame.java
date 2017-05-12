/**
 * 
 * @author Adrienne Ly, Michelle Li
 * @period 1
 *
 */
/**
 * UltimateTTTGame class simulates the game of Ultimate TicTacToe.
 */
public class UltimateTTTGame {
	
	private UltimateTicTacToeBoard theBoard;
	private Player xPlayer;
	private Player oPlayer;

	/**
	 * Constructor to initialize board and two players
	 * 
	 * @param board
	 *            - an ultimate tictactoe board
	 * @param xP
	 *            - first player
	 * @param oP
	 *            - second player
	 */
	public UltimateTTTGame(UltimateTicTacToeBoard board, Player xP, Player oP) {
		theBoard = board;
		xPlayer = xP;
		oPlayer = oP;
	}

	/**
	 * playGame method simulates a round of the game
	 * 
	 */
	public void playGame() {
		int[] moveRestrictions = {-1,-1,-1,-1};
		System.out.println("Initial board: ");
		moveRestrictions = printBoard(moveRestrictions);
		while (!checkWinner(xPlayer) && !checkWinner(oPlayer)) {
			if (checkTie()) {
				System.out.println("It was a tie!");
				return;
			}
			moveRestrictions = facilitateMove(true, moveRestrictions);
			moveRestrictions = printBoard(moveRestrictions);
			if (!checkWinner(xPlayer) && !checkWinner(oPlayer)) {
				if (checkTie()) {
					System.out.println("It was a tie!");
					return;
				}
				moveRestrictions = facilitateMove(false, moveRestrictions);
				moveRestrictions = printBoard(moveRestrictions);
			}
		}

		if (checkWinner(xPlayer)) {
			System.out.println("Player X won!");
		} else if (checkWinner(oPlayer)) {
			System.out.println("Player O won!");
		}

	}

	private boolean checkTie() {
		for (int outerR = 0; outerR < 3; outerR++) {
			for (int outerC = 0; outerC < 3; outerC++) {
				for (int innerR = 0; innerR < 3; innerR++) {
					for (int innerC = 0; innerC < 3; innerC++) {
						if (theBoard.getTTTBoard(outerR, outerC).getPieceAt(innerR, innerC).getXorO() == "_") return false;
					}
				}
			}
		}
		return true;
	}

	public int[] facilitateMove(boolean x, int[] moveRestrictions) {
		String player = "";
		if (x) player = "X";
		else player = "O";
		if (moveRestrictions[2] != -1 && moveRestrictions[3] != -1 && !theBoard.getTTTBoard(moveRestrictions[2], moveRestrictions[3]).getWinner().equals("_")) {
			int[] moves = {-1,-1,-1,-1};
			moveRestrictions = moves;
		}
		System.out.println("Player " + player + ", make a move in the " + boardName(moveRestrictions));
		int[] previousMove = new int[4];
		if (x) previousMove = xPlayer.makeAMove(moveRestrictions);
		else previousMove = oPlayer.makeAMove(moveRestrictions);
		return previousMove;
	}
	
	public String boardName(int[] moveRestrictions) {
		String[] r = {"upper", "middle", "lower"};
		String[] c = {"left", "middle", "right"};
		if (moveRestrictions[2] == -1 || moveRestrictions[3] == -1) return "grid, in any board which hasn't been completely filled or won.";
		if (moveRestrictions[2] == 1 && moveRestrictions[3] == 1) {
			return "center board";
		} else {
			return r[moveRestrictions[2]] + " " + c[moveRestrictions[3]] + " board";
		}
	}

	/**
	 * checkWinner method checks if a player won the ultimate tictactoe game
	 * 
	 * @param p
	 *            - player who is being checked
	 * @return true if entered player won, false if entered player did not win
	 * 
	 */
	public boolean checkWinner(Player p) {
		// checking each row of big squares
		for (int rSquare = 0; rSquare < 3; rSquare++) {
			if ((checkWinnerSquare(p, rSquare, 0) && checkWinnerSquare(p, rSquare, 1)
					&& checkWinnerSquare(p, rSquare, 2))) {
				return true;
			}
		}
		// checking each column of big squares
		for (int cSquare = 0; cSquare < 3; cSquare++) {
			if ((checkWinnerSquare(p, 0, cSquare) && checkWinnerSquare(p, 1, cSquare)
					&& checkWinnerSquare(p, 2, cSquare))) {
				return true;
			}
		}

		// check diagonals of big squares
		if ((checkWinnerSquare(p, 0, 0) && checkWinnerSquare(p, 1, 1) && checkWinnerSquare(p, 2, 2))
				|| (checkWinnerSquare(p, 2, 0) && checkWinnerSquare(p, 1, 1) && checkWinnerSquare(p, 0, 2))) {
			return true;
		}

		return false;
	}

	/**
	 * checkWinnerSquare method checks if a player won an inner tictactoe square
	 * 
	 * @param p
	 *            - player who is being checked
	 * @param rStart
	 *            - row of large square
	 * @param cStart
	 *            - column of large square
	 * @return true if entered player won, false if entered player did not win
	 * 
	 */

	public boolean checkWinnerSquare(Player p, int rStart, int cStart) {

		// check each row of small square
		for (int rIn = 0; rIn < 3; rIn++) {
			if (theBoard.getPieceAt(rStart, cStart, rIn, 0).getXorO().equals(p.thisPlayersPiece.getXorO())
					&& theBoard.getPieceAt(rStart, cStart, rIn, 1).getXorO().equals(p.thisPlayersPiece.getXorO())
					&& theBoard.getPieceAt(rStart, cStart, rIn, 2).getXorO().equals(p.thisPlayersPiece.getXorO())) {
				return true;
			}

		}

		// check each column of small square
		for (int cIn = 0; cIn < 3; cIn++) {
			if (theBoard.getPieceAt(rStart, cStart, 0, cIn).getXorO().equals(p.thisPlayersPiece.getXorO())
					&& theBoard.getPieceAt(rStart, cStart, 1, cIn).getXorO().equals(p.thisPlayersPiece.getXorO())
					&& theBoard.getPieceAt(rStart, cStart, 2, cIn).getXorO().equals(p.thisPlayersPiece.getXorO())) {
				return true;
			}

		}

		// check diagonals of small square
		if ((theBoard.getPieceAt(rStart, cStart, 0, 0).getXorO().equals(p.thisPlayersPiece.getXorO())
				&& theBoard.getPieceAt(rStart, cStart, 1, 1).getXorO().equals(p.thisPlayersPiece.getXorO())
				&& theBoard.getPieceAt(rStart, cStart, 2, 2).getXorO().equals(p.thisPlayersPiece.getXorO()))
				|| (theBoard.getPieceAt(rStart, cStart, 2, 0).getXorO().equals(p.thisPlayersPiece.getXorO())
						&& theBoard.getPieceAt(rStart, cStart, 1, 1).getXorO().equals(p.thisPlayersPiece.getXorO())
						&& theBoard.getPieceAt(rStart, cStart, 0, 2).getXorO().equals(p.thisPlayersPiece.getXorO()))) {
			return true;
		}

		return false;
	}
	
	public int[] printBoard(int[] previousMove) {
		System.out.println("New board state: ");
		System.out.println(theBoard.toString());
		if (previousMove[0] == -1) return previousMove;
		if (checkWinnerSquare(xPlayer, previousMove[0], previousMove[1])) {
			System.out.println("X player won the " + boardName(previousMove) + "\n\n");
			theBoard.getTTTBoard(previousMove[0], previousMove[1]).setWinner("X");
			int[] moves = {-1,-1,-1,-1};
			return moves;
		} else if (checkWinnerSquare(oPlayer, previousMove[0], previousMove[1])) {
			System.out.println("O player won the " + boardName(previousMove) + "\n\n");
			theBoard.getTTTBoard(previousMove[0], previousMove[1]).setWinner("O");
			int[] moves = {-1,-1,-1,-1};
			return moves;
		} else if (boardFilled(previousMove[0], previousMove[1])) {
			System.out.println("The " + boardName(previousMove) + " has been filled.\n\n");
			theBoard.getTTTBoard(previousMove[0], previousMove[1]).setWinner("F");
			int[] moves = {-1,-1,-1,-1};
			return moves;
		}
		return previousMove;
	}
	
	private boolean boardFilled(int r, int c) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (theBoard.getTTTBoard(r, c).getPieceAt(i, j).getXorO().equals("_")) return false;
			}
		}
		return true;
	}

}