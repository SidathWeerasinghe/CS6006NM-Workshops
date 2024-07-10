package lk.next.workshop.server;

import java.rmi.registry.*;

import lk.next.workshop.CreditChecker;
import lk.next.workshop.server.impl.CreditCheckerImpl;

public class CreditCheckerServer {
	public static void main(String args[]) {
		try {
			System.out.println("creating credit checker");
			CreditCheckerImpl creditChecker = new CreditCheckerImpl();

			System.out.println("locating local RMI Registry");
			Registry registry = LocateRegistry.getRegistry();

			System.out.println("registering credit checker with RMI Registry");
			
			registry.rebind(CreditChecker.NAME, creditChecker);
			
			System.out.println("*********************************");
			System.out.println("* waiting for client requests...*");
			System.out.println("*********************************");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
