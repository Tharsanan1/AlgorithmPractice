package HackerRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoilerPlate {
  public static void main(String[] args) {

    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(System.in))) {

      int q = Integer.parseInt(bufferedReader.readLine().trim());
      int[][] queries = new int[q][2];

      for (int i = 0; i < q; i++) {
        String[] query = bufferedReader.readLine().split(" ");
        queries[i][0] = Integer.parseInt(query[0]);
        queries[i][1] = Integer.parseInt(query[1]);
      }

      //List<Integer> ans = freqQuery(queries);

      try (BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter(System.getenv("OUTPUT_PATH")))) {

//        bufferedWriter.write(ans.stream().map(Object::toString)
//            .collect(joining("\n")) + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
