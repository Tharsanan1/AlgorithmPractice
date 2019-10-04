package DesignPattern;

public class StrategyPattern {
  public static void main(String[] args) {
    int[] arr = new int[10];
    // add values to array;
    Client client = new Client(arr);

    // some implementation and decide which sort we are going to use.
    // if(some condition){
      client.setSortingStrategy(new DivideAndConquerSort());

    //}
    // else{
      client.setSortingStrategy(new LinearSort());
    // }
    client.sort();

    // even we create a new sorting algorithm which can be easily used in this client class to sorting.
  }

}

class Client{
  int[] arr;
  SortingStrategy sortingStrategy;
  public Client(int[] arr){
    this.arr = arr;
  }

  public void sort(){
    sortingStrategy.sort(arr);
  }

  public void setSortingStrategy(SortingStrategy sortingStrategy) {
    this.sortingStrategy = sortingStrategy;
  }
}

interface SortingStrategy{
  void sort(int[] arr);
}

class DivideAndConquerSort implements SortingStrategy{
  @Override
  public void sort(int[] arr) {
    //implementation
  }
}

class LinearSort implements SortingStrategy{

  @Override
  public void sort(int[] arr) {
    // implementation
  }
}
