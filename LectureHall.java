public class LectureHall extends Venue{
    private int hallNumber;
    private int seats;//It should be deleted it simillar to Capacity
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
    @Override
    public String getType(){
        return "LectureHall";
    }
    @Override
    public void showInfo(){
        showBasicInfo();
        System.out.println("Type :"+getType());
        System.out.println("Hall Number: "+getHallNumber());
        System.out.println("Seats Amount :"+ getSeats());// deleted?
    }
}
