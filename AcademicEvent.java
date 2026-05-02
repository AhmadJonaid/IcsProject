public class AcademicEvent extends Event {
    private String speakerName;// no need for it.
    private String academicTopic;
    private String eventFormate;
    public AcademicEvent(String name, String startTime, String endTime, Venue venue,Department department,String speakerName,String academicTopic,String eventFormat){
		super(name , startTime, endTime, venue, department);
        this.speakerName=speakerName;
        this.academicTopic=academicTopic;
        this.eventFormate=eventFormat;
    }
    public String getSpeakerName(){
        return speakerName;
    }
    public String getAcademicTopic(){
        return academicTopic;
    }
    public String getEventFormat(){
        return eventFormate;
    }
    @Override
    public void showEventInfo(){
        showBasicEventinfo();
        System.out.println("Speaker name :"+getSpeakerName() );
        System.out.println("Academic topic :"+getAcademicTopic());
        System.out.println("Event formate :"+getEventFormat());

    }



}
