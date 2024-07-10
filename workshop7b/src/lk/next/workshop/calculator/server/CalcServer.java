package lk.next.workshop.calculator.server;

import java.rmi.*;

import lk.next.workshop.calculator.Calculator;
import lk.next.workshop.calculator.server.impl.CalcImpl;

public class CalcServer {

	public CalcServer() {
		System.out.println("Trying to create a server;");
		try {
			Calculator calc = new CalcImpl();
			Naming.rebind("Calculator", calc);
			System.out.println("A new server created.");
		} catch (Exception e) {
			System.out.println("Error creating the server: " + e);
		} // end of try
	}// end of CalcServer

	public static void main(String args[]) {
		new CalcServer();
	}// end of main

}