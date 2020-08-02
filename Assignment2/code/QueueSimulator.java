import java.lang.*;

public class QueueSimulator{
  public enum Event { ARRIVAL, DEPARTURE };
  private double currTime;
  // arrivalRate stores gamma (average rate of arrival)
  private double arrivalRate;
  //serviceTime stores 1/mu (how many seconds per packet to process)
  private double serviceTime;
  // arrival and depart from buffer queue
  private double timeForNextArrival;
  private double timeForNextDeparture;
  private double totalSimTime;
  LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
  LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
  private Event e;
  
  public double getRandTime(double arrivalRate){
    // dude why are basically none of these variables used...?
    double num, time1, max=1, min=0, randNUM;
    randNUM= Math.random();
    time1= (-1/arrivalRate) * (Math.log(1-randNUM));
    //System.out.println(time1);
    return time1;
  }
  
  public QueueSimulator(double aR, double servT, double simT){
    arrivalRate = aR;
    serviceTime = servT;
    totalSimTime = simT;

    timeForNextArrival = getRandTime(arrivalRate);
    timeForNextDeparture = timeForNextArrival + serviceTime;
  }
  
  public double calcAverageWaitingTime(){
    double NumEvents = eventQueue.size(); 
    double totalWaittime = 0;
    while (!eventQueue.isEmpty()){
      Data curr = eventQueue.dequeue();
      totalWaittime += curr.departureTime - curr.arrivalTime;
    }
    return totalWaittime / NumEvents;
  }
  
  public double runSimulation(){


    while(currTime < totalSimTime){
      if(timeForNextArrival < timeForNextDeparture || buffer.isEmpty()){
        e = Event.ARRIVAL;
        currTime = timeForNextArrival;
    }else{
        e = Event.DEPARTURE;
        currTime = timeForNextDeparture;
    }

      switch(e) {
        case ARRIVAL:
// the simulator will enqueue a node into the buffer queue (which mimics the router queue) and compute timeForNextArrival
          Data newData = new Data();
          newData.setArrivalTime(currTime);
          buffer.enqueue(newData);

          
          timeForNextArrival += getRandTime(arrivalRate);
          break;
        case DEPARTURE:
        //  first node in the buffer queue is dequeued and this node is enqueued into eventQueue. The simulator then computes timeForNextDeparture.
          Data currData = buffer.dequeue();
          currData.setDepartureTime(currTime);
          eventQueue.enqueue(currData);

          timeForNextDeparture += currTime + serviceTime;
          break;
      }
    }

    return calcAverageWaitingTime();
  }
}






