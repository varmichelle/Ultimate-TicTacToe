import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Player xPlayer = null;
		Player oPlayer = null;
		UltimateTicTacToeBoard board = new UltimateTicTacToeBoard();
		System.out.println("Choose the X piece player. Type 1 for human player and type 2 for a computer");
		int number = sc.nextInt();
		if (number == 1) {
			xPlayer = new HumanPlayer(board, new GamePiece("X"));
		} else if (number == 2) {
			System.out.println("Choose level of difficulty for the computer: (1) for easy and (2) for hard");
			int level = sc.nextInt();
			if (level == 1) {
				xPlayer = new EasyAI(board, new GamePiece("X"));
			} else {
				xPlayer = new HardAI(board, new GamePiece("X"));
			}
		}
		System.out.println("Choose the O piece player. Type 1 for human player and type 2 for a computer");
		int number2 = sc.nextInt();
		if (number2 == 1) {
			oPlayer = new HumanPlayer(board, new GamePiece("O"));
		} else if (number2 == 2) {
			System.out.println("Choose level of difficulty for the computer: (1) for easy and (2) for hard");
			int level1 = sc.nextInt();
			if (level1 == 1) {
				oPlayer = new EasyAI(board, new GamePiece("O"));
			} else {
				oPlayer = new HardAI(board, new GamePiece("O"));
			}
		}
		UltimateTTTGame game = new UltimateTTTGame(board, xPlayer, oPlayer);
		game.playGame();

	}

}