package two_sum;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

  }
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> expectedIntegers = new HashMap<>();
    int[] indices = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if(expectedIntegers.containsKey(nums[i])){
        indices[0] = expectedIntegers.get(nums[i]);
        indices[1] = i;
        return indices;
      }
      else{
        expectedIntegers.put(target - nums[i], i);
      }
    }
    return indices;
  }
}
