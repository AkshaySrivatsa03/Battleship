import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

/**
 * Controller.java
 * 
 * This class is used to play the game between a player
 * and the computer
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */


public class Controller {
	
	/**Instantiations of Classes*/
	View1 view;
	public ServerInterface regi;
	
	/**Boolean variables used to check the validity of outputs*/
	public boolean flag, flag2;
	
	/**Integer variables used to process the game */
	public static int checkCompShips, target, shipsleft;
	
	/**
	 * Paramterized Constructor
	 * 
	 * @param view
	 * @param regi
	 * 
	 * @throws RemoteException
	 * 
	 */
	
	public Controller(View1 view, ServerInterface regi) throws RemoteException{
		this.regi=regi;
		this.view=view;
		view.addListener(new placeShips() );
		regi.generateShips();
	}
	
	/**
	 * Default Constructor
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public Controller() {
	}

	/**
	 * This private inner class is used to provide
	 * action listeners for when the player places 
	 * his ships on the grid
	 * 
	 * @author	Sapna Ganesh sg1368
	 * @author	Akshay Srivatsa ass4909
	 *
	 */
	
	private class placeShips implements ActionListener{

		/**
		 * This method is used to detect which buttons were
		 * pressed and change their colour for notification
		 * 
		 *  @param	e
		 *  
		 *  @return	void
		 * 
		 */
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				try {
					if(regi.getCount()>0){	
						for(int i=0;i<64;i++){
						if(e.getSource() == view.button1[i]){
							view.button1[i].setBackground(Color.red);
							regi.setVal1(i);
							regi.decCount1();
						}
						}
					}
					else{
						view.frame.dispose();
						view.updateModel();
						view.addWatcher(new checkAction());
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
		}
		//end of private class placeShips
	}
	
	/**
	 * This private inner class is used to provide
	 * interactions for the game 
	 * 
	 * @author	Sapna Ganesh sg1368
	 * @author	Akshay Srivatsa ass4909
	 *
	 */
	
	private class checkAction implements ActionListener{

		/**
		 * This method is used to provide the interactions for
		 * playing the game
		 * 
		 * @param	e
		 * 
		 * @return	void
		 */
		
		public void actionPerformed(ActionEvent e) {
			try{
				for(int i=0;i<64;i++){
					if(e.getSource() == view.button1[i]){
						flag=regi.defend(i);
						if(flag==true){
						view.button1[i].setBackground(Color.red);
						view.isHit();
						regi.decCompShips();
						checkCompShips=regi.checkCompShips();
						if(checkCompShips==0){
							view.gameOver();
							System.exit(0);
						}
						target=regi.attack();
						flag2=regi.isVal(target);
						if(flag2==true){
							view.button2[target].setBackground(Color.red);
							view.isHit();
							regi.shipsLeft1();
							shipsleft=regi.shipsRemaining();
							if(shipsleft==0){
								view.compWon();
								System.exit(0);
							}
						}
						else{
							view.button2[target].setBackground(Color.green);
							view.isMiss();
						}
						
					}
					else{
						view.button1[i].setBackground(Color.green);
						view.isMiss();
						target=regi.attack();
						flag2=regi.isVal(target);
						if(flag2==true){
							view.button2[target].setBackground(Color.red);
							view.isHit();
							regi.shipsLeft1();
							shipsleft=regi.shipsRemaining();
							if(shipsleft==0){
								view.compWon();
								System.exit(0);
							}
						}
						else{
							view.button2[target].setBackground(Color.green);
							view.isMiss();
						}
					}
					}
				}
			}
			catch(RemoteException e2){
				e2.printStackTrace();
			}
		}
		//end of private class checkAction
	}
	//end of class Controller
}
