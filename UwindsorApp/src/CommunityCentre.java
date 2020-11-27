import java.util.ArrayList;
public class CommunityCentre {
    private String location;
    ArrayList<Centre> centres = new ArrayList<>();
    ArrayList<Centre> AllLocations = new ArrayList<>();

    public CommunityCentre(String loc){
        location = loc;
    }

    public ArrayList<Centre> getLocations(){
        for(Centre c: AllLocations){
            if(c.getLocation().equals(location)){
                centres.add(c);
            }
            else {continue;}
        }
        return(centres);
    }

}
