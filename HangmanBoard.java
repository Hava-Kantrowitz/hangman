import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Plays the game snake
 * @author havak
 *
 */
public class HangmanBoard extends JPanel implements ActionListener{
	
	private final int B_WIDTH = 400;//board width
	private final int B_HEIGHT = 800;//board height
	private Timer timer;//the timer to run the animation
	private final int DELAY = 120;//the speed of the animation in ms
	
	private boolean inGame = true;//whether the game is running or not
	int numRound = 0;//the round number, or the number of total guesses so far
	
	String guessWord = "Hava";//the word to guess
	
	TAdapter listener = new TAdapter();//t adapter
	String currLetter;//the letter currently being pressed on the keyboard
	String nowLetter;//the most recent letter submitted to the game
	
	String letterArray[] = new String[26];//array to hold all potential false letters
	int arrayCount = 0;//counter for letter array

	/**
	 * Constructor
	 * When the snake game starts, the board is initialized
	 */
	public HangmanBoard() {
		initBoard();
	}
	
	/**
	 * Initializes the board
	 * Adds a key listener
	 * Sets the focus, background color, and size
	 * Loads images
	 */
	public void initBoard() {
		
		addKeyListener(listener);
		setFocusable(true);
		setBackground(Color.WHITE);
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		initGame();
		
		//initializes the letter array with blanks 
		for (int counter = 0; counter < letterArray.length; counter++) {
			letterArray[counter] = "";
		}
	}
	
	
	/**
	 * Initializes the game
	 */
	private void initGame() {
		
		timer = new Timer(DELAY, this);//initializes the timer
		timer.start();//starts the animation
	}
	
	public void getLetter() {
		currLetter = listener.letter;//gets the letter from the user
		if(currLetter != nowLetter) {//if the letter obtained is not the most recently used one
			nowLetter = currLetter;//then it is now the most recently used one
			if (!(isInArray(nowLetter)) && !isInWord(nowLetter)) {//if it's not already in the letter array, and it isn't in the word itself
				letterArray[arrayCount] = nowLetter;//then put it into the letter array
				arrayCount++;//and increase the letter array counter
				numRound++;//increase the round
			}
		}
	}
	
	/**
	 * Determines if the letter under consideration is in the false letter array
	 * @param nowLetter the letter currently being considered
	 * @return true if the letter is in the array, false otherwise
	 */
	public boolean isInArray(String nowLetter) {
		
		boolean isIn = false;//assume false
		for(String letter : letterArray) {
			if (letter == nowLetter) {
				isIn = true;//loop through array, if letter is found set to true
			}
		}
		
		return isIn;
	}
	
	/**
	 * Paints the screen
	 * @param g the input of the graphics class
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;//make it a 2d drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);//turn on rendering hints
 
        g2d.setStroke(new BasicStroke(3));//set the size of the stroke
        g2d.setColor(Color.black);//set the color to black
        
        paintLetters(g2d);//paint the false letters
        
        
        switch(numRound) {//paint the hangman depending on the round
        	case 0: 
        		paintHanging(g2d);
        		break;
        	case 1: 
        		paintHanging(g2d);
        		paintHead(g2d);
        		break;
        	case 2:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		break;
        	case 3: 
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		break;
        	case 4:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		break;
        	case 5:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		break;
        	case 6:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		break;
        	case 7:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		paintRightHand(g2d);
        		break;
        	case 8:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		paintRightHand(g2d);
        		paintLeftHand(g2d);
        		break;
        	case 9:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		paintRightHand(g2d);
        		paintLeftHand(g2d);
        		paintRightFoot(g2d);
        		break;
        	case 10: 
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		paintRightHand(g2d);
        		paintLeftHand(g2d);
        		paintRightFoot(g2d);
        		paintLeftFoot(g2d);
        		break;
        	case 11:
        		paintHanging(g2d);
                paintHead(g2d);
        		paintTorso(g2d);
        		paintRightArm(g2d);
        		paintLeftArm(g2d);
        		paintRightLeg(g2d);
        		paintLeftLeg(g2d);
        		paintRightHand(g2d);
        		paintLeftHand(g2d);
        		paintRightFoot(g2d);
        		paintLeftFoot(g2d);
        		paintFace(g2d);
        		break;
        	default:
        		System.out.println("You done goofed.");
        		break;
        		
        		
        }
		
		
	}
	
	/**
	 * Determines if the given letter is in the word 
	 * @param nowLetter the letter under consideration
	 * @return true if in word, false otherwise
	 * THERE IS SOME ISSUE HERE WHERE IT ISN'T LOOPING THROUGH THE WHOLE WORD JUST THE FIRST LETTER
	 */
	public boolean isInWord(String nowLetter) {
		boolean isIn = false;//assume not in
		char charLetter = nowLetter.charAt(0);//convert the letter to char
		for(int i = 0; i < guessWord.length(); i++) {//for each index in the guess word
			
			if(charLetter == guessWord.charAt(i)) {
				isIn = true; //if the letter is true 
			}
		}
		return isIn;
	}
	
