package lk.next.workshop.client;

import java.rmi.registry.*;

import lk.next.workshop.CreditChecker;
import lk.next.workshop.Person;

import java.rmi.*;

public class CreditCheckerClient {
	public static void main(String args[]) {

		Person[] people = new Person[3];
		people[0] = new Person("Mark", "Campbell", true);
		people[1] = new Person("Vassil", "Vassilev", false);
		people[2] = new Person("Peter", "Cambridge", true);

		String host = (args.length < 1) ? null : args[0];

		try {
			System.out.println("locating RMI Registry");
			Registry registry = LocateRegistry.getRegistry(host);

			System.out.println("looking up object: " + CreditChecker.NAME);
			CreditChecker checker = (CreditChecker) registry.lookup(CreditChecker.NAME);
			System.out.println("***********************************************");
			System.out.println("* invoking the remote method with a parameter *");
			System.out.println("***********************************************");
			for (int i = 0; i < people.length; i++) {
				System.out.println(people[i].toString() + " -> good credit = " + checker.isOkay(people[i]));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
