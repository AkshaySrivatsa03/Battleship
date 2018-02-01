import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server.java
 * 
 * This class is used to initialize the server
 * 
 * @author	Sapna Ganesh sg1368
 * @author	Akshay Srivatsa ass4909
 *
 */

public class Server {

	/**String variable used to store the name of the RMI ID */
	public static final String RMIID="RMIID ";
	
	/**Integer used to store the value of the RMI Port Number*/
	public static final int RMIPort=222;
	
	/**
	 * Default Contsructor
	 * 
	 * @param	none
	 * 
	 * @throws RemoteException
	 * 
	 */
	protected Server() throws RemoteException {
		super();
	}
	
	/**
	 * The main method
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 * 
	 */
	
	public static void main(String args[]) throws RemoteException, AlreadyBoundException{
		Model model=new Model();
		Registry regis=LocateRegistry.createRegistry(RMIPort);
		regis.bind(RMIID, model);
		System.out.println("Server is up and running ! ");
	}
}