	public void paintLetters(Graphics2D g2d) {
		int counterLetter = 0; 
		if(nowLetter != null) {
			for(int letterCount = 0; letterCount < letterArray.length; letterCount++) {
				
				if (letterCount < 16) {
				g2d.drawString(letterArray[letterCount], 225 + (10*letterCount), 50);
				}
				
				else {
					
					g2d.drawString(letterArray[letterCount], 225 + (10*counterLetter), 70);
					counterLetter++;
				}
				
			}	
		}
	}
	
	 /**
     * Draws the game over screen
     * @param g the graphics input
     */
    private void drawGameOver(Graphics g) {
		String msg = "Game Over. You lose!";
		Font small = new Font("Helvetica", Font.BOLD, 30);
		FontMetrics fm = getFontMetrics(small);
		
		g.setColor(Color.black);
		setBackground(Color.green);
		g.setFont(small);
		g.drawString(msg, 90, 350);
	}
	
	public void paintHanging(Graphics2D g2d) {
		g2d.drawLine(50, 230, 100, 230);
		g2d.drawLine(75, 230, 75, 30);
		g2d.drawLine(75, 30, 195, 30);
		g2d.drawLine(195, 30, 195, 50);
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void paintHead(Graphics2D g2d) {
		
		g2d.drawOval(170, 50, 50, 50);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintTorso(Graphics2D g2d) {
		g2d.drawLine(195, 100, 195, 200);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintRightArm(Graphics2D g2d) {
		g2d.drawLine(195, 140, 230, 120);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintLeftArm(Graphics2D g2d) {
		g2d.drawLine(195, 140, 160, 120);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintRightLeg(Graphics2D g2d) {
		g2d.drawLine(195, 200, 230, 230);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintLeftLeg(Graphics2D g2d) {
		g2d.drawLine(195, 200, 160, 230);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintRightHand(Graphics2D g2d) {
		g2d.fillOval(228, 112, 10, 10);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintLeftHand(Graphics2D g2d) {
		g2d.fillOval(152, 112, 10, 10);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintRightFoot(Graphics2D g2d) {
		g2d.drawLine(230, 230, 240, 230);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintLeftFoot(Graphics2D g2d) {
		g2d.drawLine(160, 230, 150, 230);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public void paintFace(Graphics2D g2d) {
		g2d.fillOval(185, 65, 5, 5);
		g2d.fillOval(200, 65, 5, 5);
		Shape shape = new Arc2D.Float(185, 80, 20, 10, 180, 180, Arc2D.OPEN);
		g2d.draw(shape);
		Toolkit.getDefaultToolkit().sync();//smooth out the animation
	}
	
	public boolean isInGame() {
		if (numRound <= 11) {
			return true;
		}
		else {
			timer.stop();
			return false;
			
		}
	}
	
	/**
	 * The action performed every delay miliseconds of the timed animation
	 * @param arg0 the input to action performed
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//if the game is still going on
		if(inGame) {
			getLetter();
			isInGame();
		}
		
		repaint();//repaint the board
		
	}
	
	
	

}

