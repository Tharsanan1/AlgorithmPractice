package Sort;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = new int[]{100,100,3,1,5,5,2,5,43,55,1,4,3,2};
    bubbleSort(arr);
    printArray(arr);
  }

  public static void bubbleSort(int[] arr) {
    int lastSwappedPointer = arr.length - 1;
    int lastSwapped;
    for (int i = 0; i < arr.length - 1; i++) {
      boolean swapped = false;
      lastSwapped = lastSwappedPointer;
      for (int j = 0; j < arr.length - 1; j++) {
        if(lastSwapped == j){
          break;
        }
        else{
          if(arr[j] > arr[j+1]){
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
            lastSwappedPointer = j;
            swapped = true;
          }

        }
      }
      if(!swapped){
        break;
      }
    }
  }

  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");

    System.out.println();
  }
}
