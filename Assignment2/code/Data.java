public class Data{
  double arrivalTime;
  double departureTime;
  public Data(){
    this.arrivalTime=0;
    this.departureTime=0;
  }
  public void setArrivalTime(double a){
    a= this.arrivalTime;
  }
  public void setDepartureTime(double d){
    d=this.departureTime;
  }
  public double getDepartureTime(){
    return this.departureTime;
  }
  public double getArrivalTime(){
    return this.arrivalTime;
  }
}