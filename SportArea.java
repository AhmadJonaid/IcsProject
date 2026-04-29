public class SportArea extends Venue{
    private String sportType;
    private boolean outdoor;
    public SportArea(String place,String Location,int capacity,String sportType,boolean outdoor){
        super(place,Location,capacity);
        this.sportType=sportType;
        this.outdoor=outdoor;
    }
    public String getSportType(){
        return sportType;
    }
    public boolean getOutdoor(){
        return outdoor;
    }
    @Override
    public String getType(){
        return "SportArea";
    }
    @Override
    public void showInfo(){
        showBasicInfo();
        System.out.println("Sport type |"+getSportType());
        if(getOutdoor()){
        System.out.println("Area type: "+"Outdoor");
        }
        else{
            System.out.println("Area type: "+"Indoor");
        }
    }
}
