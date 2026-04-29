public abstract class Venue {
    private String place;
    private String Location;
    private int capacity;
    public Venue(String place,String Location,int capacity) {
        this.place=place;
        this.Location=Location;
        this.capacity=capacity;
    }
    public String getPlace(){
        return place;
    }
    public String getLocation(){
        return Location;
    }
    public int getCapacity(){
        return capacity;
    }
    public void showBasicInfo(){
        System.out.println(getPlace()+"| "+getLocation() +"| Capacity"+getCapacity());
    }
    public abstract String getType();
    public abstract void showInfo();

}
