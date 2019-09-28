package HackerRank.Arrays.minimum_swap;

public class MinimumSwap {
  public static void main(String[] args) {
    int[] arr = new int[]{2,3,1,4,5};
    System.out.println(minimumSwaps(arr));
  }
  static int minimumSwaps(int[] arr) {
    int count = 0;
    for(int i = 0; i < arr.length; i++){
      while(arr[i] != i+1){
        // swap(arr[i] - 1, i);
        int temp = arr[i];
        arr[i] = arr[temp - 1];
        arr[temp - 1] = temp;
        count ++;
      }
    }
    return count;
  }

  static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
