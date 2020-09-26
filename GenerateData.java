/**
 * GenerateData class will take a linear model with known slope and intercept
 * and generate 1000 datapoints, with noise added.
 */
 
import java.io.*;

public class GenerateData {
   public static void main(String[] args) throws FileNotFoundException {
      int numObservations = 1000;
      
      LinearModel lm = new LinearModel(-0.1, 10);
      double[] xs = new double[numObservations];
      double[] ys = new double[numObservations];
      
      for (int i = 0; i < xs.length; i++) {
         xs[i] = i * 0.1 + (0.5 - Math.random());
         ys[i] = lm.predict(xs[i]) + (1 - 2 * Math.random());
      }
      
      //printArray(xs, 10);
      
      double[][] points = zip(xs, ys);
      
      printHead(points, 10);
      printTail(points, 10);
      
      savePoints(points);
   }
   
   public static void printArray(double[] x, int rowLength) {
      
      for (int i = 1; i <= x.length; i++) {
         System.out.printf("%-8.3f", x[i-1]);
         
         if (i % rowLength == 0) {
            System.out.println();
         }
      }
   }
   
   public static void printHead(double[][] points, int numToPrint) {
      for (int i = 0; i < numToPrint; i++) {
         System.out.printf("(%-8.3f, %-8.3f)%n", points[i][0], points[i][1]);
      }
   }
   
   public static void printTail(double[][] points, int numToPrint) {
      for (int i = points.length - numToPrint - 1; i < points.length; i++) {
         System.out.printf("(%-8.3f, %-8.3f)%n", points[i][0], points[i][1]);
      }
   }
   
   public static double[][] zip(double[] x, double[] y) {
      double[][] points = new double[x.length][2];
      
      for (int i = 0; i < x.length; i++) {
         points[i][0] = x[i];
         points[i][1] = y[i];
      }
      
      return points;
   }
   
   public static void savePoints(double[][] points) throws FileNotFoundException {
      File file = new File("data.csv");
      PrintWriter outFile = new PrintWriter(file);
      
      for (int i = 0; i < points.length; i++) {
         outFile.print(String.format("%.3f,%.3f%n", points[i][0], points[i][1]));
      }
      
      outFile.close();
   }
}