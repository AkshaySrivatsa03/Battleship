
import java.awt.GridLayout;
import java.awt.event.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * StartScreen.java
 * 
 * This class is presented at the beginning to present
 * the player with the options for the game
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */

public class StartScreen extends Thread {
	
	/**Class field declarations*/
	public JFrame frame;
	public JPanel panel;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	
	/**String variable used to store the name of the RMI ID */
	public static final String RMIID="RMIID ";
	
	/**Integer used to store the value of the RMI Port Number*/
	public static final int RMIPort=222;
	
	/**
	 * This method is used to display a screen for the player to
	 * place his/her ships
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public void firstScreen(){
		
		frame=new JFrame("battle Ship");
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));
		button1=new JButton("Player vs Player");
		button1.addActionListener(new selectOption() );
		button2=new JButton("Player vs Computer");
		button2.addActionListener(new selectOption() );
		button3=new JButton("Help");
		button3.addActionListener(new selectOption() );
		button4=new JButton("Exit");
		button4.addActionListener(new selectOption() );
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.add(panel);
		frame.setSize(200,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/***
	 * This private internal class is used to add action listeners
	 * for the buttons displayed
	 * 
	 * @author	Sapna Ganesh sg1368
	 * @author	Akshay Srivatsa ass4909
	 *
	 */
	
	private class selectOption implements ActionListener{
		
		@Override
		
		/**
		 * This method is used to identify which button has been
		 * selected and perform the corresponding action
		 * 
		 * @param	e
		 * 
		 * @return	void
		 */
		
		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == button1){
				try{
					frame.dispose();
					Registry regi = null;
					ServerInterface inter = null;
					regi = LocateRegistry.getRegistry("localhost",RMIPort);
					inter=(ServerInterface) regi.lookup(RMIID);
					View1 view=new View1();
					view.show();
					Controller2 control2=new Controller2(view, inter);
				}
			catch(Exception excep){
				excep.printStackTrace();
			}
			}
			
			else if(e.getSource() == button2){
				try{
					frame.dispose();
					Registry regi = null;
					ServerInterface inter = null;
					regi = LocateRegistry.getRegistry("localhost",RMIPort); 
					inter=(ServerInterface) regi.lookup(RMIID);
					View1 view=new View1();
					view.show();
					Controller control=new Controller(view, inter);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
			else if(e.getSource() == button3){
			JOptionPane.showMessageDialog(null, "The game is played on four grids, two for each player. "
					+ "On one grid the player arranges ships and records the shots by the opponent."
					+ " On the other grid the player records his/her own shots."
					+ "The objective is to destroy all the other player's ships");
		}
			else if(e.getSource() == button4){
				JOptionPane.showMessageDialog(null," Exiting the game !");
				System.exit(0);
			}
		
	}
		//ActionListener Class ends
	}
	
	/**
	 * The main method for the class StartScreen
	 * 
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	
	public static void main(String args[]) throws RemoteException, NotBoundException{
		
		StartScreen screen=new StartScreen();
		screen.firstScreen();
		
	}
}