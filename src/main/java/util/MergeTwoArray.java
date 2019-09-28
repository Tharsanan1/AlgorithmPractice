package util;

public class MergeTwoArray {
  public static void main(String[] args) {
    int[] arr = mergeTwoArray(new int[]{1,2,3}, new int[]{1,1});
    System.out.println(arr);
  }

  public static int[] mergeTwoArray(int[] arr1, int[] arr2){
    int size1 = arr1.length;
    int size2 = arr2.length;
    int[] arr = new int[size1 + size2];
    int i = 0;
    int j = 0;
    while(i < size1 && j < size2){
      if(arr1[i] <= arr2[j]){
        arr[i+j] = arr1[i];
        i++;
      }
      else{
        arr[i+j] = arr2[j];
        j++;
      }
    }
    for (int k = i; k < size1; k++) {
      arr[k+j] = arr1[k];
    }
    for (int k = j; k < size2; k++) {
      arr[k+i] = arr2[k];
    }
    return arr;
  }

  static void mergeInPlace(int arr[], int l, int m, int r)
  {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int [n1];
    int R[] = new int [n2];

    for (int i=0; i<n1; ++i)
      L[i] = arr[l + i];
    for (int j=0; j<n2; ++j)
      R[j] = arr[m + 1+ j];

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2)
    {
      if (L[i] <= R[j])
      {
        arr[k] = L[i];
        i++;
      }
      else
      {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1)
    {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2)
    {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
}
