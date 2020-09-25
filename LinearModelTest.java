/**
 * The LinearModelTest class test-drives all of the linear models methods.
 */
 
public class LinearModelTest {
   public static void main(String[] args) {
      testConstructors();
      testPredict();
   }
   
   public static void testConstructors() {
      System.out.println("Testing the no-arg constructor.");
      LinearModel lm = new LinearModel();
      System.out.println(lm);
      
      System.out.println("\nTesting the constructor with args m = 5 and b = -2.");
      lm = new LinearModel(5, -2);
      System.out.println(lm);
      System.out.println();
   }
   
   public static void testPredict() {
      System.out.println("Creating a LinearModel with m = 5 and b = -2.");
      LinearModel lm = new LinearModel(5, -2);
      
      System.out.println("Evaluating " + lm + " at x = 10.");
      System.out.println(lm.predict(10));
   }  
}