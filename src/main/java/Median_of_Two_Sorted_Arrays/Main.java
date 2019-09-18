package Median_of_Two_Sorted_Arrays;

public class Main {
  public static void main(String[] args) {
    String s = "2323";
    int[] arr1 = {1, 2};
    int[] arr2 = new int[]{};
    System.out.println(findMedianSortedArrays(arr1, arr2));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalSize = nums1.length + nums2.length;
    int medianIndex = totalSize / 2;
    boolean isOdd = totalSize % 2 == 1;
    if (isOdd) {
      medianIndex++;
    }
    int index1 = 0;
    int index2 = 0;
    int count = 1;
    boolean isFirstArray = true;
    boolean searchOnFirst = true;
    boolean foundEmpty = false;
    int firstVal;
    int secondVal;
    while (true) {
      if (nums1.length == index1) {
        firstVal = 2147483647;
      } else {
        firstVal = nums1[index1];
      }
      if (nums2.length == index2) {
        secondVal = 2147483647;
      } else {
        secondVal = nums2[index2];
      }
      if (firstVal <= secondVal) {
        if (count == medianIndex) {
          index1++;
          break;
        }
        index1++;
      } else {
        if (count == medianIndex) {
          isFirstArray = false;
          index2++;
          break;
        }
        index2++;
      }
      count++;
    }
    if (nums1.length == index1) {
      firstVal = 2147483647;
    } else {
      firstVal = nums1[index1];
    }
    if (nums2.length == index2) {
      secondVal = 2147483647;
    } else {
      secondVal = nums2[index2];
    }

    if (!isOdd) {
      if (firstVal <= secondVal) {
        if (isFirstArray) {
          return (nums1[index1 - 1] + nums1[index1]) / 2.0;
        } else {
          return (nums2[index2 - 1] + nums1[index1]) / 2.0;
        }
      } else {
        if (isFirstArray) {
          return (nums1[index1 - 1] + nums2[index2]) / 2.0;
        } else {
          return (nums2[index2 - 1] + nums2[index2]) / 2.0;
        }
      }
    } else {
      if (isFirstArray) {
        return nums1[index1 - 1];
      } else {
        return nums2[index2 - 1];
      }

    }
  }
}
