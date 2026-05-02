public class ReligiousEvent extends Event {
    private String religiousActivity;
    private boolean genderRestriction;
    public ReligiousEvent(String name, String startTime, String endTime, Venue venue,Department department,String religiousActivity,boolean genderRestriction){
        super(name , startTime, endTime, venue, department);
        this.religiousActivity=religiousActivity;
        this.genderRestriction=genderRestriction;
    }
    public String getReligiousActivity(){
        return religiousActivity;
    }
    public boolean getGenderRestriction(){
        return genderRestriction;
    }
    @Override
    public void showEventInfo(){
    System.out.println("Religious activity :"+getReligiousActivity());
    if(genderRestriction){
        System.out.println("gender restrictions : Availiable for all");
    }
    else{
        System.out.println("gender restriction : separated");
    }
    }
}
