import java.util.List;

public class Task1 {
  public static void main(String[] args) {

  }


  public static long waitingTime(List<Integer> tickets, int p) {
    // Write your code here
    long timeWaited = 0;
    int alexNeed = tickets.get(p);
    tickets.remove(p);
    for (int i = 0; i < p; i++) {
      tickets.set(i, tickets.get(i) - 1);
      timeWaited++;
    }
    if(alexNeed == 1){
      return timeWaited + 1;
    }
    else{
      for (int i = 0; i < tickets.size(); i++) {
        timeWaited += Math.min(tickets.get(i), alexNeed - 1);
      }
    }
    return timeWaited + alexNeed ;
  }

}
