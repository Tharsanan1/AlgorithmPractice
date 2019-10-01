package HackerRank;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
//  def largestRectangle(h):
//  s = []
//  ans = len(h)
//    h.append(0)
//
//        for i in range(len(h)):
//  left_index = i
//        while len(s) > 0 and s[-1][0] >= h[i]:
//  last = s.pop()
//  left_index = last[1]
//  ans = max(ans, h[i] * (i + 1 - last[1]))
//  ans = max(ans, last[0] * (i - last[1]))
//      s.append((h[i], left_index))
//
//      return ans
static long largestRectangle(int[] h) {
  Stack<int[]> s = new Stack<>(); // Create stack of span = [x0, x1]
  int n = h.length;
  h = Arrays.copyOf(h, n+1); // Append a sentinel to array h
  int x1;
  int maximum = 0;
  for(int x0 = 0; x0 <= n; x0++) {
    for(x1 = x0; !s.isEmpty() && h[s.peek()[0]] >= h[x0]; ) {
      int[] x = s.pop();
      x1 = x[1];
      maximum = Math.max(maximum, h[x[0]] * (x0 - x1));
    }
    s.push(new int[]{x0, x1});
  }
  return maximum;
}
}
