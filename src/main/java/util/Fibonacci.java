package util;

public class Fibonacci {
  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      System.out.println(fib(i));
    }

  }
  public static int getFibonacci(int n){
    if(n < 1){
      return -1;
    }
    else if(n == 1){
      return 1;
    }
    else if(n == 2){
      return 1;
    }
    else{
      int a = 1;
      int b = 1;
      for (int i = 0; i < n-2; i++) {
        int fib = a + b;
        a = b;
        b = fib;
      }
      return b;
    }
  }

  static long fib(int n) {
    double phi = (1 + Math.sqrt(5)) / 2;
    return Math.round(Math.pow(phi, n) / Math.sqrt(5));
  }
}
