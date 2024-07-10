package lk.next.workshop.calculator;

import java.rmi.*;

public interface Calculator extends java.rmi.Remote {
	public float calculate(float num1, float num2, String op) throws java.rmi.RemoteException;
}