public abstract class Event {
private String name;
private String startTime;
private String endTime;
private Venue venue;// I have used the whole object
private Department department; // I have used the whole object
//write the constructor
public Event(String name, String startTime, String endTime, Venue venue,Department department) {
	this.name = name;
	this.startTime = startTime;
	this.endTime = endTime;
	
	this.venue = venue;
	this.department = department;
}
public String getName() {
	return name;
}
public String getStartTime() {
	return startTime;
}
public String getEndTime() {
	return endTime;
}
public Venue getVenue() {
	return venue;
}
public Department getDepartment() {
	return department;
}
public int[] startTimeList(String startTime){
	    String[] list=startTime.split(" ");
		String[] listDate=list[0].split("-");
		String[] listTime=list[1].split(":");
		int[] startTimeList=new int[listDate.length+listTime.length];
		for(int i=0;i<listDate.length+listTime.length;++i){
		  if (i < listDate.length) {
              startTimeList[i] = Integer.parseInt(listDate[i]);
            }
		  else {
            startTimeList[i] = Integer.parseInt(listTime[i - listDate.length]);
		  }
	}
		return startTimeList;
}
public int[] endTimeList(String endTime){
	    String[] list=endTime.split(" ");
		String[] listDate=list[0].split("-");
		String[] listTime=list[1].split(":");
		int[] endTimeList=new int[listDate.length+listTime.length];
		for(int i=0;i<endTimeList.length;++i){
		  if (i < listDate.length) {
              endTimeList[i] = Integer.parseInt(listDate[i]);
            }
		  else {
            endTimeList[i] = Integer.parseInt(listTime[i - listDate.length]);
		  }
	}
		return endTimeList;
}
//checks if start time before end time
public boolean checkTime() {
	int[] startTimeList=startTimeList(startTime);
	int[] endTimeList=endTimeList(endTime);
	for(int i=0;i<startTimeList.length;++i){
		if (startTimeList[i] < endTimeList[i]) {
            return true;
        }
        else if (startTimeList[i] >endTimeList[i]) {
            return false;
        }
	}
	return false;
	
}
public void showBasicEventinfo(){
	System.out.println("Event name : "+getName() );
	if(checkTime()){
		System.out.println("Start time :"+startTime+" End Time : "+endTime);
	}
	else{
		System.out.println("Invalid Time");
	}
	venue.showBasicInfo();
	department.printDepartment();
}
public abstract void showEventInfo();
}
