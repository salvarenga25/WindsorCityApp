import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Event {
    private String adescrip;
    Date adate = new Date();

    public Event(Date anodate, String adescrip){
        adate = anodate;
        this.adescrip = adescrip;

    }

    public void formatDate(){
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      //  String formattedDate = adate.format(date_format);

    }

    /*String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
    DateTimeFormatter myFormatObj DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);*/
}
