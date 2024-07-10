package lk.next.workshop.calculator.server.impl;

import java.rmi.*;

import lk.next.workshop.calculator.Calculator;

import java.math.*;

public class CalcImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = 1L;

	public CalcImpl() throws java.rmi.RemoteException {
	}

	public float calculate(float num1, float num2, String op) throws java.rmi.RemoteException {
		if (op.equals("+")) {
			return num1 + num2;
		} else if (op.equals("-")) {
			return num1 - num2;
		} else if (op.equals("*")) {
			return num1 * num2;
		} else if (op.equals("/")) {
			return num1 / num2;
		} else if (op.equals("1/x")) {
			return 1 / num1;
		} else if (op.equals("s")) {
			return (float) (Math.sqrt(num1));
		} else
			return 0;
	}// end of calculate method
}// end of CalcImpl