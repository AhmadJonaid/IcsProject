public class Department {
private String departmentName;
private String responsiblePerson;

public Department(String departmentName, String responsiblePerson) {
	this.departmentName = departmentName;
	this.responsiblePerson = responsiblePerson;
}
public void printDepartment() {
	System.out.println("Department name: " + departmentName);
	System.out.println("responsiblePerson name: " + responsiblePerson);
}


}
