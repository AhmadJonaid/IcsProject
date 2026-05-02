public class PublicSpace extends Venue {
    private boolean covered;
    private boolean permission;
    public PublicSpace(String place,String Location,int capacity,boolean covered,boolean permission){
        super(place,Location,capacity);
        this.covered=covered;
        this.permission=permission;
    }
    public boolean getCovered(){
        return covered;
    }
    public boolean getPermission(){
        return permission;
    }
    @Override
    public String getType(){
        return "PublicSpace";
    }
    @Override
    public void showInfo(){
        showBasicInfo();
        System.out.println("Type :"+getType() );
        if(getCovered()){// or just use covere:yes/no
        System.out.println("The place is covered");
        }
        else{
            System.out.println("The palce is not covered");
        }
        if(getPermission()){
            System.out.println("Permission is required");
        }
        else{
            System.out.println("Permission is not required");
        }
    }
}
