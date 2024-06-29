package lk.next.workshop;

import java.io.*;

class Employee2 implements Externalizable {
	String lName;
	String fName;
	double salary;
	java.util.Date hireDate;
	String address;

	public void writeExternal(ObjectOutput stream) throws java.io.IOException {
// Serializing only salary and last name
		stream.writeDouble(salary);
		stream.writeUTF(lName); // String encoded in UTF-8 format
	}

	public void readExternal(ObjectInput stream) throws java.io.IOException {
		salary = stream.readDouble();
		lName = stream.readUTF();
	}
}
