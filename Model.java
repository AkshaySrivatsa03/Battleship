import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * Model.java
 * 
 * This class is used to store the data for the game
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */


public class Model extends UnicastRemoteObject implements ServerInterface {

	
	/**Default Serial Version ID*/
	private static final long serialVersionUID = 1L;
	
	/**Variable for detecting when player has finished placing ships*/
	public int noOfShips1=7;
	
	/**Variable for detecting when player2 has finished placing ships*/
	public int noOfShips2=7;
	
	/**Variables used for storing the number of ships not hit yet */
	public static int noOfShipsRemaining1=7, noOfShipsRemaining2=7, noOfCompShips=7;
	
	/**Variables used to increment the arrays used to store the locations of ships*/
	public static int count1=0,count2=0;
	
	/**Array used to store the locations of Player1's ships */
	public static int[] locationsOfPlayer1=new int[7];
	
	/**Array used to store the locations of Player2's ships */
	public static int[] locationsOfPlayer2=new int[7];
	
	/**Array used to store the locations of Computer's ships */
	public int[] computerShips=new int[7];
	
	/**Instantiation of the random Class from package java.util*/
	public Random random=new Random();
	
	/**
	 * Default Constructor
	 *
	 * @param	none
	 * 
	 * @throws RemoteException 
	 * 
	 */
	
	public Model() throws RemoteException{
		super();
	}
	
	/**
	 * This method is used to check whether all the ships
	 * for player 1 have been placed
	 * 
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void decCount1(){
		noOfShips1--;
	}
	
	/**
	 * This method is used to obtain the number of ships
	 * yet to be placed by player 1
	 * 
	 * @param	none
	 * 
	 * @return	noOfShips1
	 * 
	 */
	
	public int getCount(){
		return noOfShips1;
	}
	
	/**
	 * This method is used to check whether all the ships
	 * for player 2 have been placed
	 * 
	 * @param	none
	 * 
	 * @return	void
	 */
	
	public void decCount2(){
		noOfShips2--;
	}
	
	/**
	 * This method is used to obtain the number of ships
	 * yet to be placed by player2
	 * 
	 * @param	none
	 * 
	 * @return	noOfShips1
	 * 
	 */
	
	public int getCount2(){
		return noOfShips2;
	}
	
	/**
	 * This method is used to store the values
	 * of the ship locations for player 1
	 * 
	 * @param location
	 * 
	 * @return	void
	 */
	
	public void setVal1(int location){
		locationsOfPlayer1[count1]=location;
		count1++;
	}
	
	/**
	 * This method is used to store the values
	 * of the ship locations for player 2
	 * 
	 * @param location
	 * 
	 * @return	void
	 */
	
	public void setVal2(int location){
		locationsOfPlayer2[count2]=location;
		count2++;
	}
	
	/**
	 * This method is used to check if a ship
	 * is occupying the square selected by
	 * player 2
	 * 
	 * @param	location
	 * 
	 * @return	temp
	 * 
	 */
	
	public int getVal1(int location){
		int temp=-1;
		for(int i=0;i<7;i++){
			if(locationsOfPlayer1[i]==location){
				temp=locationsOfPlayer1[i];
			}
		}
		return temp;
	}
	
	/**
	 * This method is used to check if a ship
	 * is occupying the square selected by
	 * player 1
	 * 
	 * @param	location
	 * 
	 * @return	Integer
	 */
	
	public int getVal2(int location){
		int temp=-1;
		for(int i=0;i<7;i++){
			if(locationsOfPlayer2[i]==location){
				temp=locationsOfPlayer2[i];
			}
		}
		return temp;
	}
	
	/**
	 * This method is used to decrement the number of ship
	 * counters left for player 1
	 * 
	 * @param	none
	 * 
	 * @return	noOfShipsRemaining1
	 * 
	 */
	
	public void shipsLeft1(){
		noOfShipsRemaining1--;
	}
	
	/**
	 * This method is used to decrement the number of ship
	 * counters left for player 2
	 * 
	 * @param	none
	 * 
	 * @return	Integer
	 */
	
	public void shipsLeft2(){
		noOfShipsRemaining2--;
	}
	
	/**
	 * This method is used by the computer to randomly
	 * target a location on the player's board
	 * 
	 * @param	none
	 * 
	 * @return	target
	 * 
	 */
	
	public int attack(){
		int target=random.nextInt(64);
		return target;
	}
	
	/**
	 * This method is used to check if the square selected
	 * by the Player is the location of a ship of Computer
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 * 
	 */
	
	public boolean defend(int location){
		boolean flag=false;
		for(int i=0;i<7;i++){
			if(location==computerShips[i]){
				flag=true;
				break;
			}
			else {
				flag=false;
			}
		}
		return flag;	
	}
	
	/**
	 * This method is used to randomly store locations of
	 * Computer's Ships
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public void generateShips(){
		for(int i=0;i<7;i++){
			computerShips[i]=random.nextInt(64);
		}
	}
	
	/**
	 * This method is used to decrement the number of Computer
	 * Ships left
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 */
	
	public void decCompShips(){
		noOfCompShips--;
	}
	
	/**
	 * This method is used to check the number of
	 * Computer Ships left
	 * 
	 * @param	none
	 * 
	 * @return	noOfCompShips
	 * 
	 */
	
	public int checkCompShips(){
		return noOfCompShips;
	}
	
	/**
	 * This method is used to check if the square selected
	 * for attacking has a ship belonging to player1
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 */
	
	public boolean isVal (int location){
		boolean flag=false;
		for(int i=0;i<7;i++){
			if(location==locationsOfPlayer1[i]){
				flag=true;
				break;
			}
			else{
				flag=false;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to check if the square selected
	 * for attacking has a ship  belonging to player 2
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 */
	
	public boolean isVal2 (int location){
		boolean flag=false;
		for(int i=0;i<7;i++){
			if(location==locationsOfPlayer2[i]){
				flag=true;
				break;
			}
			else{
				flag=false;
			}
		}
		return flag;
	}
	
	/**
	 * This method is used to get the number of player 1's ships
	 * left
	 * 
	 * @param	none
	 * 
	 * @return	noOfShipsRemaining1
	 * 
	 */
	
	public int shipsRemaining(){
		return noOfShipsRemaining1;
	}
	
	/**
	 * This method is used to get the number of player 2's
	 * ships left
	 * 
	 * @param	none
	 * 
	 * @return	noOfShipsRemaining2
	 * 
	 */
	
	public int shipsRemaining2(){
		return noOfShipsRemaining2;
	}
}