import java.util.ArrayList;
import java.util.Scanner;
public class main{
  public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Event> events = new ArrayList<>();
		EventManager manager = new EventManager();
		ArrayList<Department> departments = new ArrayList();
		ArrayList<Venue> venues = new ArrayList<>();
		boolean running = true;
		while(running) {
			System.out.println("\n===== Campus Events System =====");
		System.out.println("1. Add Event");
		System.out.println("2. View Events");
		System.out.println("3. Find Event");
		System.out.println("4. Delete Event");
		System.out.println("5. Exit");
		int choice1 = scnr.nextInt();
		scnr.nextLine();
		if (choice1 == 1) {
			System.out.println("Enter event name: ");
			String eventName = scnr.nextLine();
			System.out.println("Enter start time, example 2026-5-10 14:30: ");
			String startTime = scnr.nextLine();
			System.out.println("Enter end time, 2026-5-10 15:30: ");
			String endTime = scnr.nextLine();
			
			System.out.println("Enter department name: ");
			String departmentName = scnr.nextLine();
			System.out.println("Enter responsible person: ");
			String person = scnr.nextLine();
			Department d = new Department(departmentName, person);
			manager.addDepartment(d);
			 System.out.println("Department added.");
			 
			System.out.println("choose venue type: ");
			System.out.println("1. Sport Area");
            System.out.println("2. Lecture Hall");
            System.out.println("3. Conference Hall");
            System.out.println("4. Public Space");
            
            int venueType = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Enter place name: ")
            String place = scnr.nextLine();
			System.out.println("Enter  location: ");
			String location = scnr.nextLine();
			System.out.println("Enter  capacity: ");
			int capacity = scnr.nextInt();
			scnr.nextLine();
			Venue venue = null;
			if(venueType == 1) {
				 System.out.print("Enter sport type for area: ");
				 String sportType = scnr.nextLine();
				 System.out.print("Is it outdoor?  true/false ");
				 boolean outdoor = scnr.nextBoolean();
				 scnr.nextLine();
				  venue = new SportArea(place, location, capacity, sportType, outdoor);
			}
			else if(venueType == 2) {
				System.out.print("Enter hall number: ");
				int hallNum = scnr.nextInt();
				System.out.print("Enter seats: ");
				int seats = scnr.nextInt();
				scnr.nextLine();
				venue = new LectureHall(place, location, capacity, hallNum, seats);
			}
			else if(venueType == 3) {
				System.out.print("Enter number of side rooms: ");
				int sideRooms = scnr.nextInt();
				System.out.print("Has audio visual? true/false ");
				boolean audioVisual = scnr.nextBoolean();
				scnr.nextLine();
				venue = new ConferenceHall(place, location, capacity, sideRooms, audioVisual);
			}
			else if (venueType == 4) {
				 System.out.print("Is it covered? true/false: ");
                 boolean covered = scnr.nextBoolean();

                 System.out.print("Needs permission? true/false: ");
                 boolean permission = scnr.nextBoolean();
                 scnr.nextLine();

                 venue = new PublicSpace(place, location, capacity, covered, permission);
			}
			if(venue == null) {
				System.out.println("Invalid venue type.");
				continue;
			}
			System.out.println("\nChoose event type:");
			System.out.println("1. Sport Event");
			System.out.println("2. Soical Event");
			System.out.println("3. Religious Event");
			System.out.println("4. Academic Event");
			System.out.println("Choose: ");
			int choice2 = scnr.nextInt();
			scnr.nextLine();
			Event event = null;
			if(choice2 == 1) {
				System.out.println("Enter sport type: ");
				String sportTypeName = scnr.nextLine();
				System.out.println("Enter number of teams: ");
				int  numberOfTeams = scnr.nextInt();
				System.out.println("Enter number of participants: ");
				int  numberOfParticipants = scnr.nextInt();
				scnr.nextLine();
				event = new SportEvent( eventName, startTime, endTime, venue,d, sportTypeName,numberOfTeams,numberOfParticipants);
                       
			}
			else if(choice2 == 2) {
				System.out.println("Enter activity type: ");
				String activityType = scnr.nextLine();
				System.out.println("Has refreshment? true/false:");
				boolean refreshment = scnr.nextBoolean();
				scnr.nextLine();
				System.out.println("Enter target audience: ");
				String targetAud = scnr.nextLine();
				event = new SoicalEvent(eventName , startTime, endTime, venue,d,activityType,refreshment,targetAud);
			}
			else if(choice2 == 3) {
				System.out.println("Enter religious activity: ");
				String religiousAct = scnr.nextLine();
				System.out.println("Gender restriction?  true/false");
				boolean genderRes = scnr.nextBoolean();
				scnr.nextLine();
				event  = new ReligiousEvent(eventName , startTime, endTime, venue,d, religiousAct, genderRes);
			}
			else if(choice2 == 4) {
				System.out.println("Enter speaker name: ");
				String speakerName = scnr.nextLine();
				System.out.println("Enter academic topic: ");
				String acedemicTopic = scnr.nextLine();
				System.out.println("Enter event format: ");
				String eventFormat = scnr.nextLine();
				event = new AcademicEvent(eventName , startTime, endTime, venue,d, speakerName, acedemicTopic, eventFormat);
			}
			if(event != null) {
				manager.addDepartment(d);
				manager.addvenue(venue);
				manager.addEvent(event);
				
			}
			else {
				System.out.println("Invalid event type.");
			}
		}
			else if(choice1 == 2) {
				manager.showEvents();
			}
			else if (choice1 == 3) {
				System.out.println("Enter event name to find: ");
				String name = scnr.nextLine();
				manager.findEvent(name);
			}
			else if (choice1 == 4) {
				System.out.println("Enter event name to delete: ");
				String del = scnr.nextLine();
				manager.deleteEvent(del);
			}
			else if(choice1 == 5) {
				running = false;
			}
			else {
				System.out.println("Invalid choice.");
			}
		}
		
		System.out.println("Program ended.");
	}
}
