
public class BusRoute {
  private String busNumber;
  private String busStop;
  private String price;

  public BusRoute(String bNumber){
      busNumber = bNumber;
  }

  public String getBusNumber(){
      return busNumber;
  }

  public String getBusStop(){
      return busStop;
  }

  public void setBusNumber(String busNumber) {
      this.busNumber = busNumber;
  }

  public void setBusStop(String busStop) {
        this.busStop = busStop;
    }

  public String getPrice() {
        return price;
    }

  public void setPrice(String price) {
        this.price = price;
    }
}
