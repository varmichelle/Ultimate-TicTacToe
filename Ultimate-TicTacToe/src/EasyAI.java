import java.util.*;

/**
 * 
 * @author yugreta3411, Michelle Li
 * @period 1
 * 
 *         EasyAI class - Class that creates a EasyAI player object This player
 *         object makes a move (placing a game piece on the board) randomly with
 *         no strategy
 * 
 */

public class EasyAI extends Player {

	/**
	 * EasyAI constructor - Constructor that uses the super constructor to
	 * initialize the UltimateTicTacToeBoard the AI player will be playing on
	 * the AI player's game piece is also initialized
	 * 
	 * @param b
	 *            the UltimateTicTacToeBoard the player will be playing on
	 * @param p
	 *            the player's game piece
	 */

	public EasyAI(UltimateTicTacToeBoard b, GamePiece p) {
		super(b, p);
	}

	/**
	 * Method that has the computer make a random valid move
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