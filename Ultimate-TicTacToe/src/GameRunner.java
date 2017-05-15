/**
 * Class GameRunner - driver program to run the game
 * @author Adrienne Ly, Michelle Li, Somya Bhatia
 * Period 1
 */

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
			xPlayer = new AI(board, new GamePiece("X"));
		}
		System.out.println("Choose the O piece player. Type 1 for human player and type 2 for a computer");
		int number2 = sc.nextInt();
		if (number2 == 1) {
			oPlayer = new HumanPlayer(board, new GamePiece("O"));
		} else if (number2 == 2) {
			oPlayer = new AI(board, new GamePiece("O"));
		}
		UltimateTTTGame game = new UltimateTTTGame(board, xPlayer, oPlayer);
		game.playGame();

	}

}
