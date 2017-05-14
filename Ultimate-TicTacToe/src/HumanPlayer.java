import java.util.Scanner;

/**
 * 
 * @author Maya Mistry, Michelle Li
 * @period 1
 * 
 */

public class HumanPlayer extends Player {
	
	protected Scanner input;

	/**
	 * Constructor that passes through the UltimateTicTacToeBoard object and the
	 * GamePiece object to allow a human player to make a move on it.
	 * 
	 * @param b - board used to play the game
	 * @param p - game piece used (x or o)
	 */
	public HumanPlayer(UltimateTicTacToeBoard b, GamePiece p) {
		super(b, p);
	}

	/**
	 * Make a move from scanner input
	 * @param moveRestrictions - integer array of parameters of the previous move
	 * @return move - integer array of parameters of the move just made
	 */
	public int[] makeAMove(int[] moveRestrictions) {
		input = new Scanner(System.in);
		System.out.println(thisPlayersPiece.getXorO() + " player, enter the row number of the move you want to make: ");
		int r = input.nextInt();
		System.out.println(thisPlayersPiece.getXorO() + " player, enter the column number of the move you want to make: ");
		int c = input.nextInt();
		int outsideR = r/3;
		int outsideC = c/3;
		int insideR = r - outsideR * 3;
		int insideC = c - outsideC * 3;
		int[] move = {outsideR, outsideC, insideR, insideC};
		if (outOfBounds(move) || !checkValidity(board, outsideR, outsideC, insideR, insideC) || (moveRestrictions[2] != -1 && outsideR != moveRestrictions[2]) || (moveRestrictions[3] != -1 && outsideC != moveRestrictions[3])) {
			System.out.println("The move you selected was invalid.");
			makeAMove(moveRestrictions);
		} else {
			board.setPieceAt(outsideR, outsideC, insideR, insideC, thisPlayersPiece);
			return move;
		}
		return new int[4];
	}
	
	/**
	 * Check if the move is out of bounds
	 * @param move - parameters of the move (outer/inner row/col)
	 * @return whether the move is valid
	 */
	private boolean outOfBounds(int[] move) {
		for (int i = 0; i < 4; i++) {
			if (move[i] < 0 || move[i] > 2) return true;
		}
		return false;
	}
}
