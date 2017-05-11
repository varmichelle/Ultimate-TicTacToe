/**
 * UltimateTicTacToeBoard class-Class that creates a 3x3 tic tac toe board where each square is a tic tac toe board
 * The class contains methods to set and get a certain square on the board
 * @author yugreta3411
 * period 1
 */
public class UltimateTicTacToeBoard {

	private TicTacToeBoard[][] board;
	
	/**
	 * UltimateTicTacToeboard constructor-Constructor that initializes board to a 3x3 array of tic tac toe boards
	 */
	
	public UltimateTicTacToeBoard(){
		board=new TicTacToeBoard[3][3];
		for(int row=0; row<3; ++row){
			for(int col=0; col<3; ++col){
				board[row][col]=new TicTacToeBoard();
			}
		}
	}
	
	/**
	 * Method that gets the piece at a certain row and column of one of the tic tac toe boards
	 * @param rowBoard the row of the tic tac toe board
	 * @param columnBoard the column of the tic tac toe board
	 * @param rowIn the row of the square at the specified tic tac toe board
	 * @param columnIn the column of the square at the specified tic tac toe board
	 * @return the game piece at the specified square, null if there is no game piece object
	 */
	
	public GamePiece getPieceAt(int rowBoard, int columnBoard, int rowIn, int columnIn){
		return board[rowBoard][columnBoard].getPieceAt(rowIn, columnIn); 	
	}
	
	/**
	 * Method that sets the square at one of the tic tac toe boards to a certain game piece
	 * @param rowBoard the row of the tic tac toe board
	 * @param columnBoard the column of the tic tac toe board
	 * @param rowIn the row of the square at the specified tic tac toe board
	 * @param columnIn the column of the square at the specified tic tac toe board
	 * @param setTo the game piece the specified square will be set to
	 */
	
	public void setPieceAt(int rowBoard, int columnBoard, int rowIn, int columnIn, GamePiece setTo){
		board[rowBoard][columnBoard].setPieceAt(rowIn, columnIn, setTo);
	}
	
}
