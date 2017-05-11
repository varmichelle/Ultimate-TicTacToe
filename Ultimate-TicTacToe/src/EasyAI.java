import java.util.*;
/**
 * 
 * @author yugreta3411
 * @period 1
 * 
 *         EasyAI class - Class that creates a EasyAI player object This player
 *         object makes a move (placing a game piece on the board) randomly with
 *         no strategy
 * 
 */

public class EasyAI extends Player {
	
	/**
	 * EasyAI constructor - Constructor that uses the super constructor
	 * to initialize the UltimateTicTacToeBoard the AI player will be playing on
	 * the AI player's game piece is also initialized
	 * @param b the UltimateTicTacToeBoard the player will be playing on
	 * @param p the player's game piece
	 */
	
	public EasyAI(UltimateTicTacToeBoard b, GamePiece p){
		super(b, p);
	}
	
	/**
	 * Method that has the computer make a random valid move
	 */
	public void makeAMove(){
		Random number=new Random();
		int outerR, outerC, innerR, innerC;
		do{
			outerR=number.nextInt(3)+1;
			outerC=number.nextInt(3)+1;
			innerR=number.nextInt(3)+1;
			innerC=number.nextInt(3)+1;
		}while(!checkValidity(board, outerR, outerC, innerR, innerC));
		board.setPieceAt(outerR, outerC, innerR, innerC, thisPlayersPiece);
	}
}
