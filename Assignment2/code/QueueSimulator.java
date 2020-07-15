import java.lang.*;

public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };
  private double currTime;
  private double arrivalRate;
  private double serviceTime;
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  private Event e;
  
  public double getRandTime(double arrivalRate){
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }
  
  public QueueSimulator(double aR, double servT, double simT){
  }
  
  public double calcAverageWaitingTime(){
  }
  
  public double runSimulation(){
  }
}






