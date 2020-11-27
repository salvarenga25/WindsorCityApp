
import java.util.Date;

public class SpecialEvents extends Event{
    private  String name;
    private Date adate;

    public SpecialEvents(Date adate, String adescrip, String aname){
        super(adate);
        super(adescrip);
        Event masterEvent = new Event(adate, adescrip);
        name = aname;
    }

    public void setName(String aname){
        name = aname;
    }
}
