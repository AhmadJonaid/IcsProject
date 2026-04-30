
public class SportEvent extends Event{
	private String sportType;
	private int numberOfTeams;
	private int numberOfParticipants;
	public SportEvent(String name, int startTime, int endTime, String venue,String department,String sportType,int numberOfTeams,int numberOfParticipants){
		super(name , startTime, endTime, venue, department);
		this.sportType = sportType;
		this.numberOfTeams = numberOfTeams;
		this.numberOfParticipants = numberOfParticipants;
	}
	//override the toString method 
	public String toString() {
		
		return "ُُEvent name: " + getName() +"\nDepartment: " + getDepartment()+  
		 "\nVenue: "+ getVenue() +"\nStart Time: " + getStartTime() + "\nEndTime: " 
				+ getEndTime()+ "\nSport type: " + sportType +  "\nNumber of teams: " 
		+ numberOfTeams +  "\nParticipants: " + numberOfParticipants;
	}
	
}
