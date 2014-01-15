package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Equation {

 private static final int MOD = 1000007;

 private boolean[] isPrime;
 private int[] multiplier;
 private List<Integer> prime;

 public static void main(String[] args) throws Exception {
	 Equation main = new Equation();
  main.run();
 }

 public void run() throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int N = Integer.parseInt(br.readLine());
  isPrime = new boolean[N + 1];
  multiplier = new int[N + 1];
  prime = new ArrayList<Integer>();
  generatePrime(N);
  generateMultiplier(N);

  long sum = 1L;
  for (int i = 1; i <= N; i++)
   if (multiplier[i] != 0) {
    sum *= (long) (2 * multiplier[i] + 1) % MOD;
    sum %= MOD;
   }
  System.out.println(sum);
 }

 public void generatePrime(int N) {
  for (int i = 2; i <= N; i++)
   if (isPrime[i] == false) {
    prime.add(i);
    for (int j = 2; j * i <= N; j++)
     isPrime[i * j] = true;
   }
 }

 public void generateMultiplier(int N) {
  // int left = 1;
  // for (int i = 1; i <= N; i++) {
  // left *= i;
  // for (int j : prime) {
  // while (left % j == 0) {
  // multiplier[j]++;
  // left /= j;
  // }
  // if (left < j) // It helps prune and save the time.
  // break;
  // }
  // }
  for (int j : prime) {
   int cpy = N;
   int e = 0;
   while (cpy != 0) {
    e += cpy / j;
    cpy /= j;
   }
   multiplier[j] = e;
  }
 }

 public boolean check(int x, int N) {

  return true;
 }

}
