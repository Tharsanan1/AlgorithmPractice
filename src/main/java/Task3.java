import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task3 {
  public static void main(String[] args) {

  }
  public static int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
    HashMap<Integer, Node> mapToNode = new HashMap<>();
    for (int i = 0; i < gTo.size(); i++) {
      if(mapToNode.containsKey(i)){
        int finalGoTo = gTo.get(i);
        int finalWeight = gWeight.get(i);
        mapToNode.computeIfPresent(i, (key, val) -> {
          val.pathTo.putIfAbsent(finalGoTo, finalWeight);
          return val;
        });
      }
      else{
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putIfAbsent(gTo.get(i), gWeight.get(i));
        mapToNode.putIfAbsent(i, new Node(i ,temp));
      }
    }
    for (int i = 0; i < gNodes; i++) {
      if(mapToNode.containsKey(i)) {
        for (int j = 0; j < gNodes; j++) {
          if (!mapToNode.get(i).pathTo.containsKey(j) && i != j) {
            if(mapToNode.containsKey(j)){
              if(!mapToNode.get(j).pathTo.containsKey(i)){
                mapToNode.get(i).pathTo.put(j, 1);
              }
            }
            else{
              mapToNode.get(i).pathTo.put(j, 1);
            }
          }
        }
      }
      else{
        mapToNode.put(i, new Node(i, new HashMap<>()));
        for (int j = 0; j < gNodes; j++) {
          if(i == j){
            continue;
          }
          if(mapToNode.containsKey(j)){
            if(!mapToNode.get(j).pathTo.containsKey(i)){
              mapToNode.get(i).pathTo.put(j, 1);
            }
          }
          else{
            mapToNode.get(i).pathTo.put(j, 1);
          }
        }
      }
    }
    List<Integer> traversed = new ArrayList<>();
    traversed.add(0);
    return recursiveSearch(traversed, mapToNode, gNodes-1, 0);



  }

  static int recursiveSearch(List<Integer> traversed, HashMap<Integer, Node> mapToNode, int index, int from){
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < index + 1; i++) {
      if(i == index){
        if(mapToNode.get(from).pathTo.containsKey(i)) {
          return mapToNode.get(from).pathTo.get(index);
        }
      }
      if(!traversed.contains(i)){
        if(mapToNode.get(from).pathTo.containsKey(i)) {
          traversed.add(i);
          min = Math.min(min, recursiveSearch(traversed, mapToNode, index, i) + mapToNode.get(from).pathTo.get(i));
          traversed.remove(i);
        }
      }
    }
    return min;
  }

}



class Node{
  int node;
  HashMap<Integer, Integer> pathTo;

  public Node(int node, HashMap<Integer, Integer> pathTo) {
    this.node = node;
    this.pathTo = pathTo;
  }
}