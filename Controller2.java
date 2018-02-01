import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 * Controller2.java
 * 
 * This class is used to play the game between two players
 * 
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */

public class Controller2 {

	/**Instantiation of classes */
	public View1 view;
	public ServerInterface regi;
	
	/**Boolean variables used to check for which player is placing his ships*/
	public static boolean flag1=false;
	
	/**Boolean variables used to check if the strike was a hit or a miss */
	public static boolean player1Flag=false, player2Flag=false;
	
	/**Boolean Variables used to check if it is the player's turn or not */
	public static boolean player1Turn=true, player2Turn=true;
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param view
	 * @param regi
	 * 
	 * @throws RemoteException
	 */
	
	public Controller2(View1 view, ServerInterface regi) throws RemoteException{
		this.regi=regi;
		this.view=view;
		view.addListener(new placeShips() );
	}
	
	/**
	 * Default COnstructor
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public Controller2(){
		
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
		 * This method is used to detect which button was
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
					if(flag1==false){
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
							flag1=true;
							view.frame.dispose();
							view.show();
							view.addListener(new placeShips() );
						}
					}
					else{
						if(regi.getCount2()>0){
							for(int i=0;i<64;i++){
								if(e.getSource() == view.button1[i]){
									view.button1[i].setBackground(Color.red);
									regi.setVal2(i);
									regi.decCount2();
								}
								}
						}
						else{
							view.frame.dispose();
							view.updateModel();
							view.addWatcher(new checkAction());
						}
					}
				}
				 catch (RemoteException e1) {
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
						if(player1Turn==false){
							view.notYourTurn();
							player2Turn=true;
							break;
						}
						else{
						player2Flag=regi.isVal2(i);
						if(player2Flag==true){
							view.button1[i].setBackground(Color.red);
							view.isHit();
							regi.shipsLeft2();
							if(regi.shipsRemaining2()==0){
								view.player1Won();
								System.exit(0);
							}
							player1Turn=false;
							player2Turn=true;
							break;
						}
						else{
							view.button1[i].setBackground(Color.green);
							view.isMiss();
							player1Turn=false;
							player2Turn=true;
							break;
						}
						
						}
					}
					else if(e.getSource()==view.button2[i]){
						if(player2Turn==false){
							view.notYourTurn();
							player1Turn=true;
						}
						else{
							player1Flag=regi.isVal(i);
							if(player1Flag==true){
								view.button2[i].setBackground(Color.red);
								view.isHit();
								regi.shipsLeft1();
								if(regi.shipsRemaining()==0){
									view.player2Won();
									System.exit(0);
								}
								player2Turn=false;
								player1Turn=true;
								break;
							}
							else{
								view.button2[i].setBackground(Color.green);
								view.isMiss();
								player2Turn=false;
								player1Turn=true;
								break;
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
	//end of Class Controller 2
}