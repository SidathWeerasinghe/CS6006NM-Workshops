package lk.next.workshop.server.impl;

import java.rmi.server.UnicastRemoteObject;

import lk.next.workshop.CreditChecker;
import lk.next.workshop.Person;

import java.rmi.RemoteException;

public class CreditCheckerImpl extends UnicastRemoteObject implements CreditChecker {

	private static final long serialVersionUID = 1L;

	public CreditCheckerImpl() throws RemoteException {
	}

	public boolean isOkay(Person person) throws RemoteException {
		return person.getCreditRating();
	}

}
