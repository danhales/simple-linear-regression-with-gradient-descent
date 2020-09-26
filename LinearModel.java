/**
 * The LinearModel class is my little sandbox for experimenting with gradient descent.
 * It's a simple linear model: it has a slope (m) and an intercept (b).
 * This model is capable of 
 */

public class LinearModel {
   /** The slope of the line */
   private double m;
   /** The y-intercept of the line */
   private double b;
   
   /**
    * No-arg constructor randomizes the values for m and b to be between 0 and 1.
    */
   public LinearModel() {
      this.m = Math.random();
      this.b = Math.random();
   }
   
   /**
    * Constructor accepts a slope and a y-intercept.
    * @param m the slope of the line
    * @param b the y-intercept of the line
    */
   public LinearModel(double m, double b) {
      this.m = m;
      this.b = b;
   }
   
   /**
    * StochasticGradientDescent trains the model on the entire dataset.
    * Splitting should occur before the data is passed, for validation.
    * It returns an array containing {m, b}.
    * Algorithm terminates after using every data point. Overridden version
    * will terminate once predictions are within a specific threshold of each
    * other.
    * @param x an array of doubles (x-values)
    * @param y an array of doubles (y-values)
    * @param learningRate the learning rate (should be > 0)
    * @param verbose prints current values of m and b after each iteration if 
             true; nothing prints if false.
    */
   public double[] stochasticGradientDescent(double[] x, double[] y, 
                                             double learningRate, int numEpochs,
                                             int verbose) {
      // get a coprime number to "shuffle" the array by skipping a randomized
      // number of elements each time
      int skipSize = Primes.getCoprime(x.length);
      
      // get our first index
      int index = skipSize % x.length;
      
      // to hold the gradient
      double[] gradient;
      
      for (int epoch = 0; epoch < numEpochs; epoch++) {
         if (verbose == 1) {
            System.out.println(epoch);
         }
         
         for (int i = 0; i < x.length; i++) {
            // get the gradient
            gradient = currentGradient(x[index], y[index]);
            
            // take a step in the right direction
            step(-learningRate * gradient[0], -learningRate * gradient[1]);
            
            if (verbose == 2) {
               System.out.printf("Epoch %d, (%.3f, %.3f) %s\n", 
                                 epoch,
                                 x[index], 
                                 y[index], 
                                 this.toString());
            }
            
            // jump to the next pseudorandomly-selected value
            index = (index + skipSize) % x.length;
         } 
      } 
      
      return new double[] {m, b};
   }
   
   /**
    * Returns the gradient of the error function as an array of two doubles.
    * { partial error / partial m, partial error / partial b }.
    * @param x the x-value where we want to evaluate the gradient.
    * @param y the actual y-value for the given x-value.
    * @return the gradient as an array {del error / del m, del error / del b}
    */
   public double[] currentGradient(double x, double y) {
      return new double[] {2 * error(x,y) * x, 2 * error(x,y) };
   }
   
   /**
    * error computes the error (y-yhat) at the given value of x.
    * @param x the x-value to evaluate the linear model at
    * @param y the actual y-value corresponding to this data point
    * @return the squared difference of the prediction and the actual value 
    */
   public double error(double x, double y) {
      return predict(x)-y;
   }
   
   /**
    * returns the squared error (y-yhat)^2
    * @param x the x-value to evaluate the linear model at
    * @param y the actual y-value corresponding to this data point
    * @return the squared error
    */
   public double squaredError(double x, double y) {
      return Math.pow(error(x,y), 2);
   }
   
   /**
    * predict takes an x-value (a real number) and predicts the y-value.
    * @param x a real number where the line will be evaluated
    * @return m * x + b
    */
   public double predict(double x) {
      return this.m * x + this.b;
   }
   
   /**
    * step method takes values to be added onto m and b and updates the
    * function's parameters accordingly.
    * @param mStep the value to be added onto m
    * @param bStep the value to be added onto b
    */
   public void step(double mStep, double bStep) {
      this.m += mStep;
      this.b += bStep;
   }
   
   // Setters, getters, and overridden version of Object methods
   
   /**
    * getB returns the value in b
    * @return the y-intercept of the line
    */
   public double getB() {
      return this.b;
   }
   
   /**
    * getM returns the value in m
    * @return the slope of the line
    */
   public double getM() {
      return this.m;
   }
   
   /**
    * setB sets the value in b.
    * @param b the y-intercept to be set.
    */
   public void setB(double b) {
      this.b = b;
   }
   
   /**
    * setM sets the value in m.
    * @param m the slope of the line.
    */
   public void setM(double m) {
      this.m = m;   
   }
    
   /**
    * The toString method outputs the equation of the line. That is,
    * y = mx + b.
    * @return a String representation of the LinearModel's equation
    */
   @Override
   public String toString() {
      return "y = " + m + "x + " + b;
   }
}