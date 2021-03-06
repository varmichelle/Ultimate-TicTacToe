import java.util.Random;

/**
 * Class AI extends Player superclass 
 * AI that makes random valid moves
 * @author yugreta3411, Michelle Li
 * @period 1
 * 
 */

public class AI extends Player {

	/**
	 * EasyAI constructor - Constructor that uses the super constructor to
	 * initialize the board and game piece
	 * 
	 * @param b - ultimate tic tac toe board
	 * @param p - the player's game piece
	 */
	public AI(UltimateTicTacToeBoard b, GamePiece p) {
		super(b, p);
	}

	/**
	 * Make a random valid move
	 * @param lastMove - integer array of outerR, outerC, innerR, innerC of previous move
	 * @return move - integer array of outerR, outerC, innerR, innerC of move
	 */
	public int[] makeAMove(int[] lastMove) {
		Random number = new Random();
		int outerR = 0, outerC = 0, innerR = 0, innerC = 0;
		if (lastMove[2] == -1 || lastMove[3] == -1) {
			do {
				outerR = number.nextInt(3);
				outerC = number.nextInt(3);
				innerR = number.nextInt(3);
				innerC = number.nextInt(3);
			} while (!checkValidity(board, outerR, outerC, innerR, innerC));
		} else {
			do {
				outerR = lastMove[2];
				outerC = lastMove[3];
				innerR = number.nextInt(3);
				innerC = number.nextInt(3);
			} while (!checkValidity(board, outerR, outerC, innerR, innerC));
		}
		board.setPieceAt(outerR, outerC, innerR, innerC, thisPlayersPiece);
		int[] move = {outerR, outerC, innerR, innerC};
		return move;
	}

}
