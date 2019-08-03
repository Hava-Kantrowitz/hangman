import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
	 * This class handles all key press events
	 * @author havak
	 *
	 */
	public class TAdapter extends KeyAdapter{
		
		public String letter;
		
		/**
		 * Determines course of action when the key is pressed
		 * If you are going in one direction, you can't go in the immediate opposite direction and walk in on yourself
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_A) {
				letter = "A";
			}
			else if (key == KeyEvent.VK_B) {
				letter = "B";
			}
			else if (key == KeyEvent.VK_C) {
				letter = "C";
			}
			else if (key == KeyEvent.VK_D) {
				letter = "D";
			}
			else if (key == KeyEvent.VK_E) {
				letter = "E";
			}
			else if (key == KeyEvent.VK_F) {
				letter = "F";
			}
			else if (key == KeyEvent.VK_G) {
				letter = "G";
			}
			else if (key == KeyEvent.VK_H) {
				letter = "H";
			}
			else if (key == KeyEvent.VK_I) {
				letter = "I";
			}
			else if (key == KeyEvent.VK_J) {
				letter = "J";
			}
			else if (key == KeyEvent.VK_K) {
				letter = "K";
			}
			else if (key == KeyEvent.VK_L) {
				letter = "L";
			}
			else if (key == KeyEvent.VK_M) {
				letter = "M";
			}
			else if (key == KeyEvent.VK_N) {
				letter = "N";
			}
			else if (key == KeyEvent.VK_O) {
				letter = "O";
			}
			else if (key == KeyEvent.VK_P) {
				letter = "P";
			}
			else if (key == KeyEvent.VK_Q) {
				letter = "Q";
			}
			else if (key == KeyEvent.VK_R) {
				letter = "R";
			}
			else if (key == KeyEvent.VK_S) {
				letter = "S";
			}
			else if (key == KeyEvent.VK_T) {
				letter = "T";
			}
			else if (key == KeyEvent.VK_U) {
				letter = "U";
			}
			else if (key == KeyEvent.VK_V) {
				letter = "V";
			}
			else if (key == KeyEvent.VK_W) {
				letter = "W";
			}
			else if (key == KeyEvent.VK_X) {
				letter = "X";
			}
			else if (key == KeyEvent.VK_Y) {
				letter = "Y";
			}
			else if (key == KeyEvent.VK_Z) {
				letter = "Z";
			}
			else {
				letter = null;
			}
			
			
	}
	
	

}