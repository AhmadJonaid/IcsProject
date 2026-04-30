
public abstract class Event {
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
public String getName() {
	return name;
}
public int getStartTime() {
	return startTime;
}
public int getEndTime() {
	return endTime;
}
public String getVenue() {
	return venue;
}
public String getDepartment() {
	return department;
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
public abstract String toString();
}


