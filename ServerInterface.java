import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ServerInterface.java
 * 
 * This interface is used to provide method definitions
 * for the Server and acts a reference for what methods the 
 * Client can access
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */

public interface ServerInterface extends Remote {
	
	/**
	 * This method is used to check whether all the ships
	 * for player 1 have been placed
	 * 
	 * @param	none
	 *
	 * @return	void
	 * 
	 * @throws	RemoteException
	 */
	
	public void decCount1() throws RemoteException;
	
	/**
	 * This method is used to obtain the number of ships
	 * yet to be placed
	 * 
	 * @param	none
	 * 
	 * @return	int
	 * 
	 * @throws	RemoteException 
	 */
	
	public int getCount() throws RemoteException;
	
	/**
	 * This method is used to check whether all the ships
	 * for player 2 have been placed
	 * 
	 * @param	none
	 *
	 * @return	void
	 * 
	 * @throws	RemoteException
	 */
	
	public void decCount2() throws RemoteException;
	
	/**
	 * This method is used to obtain the number of ships
	 * yet to be placed
	 * 
	 * @param	none
	 * 
	 * @return	int
	 * 
	 * @throws	RemoteException 
	 */
	
	public int getCount2() throws RemoteException;
	
	/**
	 * This method is used by the computer to randomly
	 * target a location on the player's board
	 * 
	 * @param	none
	 * 
	 * @return	target
	 * 
	 * @throws	RemoteException 
	 */
	
	public int attack() throws RemoteException;
	
	/**
	 * This method is used to randomly store locations of
	 * Computer's Ships
	 * 
	 * @param	none
	 * 
	 * @return	void
	 * 
	 * @throws	RemoteException
	 */
	
	public void generateShips() throws RemoteException;
	
	/**
	 * This method is used to check if the square selected
	 * by the Player is the location of a ship of Computer
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 * 
	 * @throws	RemoteException
	 * 
	 */
	
	public boolean defend(int location) throws RemoteException;
	
	/**
	 * This method is used to check the number of
	 * Computer Ships left
	 * 
	 * @param	none
	 * 
	 * @return	noOfCompShips
	 * 
	 * @throws	RemoteException
	 */
	
	public int checkCompShips() throws RemoteException;
	
	/**
	 * This method is used to decrement the number of Computer
	 * Ships left
	 * 
	 * @param	none
	 * 
	 * @return	void
	 *
	 * @throws	RemoteException
	 */
	
	public void decCompShips() throws RemoteException;
	
	/**
	 * This method is used to store the values
	 * of the ship locations for player 1
	 * 
	 * @param location
	 * 
	 * @return	void
	 * 
	 * @throws	RemoteException
	 */
	
	public void setVal1(int location)  throws RemoteException;
	
	/**
	 * This method is used to check if the square selected
	 * for attacking has a ship belonging to player 1
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 * 
	 * 
	 * @throws	RemoteException
	 */
	
	public boolean isVal (int location) throws RemoteException;
	
	/**
	 * This method is used to check if the square selected
	 * for attacking has a ship belonging to player 2
	 * 
	 * @param	location
	 * 
	 * @return	flag
	 */
	
	public boolean isVal2 (int location) throws RemoteException;
	
	/**
	 * This method is used to store the values
	 * of the ship locations for player 2
	 * 
	 * @param location
	 * 
	 * @return	void
	 * 
	 * @throws	RemoteException 
	 */
	
	public void setVal2(int location)  throws RemoteException;
	

	/**
	 * This method is used to check if a ship
	 * is occupying the square selected by
	 * player 1
	 * 
	 * @param	location
	 * 
	 * @return	temp
	 *
	 * @throws	RemoteException
	 */
	
	public int getVal1(int location)  throws RemoteException;
	

	/**
	 * This method is used to check if a ship
	 * is occupying the square selected by
	 * player 2
	 * 
	 * @param	location
	 * 
	 * @return	temp
	 * 
	 * @throws	RemoteException 
	 */
	
	public int getVal2(int location)  throws RemoteException;
	
	/**
	 * This method is used to get the number of player 1's ships
	 * left
	 * 
	 * @param	none
	 * 
	 * @return	noOfShipsRemaining1
	 *
	 * @throws	RemoteException
	 */
	
	
	public int shipsRemaining() throws RemoteException;
	
	/**
	 * This method is used to decrement the number of ship
	 * counters left for player 1
	 * 
	 * @param	none
	 * 
	 * @throws	RemoteException
	 */
	
	public void shipsLeft1()  throws RemoteException;
	
	/**
	 * This method is used to decrement the number of ship
	 * counters left for player 2
	 * 
	 * @param	none
	 * 
	 * @throws	RemoteException
	 */
	
	public void shipsLeft2()  throws RemoteException;
	
	/**
	 * This method is used to get the number of player 2's
	 * ships left
	 * 
	 * @param	none
	 * 
	 * @return	noOfShipsRemaining2
	 * 
	 * @throws	RemoteException
	 */
	
	public int shipsRemaining2() throws RemoteException;
}