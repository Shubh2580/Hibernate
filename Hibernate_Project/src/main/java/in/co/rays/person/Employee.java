package in.co.rays.person;

public class Employee {
private int id;
private String firstName;
private String lastName;
private Address empAddress;
public Employee() {
	
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}




public Address getEmpAddress() {
	return empAddress;
}
public void setEmpAddress(Address empAddress) {
	this.empAddress = empAddress;
}


}
