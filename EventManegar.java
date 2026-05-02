import java.util.ArrayList;
import java.util.Iterator;
public class EventManegar {
    private ArrayList<Event> eventList;
    private ArrayList<Venue> venueList;
    private ArrayList<Department> departmentsList;
    public EventManegar(){
        eventList=new ArrayList<>();
        venueList=new ArrayList<>();
        departmentsList=new ArrayList<>();
    }
    public void addDepartment(Department department){
        departmentsList.add(department);
    }
    public void addvenue(Venue venue){
        venueList.add(venue);
    }
    public boolean isBefore(int[] time1, int[] time2) {// Here we will comapre between both times for new and old 
    for (int i = 0; i < time1.length; i++) {
        if (time1[i] < time2[i]) {
            return true;
        }
        else if (time1[i] > time2[i]) {
            return false;
        }
     }
     return false;
    }
    public boolean hasNoConflict(Event event){
        for(Event oldEvent: eventList ){
            if(oldEvent.getVenue().getPlace().equals(event.getVenue().getPlace())){
                if(isBefore(oldEvent.startTimeList(oldEvent.getStartTime()),event.endTimeList(event.getEndTime()))&&isBefore(event.startTimeList(event.getStartTime()),oldEvent.endTimeList(oldEvent.getEndTime()))){
                    return false;// 
                }
            }
        }
        return true;

    }
    public void addEvent(Event event){ // to add event it should not have conflicts with the previous.
        if(event.checkTime() ){
           if(hasNoConflict(event)){// check if there is no timeConflie
            eventList.add(event);
            System.out.println("Event added successfully");
           }
           else{
            System.out.println("There is conflict the event is not added");
           }
        }
        else{
            System.out.println("invalid event time");// the event end before it start
        }
        
    }
    public void showDepartments(){
        if(venueList.isEmpty()){
            System.out.println("There Is no Department");
        }
        for(Department deptartment:departmentsList){
            deptartment.printDepartment();
        }
   }
    public void showVenues(){
        if(venueList.isEmpty()){
            System.out.println("There Is no Venue");
        }
        for(Venue venue:venueList){
            venue.showInfo();
        }
    }
    public void showEvents(){
        if(eventList.isEmpty()){
            System.out.println("there is no event");
        }
        for(Event event:eventList){
            event.showEventInfo();
        }
    }
    public void findEvent(String eventName){
        boolean notFound=true;
        for(Event event:eventList){
            if(event.getName().equals(eventName)){
                event.showEventInfo();
                notFound=false;
                break;
            }
        }
        if(notFound){
            System.out.println(eventName+" not found");
        }
    }
    public void deleteEvent(String eventName){
        boolean notfound=true;
        Iterator<Event> eventIterator=eventList.iterator();
        while(eventIterator.hasNext()){
            Event event=eventIterator.next();
            if(event.getName().equals(eventName)){
                eventIterator.remove();
                notfound=false;
                break;
            }
        }
        if(notfound){
            System.out.println(eventName+" not found");
        }
    }
}
