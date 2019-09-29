package Sort;

public class Insertion {
  public static void main(String[] args) {
    int[] arr = new int[]{3,1,5,5,2,5,43,55,1,4,3,2};
    sort(arr);
    printArray(arr);
  }
  public static void sortInsertion(int[] arr){
    for (int i = 1; i < arr.length; i++) {
      int pointer = i;
      while (pointer > 0 && arr[pointer] < arr[pointer - 1]){
        int temp = arr[pointer];
        arr[pointer] = arr[pointer - 1];
        arr[pointer - 1] = temp;
        pointer--;
      }
    }
  }

  static void sort(int arr[])
  {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }
      arr[j + 1] = key;
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
