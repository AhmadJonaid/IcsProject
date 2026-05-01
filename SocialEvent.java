
public class SocialEvent extends Event{
private String  activityType;
private boolean hasRefreshments;
private String targetAudience;
public SocialEvent(String name, int startTime, int endTime, String venue,String department, String activityType, boolean hasRefreshments, String targetAudience) {
	super(name , startTime, endTime, venue, department);
	this.activityType = activityType;
	this.hasRefreshments = hasRefreshments;
	this.targetAudience = targetAudience;
}
//overriding the toString method
public String toString() {
	return "ُُEvent name: " + getName() +"\nDepartment: " + getDepartment()+  
			 "\nVenue: "+ getVenue() +"\nStart Time: " + getStartTime() + "\nEndTime: " 
					+ getEndTime() + "\nActivity Type: " + activityType + "\nHas Refreshments: " +
			 hasRefreshments+ "\nTarget Audience: " + targetAudience;
}

}
