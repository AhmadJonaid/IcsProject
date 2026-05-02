public class Department {
private String departmentName;
private String responsiblePerson;

public Department(String departmentName, String responsiblePerson) {
	this.departmentName = departmentName;
	this.responsiblePerson = responsiblePerson;
}
public String getDepartmentName(){
	return departmentName;
}
public String getResponsiblePerson(){
	return responsiblePerson;
}
public void printDepartment() {
	System.out.println("Department name: " + getDepartmentName());
	System.out.println("responsiblePerson name: " + getResponsiblePerson());
}


}
