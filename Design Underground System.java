1396. Design Underground System

An underground railway system is keeping track of customer travel times between different stations. 
They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation to endStation 
that happened directly, meaning a check in at startStation followed by a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the time it takes to
travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation before 
getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer 
checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.

 
// Solution 
  
  /* Approach 1 */

class UndergroundSystem {
  private Map<Integer, Pair<String, Integer>> checkIns = new HashMap<>();
  private Map<Pair<String, String>, int[]> times = new HashMap<>();
  
  public void checkIn(int id, String stationName, int t) {
    checkIns.put(id, new Pair(stationName, t));
  }
  
  public void checkOut(int id, String stationName, int t) {
    var startStation = checkIns.get(id).getKey();
    var startTime = checkIns.get(id).getValue();
    checkIns.remove(id);

    var pair = new Pair(startStation, stationName);
    var totalTime = times.containsKey(pair) ? times.get(pair)[0] : 0;
    var dataPoints = times.containsKey(pair) ? times.get(pair)[1] : 0;

    times.put(pair, new int[] {totalTime + t - startTime, dataPoints + 1});
  }
  
  public double getAverageTime(String startStation, String endStation) {
    var pair = new Pair(startStation, endStation);

    return (double) times.get(pair)[0] / times.get(pair)[1];
  }
}



/* Approach 2 */


/* class CheckIn {
  public String stationName;
  public int time;
  public CheckIn(String stationName, int time) {
    this.stationName = stationName;
    this.time = time;
  }
}

class CheckOut {
  public int numTrips;
  public int totalTime;
  public CheckOut(int numTrips, int totalTime) {
    this.numTrips = numTrips;
    this.totalTime = totalTime;
  }
}

class UndergroundSystem {
  public void checkIn(int id, String stationName, int t) {
    checkIns.put(id, new CheckIn(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    final CheckIn checkIn = checkIns.get(id);
    checkIns.remove(id);
    final String route = checkIn.stationName + "->" + stationName;
    checkOuts.putIfAbsent(route, new CheckOut(0, 0));
    ++checkOuts.get(route).numTrips;
    checkOuts.get(route).totalTime += t - checkIn.time;
  }

  public double getAverageTime(String startStation, String endStation) {
    final CheckOut checkOut = checkOuts.get(startStation + "->" + endStation);
    return checkOut.totalTime / (double) checkOut.numTrips;
  }

  private Map<Integer, CheckIn> checkIns = new HashMap<>();  // {id: (stationName, time)}
  private Map<String, CheckOut> checkOuts = new HashMap<>(); // {route: (numTrips, totalTime)}
}


 */

