package Sort;

import java.util.Random;

public class QuickSort {
  Random random;
  public static void main(String[] args) {
    int[] arr = new int[]{3,1,4,3,1,43,1,34,3,1,43};
    QuickSort quickSort = new QuickSort();
    quickSort.sort(arr, 0, arr.length-1);
    for (int i : arr) {
      System.out.print(i + " , ");
    }
    System.out.println();
  }

  public QuickSort(){
    random = new Random();
  }

  public void sort(int[] arr, int low, int high){
    if(low < high){
      int pivot = findPivotAndPartition(arr, low, high);
      sort(arr, low, pivot-1);
      sort(arr, pivot+1, high);
    }
  }

  public int findPivotAndPartition(int[] arr, int low, int high){
    int index = random.nextInt(high-low+1) + low;
    swap(arr, index, high);
    int pivot = arr[high];
    int nextPlaceToAdd = low;
    for (int i = low; i < high; i++) {
      if(arr[i] < pivot){
        swap(arr, nextPlaceToAdd, i);
        nextPlaceToAdd++;
      }
    }
    swap(arr,nextPlaceToAdd,high);
    return nextPlaceToAdd;
  }

  public void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
