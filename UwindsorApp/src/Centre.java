public class Centre {
    private String location;
    private String name;


    public Centre(String alocation, String aname){
        location = alocation;
        name = aname;
    }
    public void setLocation(String alocation){
        location = alocation;
    }
    public void setName(String aName){
        name=aName;
    }

    public String getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }
}
