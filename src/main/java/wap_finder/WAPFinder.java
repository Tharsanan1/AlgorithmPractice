package wap_finder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WAPFinder {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String firstLine = scanner.nextLine();      // get the first line and extract the details of rows and columns.
    int rows = Integer.parseInt(firstLine.split(" ")[0]);
    int cols = Integer.parseInt(firstLine.split(" ")[1]);
    RowInfo[] rowInfos = new RowInfo[rows];     // each row information will be stored in this array.
    for (int i = 0; i < rows; i++) {
      String row = scanner.nextLine();      // extract the i th row details.
      String[] rowElements = row.split(" ");
      int elementCount = Integer.parseInt(rowElements[0]);      // total letter groups
      HashMap<String, ArrayList<RangeInfo>> elementRangeMap = new HashMap<>();      // Map is used to store the Letters (W, A, P) and their indices ranges.
      int index = 0;
      for (int j = 1; j < rowElements.length; j++) {
        String element = rowElements[j];      // letter group letter.
        int repeatedOccurrence = Integer.parseInt(rowElements[j + 1]);      // letter group length;
        final RangeInfo rangeInfo = new RangeInfo(index, index + repeatedOccurrence - 1);     // range of the letter in this letter group.
        if (isEqualToWap(element)) {      // only store the values if the letter one of (W, A, P).
          elementRangeMap.computeIfPresent(element, (key, val) -> {     // if letter included in this row information already add the letter group range to the related array lis.
            val.add(rangeInfo);
            return val;
          });
          elementRangeMap.computeIfAbsent(element, (key) -> {     // if letter not included already add the letter to the map with the new array list which contains the range.
            ArrayList<RangeInfo> temp = new ArrayList<>();
            temp.add(rangeInfo);
            return temp;
          });

        }
        index += repeatedOccurrence;      // increment index for the next letter group by this letter group length;
        j++;      // skip to next letter element.
      }
      RowInfo rowInfo = new RowInfo(elementRangeMap);
      rowInfos[i] = rowInfo;      // add this row info.
    }
    System.out.println(calculateWAPs(rowInfos));
  }

  static boolean isEqualToWap(String s) {
    s = s.toUpperCase();
    return s.equals("W") || s.equals("A") || s.equals("P");
  }

  /**
   * it will return the WAP count.
   *
   * @param rowInfos
   * @return
   */
  static int calculateWAPs(RowInfo[] rowInfos) {
    String W = "W";
    int count = 0;
    for (int i = 0; i < rowInfos.length - 2; i++) {
      if (rowInfos[i].rowInfo.containsKey(W)) {     // only proceed this line if it contains letter 'W' as we need WAP in order.
        ArrayList<RangeInfo> WInfo = rowInfos[i].rowInfo.get(W);
        for (int j = 0; j < WInfo.size(); j++) {      // try all possible sub arrays for WAP.
          RangeInfo rangeInfo = WInfo.get(j);
          for (int k = i + 1; k < rowInfos.length - 1; k++) {
            for (int l = k + 1; l < rowInfos.length; l++) {
              count += calculateAPsInThisRange(rowInfos[k], rowInfos[l], rangeInfo.start, rangeInfo.end);
            }
          }

        }
      }
    }
    return count;
  }

  /**
   * it will return the count of AP occurrences within the specified range. range will be specified using start and end parameters.
   *
   * @param secondRow
   * @param thirdRow
   * @param start     first index of the range
   * @param end       last index of the range
   * @return Count of AP occurrence which are in order
   */
  static int calculateAPsInThisRange(RowInfo secondRow, RowInfo thirdRow, int start, int end) {
    String A = "A";
    int count = 0;
    if (secondRow.rowInfo.containsKey(A)) {
      ArrayList<RangeInfo> AInfo = secondRow.rowInfo.get(A);
      for (int i = 0; i < AInfo.size(); i++) {
        RangeInfo rangeInfo = AInfo.get(i);
        if (rangeInfo.start > end) {
          break;
        } else if (rangeInfo.end < start) {
          continue;
        } else {
          RangeInfo indicesRangeOfA = findOverlapIndices(start, rangeInfo.start, end, rangeInfo.end);
          count += calculatePsInThisRange(thirdRow, indicesRangeOfA.start, indicesRangeOfA.end);
        }
      }
    }
    return count;
  }

  /**
   * it will return the count of P s found in the specified range. range will be specified using start and end parameters.
   *
   * @param thirdRow row in which we need to search for Ps count in the specified range.
   * @param start    first index of the range
   * @param end      last index of the range
   * @return count of Ps which are in the specified range.
   */
  static int calculatePsInThisRange(RowInfo thirdRow, int start, int end) {
    String P = "P";
    int count = 0;
    if (thirdRow.rowInfo.containsKey(P)) {
      ArrayList<RangeInfo> BInfo = thirdRow.rowInfo.get(P);
      for (int i = 0; i < BInfo.size(); i++) {
        RangeInfo rangeInfo = BInfo.get(i);
        if (rangeInfo.start > end) {
          break;
        } else if (rangeInfo.end < start) {
          continue;
        } else {
          RangeInfo indicesRangeOfB = findOverlapIndices(start, rangeInfo.start, end, rangeInfo.end);
          count += indicesRangeOfB.end - indicesRangeOfB.start + 1;
        }
      }
    }
    return count;
  }

  /**
   * will return the overlap index range.
   *
   * @param start1
   * @param start2
   * @param end1
   * @param end2
   * @return
   */
  static RangeInfo findOverlapIndices(int start1, int start2, int end1, int end2) {
    if (start1 <= start2) {
      if (end1 <= end2) {
        return new RangeInfo(start2, end1);
      } else {
        return new RangeInfo(start2, end2);
      }
    } else {
      if (end1 >= end2) {
        return new RangeInfo(start1, end2);
      } else {
        return new RangeInfo(start1, end1);
      }
    }
  }


}

/**
 * to specify the range of indices we can use this class.
 */
class RangeInfo {
  int start;
  int end;

  public RangeInfo(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

/**
 * this class will be used to store the details of the row.
 */
class RowInfo {
  HashMap<String, ArrayList<RangeInfo>> rowInfo;      // key <= {W, A, P}, value = list of ranges of the letter key.

  public RowInfo(HashMap<String, ArrayList<RangeInfo>> rowInfo) {
    this.rowInfo = rowInfo;
  }
}
