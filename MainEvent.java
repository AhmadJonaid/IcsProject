public class Event {
private String name;
private int startTime;
private int endTime;

private String venue;
private String department;
//write the constructor
public Event(String name, int startTime, int endTime, String venue,String department) {
	this.name = name;
	this.startTime = startTime;
	this.endTime = endTime;
	
	this.venue = venue;
	this.department = department;
}
public void printEvent(){
	System.out.println("Event name: " + name);
	System.out.println("Start time: " + startTime);
	System.out.println("End time: " + endTime);
	
	System.out.println("venue: " + venue);
	System.out.println("department: " + department);
}
//checks if start time before end time
public boolean checkTime() {
	if(startTime < endTime) {
		return true;
	}
	else {
		return false;
	}
	
}
}
