/**
 * The Primes class generates a list of prime numbers in order to shuffle
 * an array.
 */
 
import java.util.ArrayList;

public class Primes {
   public static void main(String[] args) {
      int num = 1000;
      System.out.println("Big number coprime to " + num + ": " + getCoprime(num));
   }  
   
   public static int[] getPrimes(int maxValue) {
      ArrayList<Integer> primesList = new ArrayList<Integer>();
      
      for (int i = 2; i < maxValue; i++) {
         if (isPrime(i)) {
            primesList.add(i);
         }
      }
      
      int[] primes = new int[primesList.size()];
      
      for (int i = 0; i < primesList.size(); i++) {
         primes[i] = (int)primesList.get(i);
      }
      
      return primes;
   }  
   
   public static boolean isPrime(int n) { 
      for (int i = 2; i < (int)Math.sqrt(n) + 1; i++) {
         if (n % i == 0)
            return false;
      }
      
      return true;
   }
   
   public static int getCoprime(int num) {
      int[] primes = getPrimes((int)((1 + Math.random()) * num));
      return primes[primes.length-1];
   }
}