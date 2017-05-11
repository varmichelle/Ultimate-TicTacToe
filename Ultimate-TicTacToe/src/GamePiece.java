/**
 * 
 * @author Somya Bhatia
 * Period 1
 *
 */
public class GamePiece {
	private String XorO;
	
	/**
	 * constructor to pass in values for the two variables
	 * @param exoh - either X or O
	 */
	public GamePiece(String exoh) {
		XorO = exoh;
	}
	
	/**
	 * setter method to set the value of the game piece
	 * @param exoh - either X or O
	 */
	public void setXorO(String exoh) {
		XorO = exoh;
	}
	
	/**
	 * getter method to return either X or O
	 * @return
	 */
	public String getXorO() {
		return XorO;
	}
	
	
}
