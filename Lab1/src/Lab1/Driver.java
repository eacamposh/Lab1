package Lab1;


public class Driver {

  public static void main(String[] args) {

    /**
     * height must be 24 to 84 inches or it won't be stored
     * weight must be 80 to 280 pounds or it won't be stored
     */
    Model m1 = new Model("Eduardo", "Campos", 50, 170.5, true, false);
    Model m2 = new Model("Tiger", "Woods", 72, 280.0, true, false);
    Model m3 = new Model("Susan", "Smith", 61, 265.0, true, false);
    System.out.println("Model 1: ");
    m1.printDetails();
    System.out.println("\nModel 2: ");
    m2.displayModelDetails();
    System.out.println("\nModel 3: ");
    m3.displayModelDetails();

  }
}
