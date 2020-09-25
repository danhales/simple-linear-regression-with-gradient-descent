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
    * predict takes an x-value (a real number) and predicts the y-value.
    * @param x a real number where the line will be evaluated
    */
   public double predict(double x) {
      return this.m * x + this.b;
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