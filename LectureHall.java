public class LectureHall extends Venue{
    private int hallNumber;
    private int seats;
    public LectureHall(String place,String Location,int capacity,int hallNumber,int seats){
        super(place,Location,capacity);
        this.hallNumber=hallNumber;
        this.seats=seats;
    }
    public int getHallNumber(){
        return hallNumber;
    }
    public int getSeats(){
        return seats;
    }
    
}
