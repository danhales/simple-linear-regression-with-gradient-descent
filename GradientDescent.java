/**
 * GradientDescent class performs stochastic gradient descent.
 * 
 */
 
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 
public class GradientDescent {
   public static void main(String[] args) {
      double[][] data = loadData();
      
      LinearModel model = new LinearModel();
      System.out.println("Initial Model: " + model);
      model.stochasticGradientDescent(data[0], data[1], 0.0001, 1000, 1);
      
      System.out.println("Final model: " + model);
   } 
   
   public static double[][] loadData() {
      // declare the array to be returned
      double[][] data = null;;
      
      try {
         // create a path to the file
         File file = new File("data.csv");
         
         // create a scanner to read the file
         Scanner inputFile = new Scanner(file);
         
         // count the number of entries in the file so we know how big
         // data needs to be.
         int index = 0;
         
         // count the rows in the file
         while(inputFile.hasNext()) {
            inputFile.nextLine();
            index++;
         }
         
         // declare the array.
         // first row is X, second row is Y
         data = new double[2][index];
         
         // create a new scanner so we can go back to the beginning of the file
         inputFile = new Scanner(file);
         
         // reset index to zero so we can assign array values properly
         index = 0;
         
         // a String to hold the lines as they are read from the file.
         String input = "";
         
         // the file should consist of a list of ordered pairs x,y
         // one ordered pair per line. assign these to the appropriate
         // places in the array
         while (inputFile.hasNext()) {
            // read the line
            input = inputFile.nextLine();
            
            // store the x value in the first array
            data[0][index] = Double.parseDouble(input.split(",")[0]);
            
            // store the y value in the second array
            data[1][index] = Double.parseDouble(input.split(",")[1]);
            
            // increment
            index++;
         }
         
         // done working with the file
         inputFile.close();
      } catch (FileNotFoundException ex) {
         System.out.println("File not found: " + ex);
      } 
      
      return data; 
   }
}