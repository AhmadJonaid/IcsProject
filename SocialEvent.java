public class SocialEvent extends Event{
private String  activityType;
private boolean hasRefreshments;
private String targetAudience;
public SocialEvent(String name, String startTime, String endTime, Venue venue,Department department, String activityType, boolean hasRefreshments, String targetAudience) {
	super(name , startTime, endTime, venue, department);
	this.activityType = activityType;
	this.hasRefreshments = hasRefreshments;
	this.targetAudience = targetAudience;
}
public String getActivityType(){
    return activityType;
}
public boolean getHasRefreshments(){
    return hasRefreshments;
}
public String getTargetAudience(){
    return targetAudience;
}
//overriding the toString method
@Override
public void showEventInfo() {
	showBasicEventinfo();
    System.out.println("Activity type :"+getActivityType());
    if(hasRefreshments){
     System.out.println("Refreshments Avilibilty: Avilible");
    }
    else{
        System.out.println("Refreshments Avilibilty : Not avilible");
    }
    System.out.println("Targted audience :"+ getTargetAudience());
 }
}
