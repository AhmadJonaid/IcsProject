
public class SportEvent extends Event{
	private String sportType;
	private int numberOfTeams;
	private int numberOfParticipants;
	public SportEvent(String name, String startTime, String endTime, Venue venue,Department department,String sportType,int numberOfTeams,int numberOfParticipants){
		super(name , startTime, endTime, venue, department);
		this.sportType = sportType;
		this.numberOfTeams = numberOfTeams;
		this.numberOfParticipants = numberOfParticipants;
	}
	public String getSportType(){
		return sportType;
	}
	public int getNumberOfTeams(){
		return numberOfTeams;
	}
	public int getNumberOfParticipants(){
		return numberOfParticipants;
	}
	//override the toString method 
	@Override
	public void showEventInfo() {
		showBasicEventinfo();
		System.out.println("Sport type :"+getSportType());
		System.out.println("Teams numbers :"+getNumberOfTeams());
		System.out.println("numbers of participants :"+ getNumberOfParticipants());
	}
	
}
