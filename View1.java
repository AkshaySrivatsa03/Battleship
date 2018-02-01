import java.awt.*;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * View1.java
 * 
 * This class is used to display the game
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */

public class View1 {

	/**Instantiations of various classes*/
	public JFrame frame;
	public JPanel panel, secondPanel;
	public JButton button1[]=new JButton[64];
	public JButton button2[]=new JButton[64];
	
	/**
	 * Default Constructor
	 * 
	 */
	
	public View1(){
	
	}
	
	/**
	 * This method is used to provide the initial
	 * board to the player upon which he will place
	 * his ships
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public void show(){
		
		frame=new JFrame("Battle Ship");
		panel=new JPanel();
		panel.setLayout(new GridLayout(8,8));
		for (int i =0; i<64; i++){
			button1[i] = new JButton(" " +(i+1));
			button1[i].setBackground(Color.white);
			panel.add(button1[i]);
		}
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	/**
	 * This method adds Action Listeners for the buttons
	 * displayed in method, show()
	 * 
	 * @param e
	 * 
	 * @return	void
	 * 
	 */
	
	public void addListener(ActionListener e){
		for(int i=0;i<64;i++){
			button1[i].addActionListener(e);
		}
	}
	
	/**
	 * This method is sued to show the boards
	 * for the game. It contains the enemy's ships
	 * above and the player's ships below
	 * 
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void updateModel(){
		frame=new JFrame("Battle Ship");
		GridBagConstraints cons = new GridBagConstraints();
		panel=new JPanel();
		secondPanel=new JPanel();
		panel.setLayout(new GridLayout(8,8));
		for (int i =0; i<64; i++){
			button1[i] = new JButton(" " +(i+1));
			button1[i].setBackground(Color.white);
			button1[i].setOpaque(true);
			panel.add(button1[i]);
		}
		secondPanel.setLayout(new GridLayout(8,8) );
		for (int i =0; i<64; i++){
			button2[i] = new JButton(" " +(i+1));
			button2[i].setBackground(Color.blue);
			button2[i].setOpaque(true);
			panel.add(button2[i]);
		}
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * This method adds Action Listeners for the buttons
	 * displayed in method, updateview()
	 * 
	 * @param e
	 * 
	 * @return	void
	 * 
	 */
	
	public void addWatcher(ActionListener e){
		for(int i=0;i<64;i++){
			button1[i].addActionListener(e);
			button2[i].addActionListener(e);
		}
	}
	
	/**
	 * This method is sued to display whether the strike
	 * was a hit
	 * 
	 *  @param	none
	 *  
	 *  @return	void
	 * 
	 */
	
	public void isHit(){
		JOptionPane.showMessageDialog(null, "It's a Hit !");
	}
	
	/**
	 * This method is sued to display whether the strike
	 * was a miss
	 * 
	 *  @param	none
	 *  
	 *  @return	void
	 * 
	 */
	
	public void isMiss(){
		JOptionPane.showMessageDialog(null, "It's a Miss !");
	}
	
	/**
	 * This method is sued to display the message that the computer won
	 *
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void compWon(){
		JOptionPane.showMessageDialog(null, "Computer wins !");
	}
	
	/**
	 * This method is sued to display the message that the player won
	 *
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void gameOver(){
		JOptionPane.showMessageDialog(null, "You won !");
	}
	
	/**
	 * This method is sued to display the message that player 1 won
	 *
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void player1Won(){
		JOptionPane.showMessageDialog(null, "Player 1 won !");
	}
	
	/**
	 * This method is sued to display the message that player 2 won
	 *
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void player2Won(){
		JOptionPane.showMessageDialog(null, "Player 2 won !");
	}
	
	/**
	 * This method is sued to inform the player that it is 
	 * not their turn
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public void notYourTurn(){
		JOptionPane.showMessageDialog(null, "Not Your turn");
	}
}