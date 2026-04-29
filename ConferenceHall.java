public class ConferenceHall extends Venue {
    private int sideRooms;// Number of Side Rooms.
    private boolean audioVisual;// the equimpment in the room.
    public ConferenceHall(String place,String Location,int capacity,int sideRooms,boolean audioVisual){
        super(place,Location,capacity);
        this.sideRooms=sideRooms;
        this.audioVisual=audioVisual;
    }
    public int getSideRooms(){
        return sideRooms;
    }
    public boolean getAudioVisual(){
        return audioVisual;

    }
    @Override
    public String getType(){
        return "ConferenceHall";
    }
    @Override
    public void showInfo(){
        showBasicInfo();
        System.out.println("Number of Side rooms: "+getSideRooms());
        if(getAudioVisual()){
        System.out.println("There is audio visual ");
        }
        else{
            System.out.println("There is no audio visual ");
        }
    }
}
