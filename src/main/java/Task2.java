import java.util.List;

public class Task2 {
  public static void main(String[] args) {

  }

  public static int maxDifference(List<Integer> arr) {
    // Write your code here
    int size = arr.size();
    int max = Integer.MIN_VALUE;
    int foundMinSoFar = arr.get(0);
    for (int i = 1; i < size; i++) {
      if(foundMinSoFar == arr.get(i)){
        continue;
      }
      if(arr.get(i) - foundMinSoFar > max){
        max = arr.get(i) - foundMinSoFar;
      }
      if(arr.get(i) < foundMinSoFar){
        foundMinSoFar = arr.get(i);
      }
    }
    if(foundMinSoFar == Integer.MIN_VALUE){
      return -1;
    }
    return max;
  }

  int maxDiff(int arr[], int arr_size)
  {
    int max_diff = arr[1] - arr[0];
    int min_element = arr[0];
    int i;
    for (i = 1; i < arr_size; i++)
    {
      if (arr[i] - min_element > max_diff)
        max_diff = arr[i] - min_element;
      if (arr[i] < min_element)
        min_element = arr[i];
    }
    return max_diff;
  }
}
