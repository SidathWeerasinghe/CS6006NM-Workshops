package lk.next.workshop;

import java.io.*;
import java.util.Date;

public class HeadQuarterEmpProcessor2 {
	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		emp.fName = "John";
		emp.lName = "Smith";
		emp.salary = 50000;
		emp.address = "12 main street";
		emp.hireDate = new Date();
		FileOutputStream fOut = null;
		ObjectOutputStream oOut = null;
		try {
			fOut = new FileOutputStream("NewEmployee2.ser");
			oOut = new ObjectOutputStream(fOut);
			emp.writeExternal(oOut); // serializing employee
			System.out.println("An employee is serialized into NewEmployee2.ser");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oOut.flush();
				oOut.close();
				fOut.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}