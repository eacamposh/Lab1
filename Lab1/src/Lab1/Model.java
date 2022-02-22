package Lab1;

/**
 * @author Eduardo Campos
 */

public class Model {

  public static final int INCHES_PER_FOOT = 12;
  public static final double POUNDS_PER_KG = 2.2046;
  public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
  public static final int TALL_INCHES = 67;
  public static final double THIN_POUNDS = 140.0;
  public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
  public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
  public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;


  private String firstName;
  private String lastName;
  private Integer heightInches;
  private Double weightPounds;
  private Boolean canTravel;
  private Boolean smokes;

  public Model() {
  }

  /**
   * Second Constructor
   *
   * @param firstName    First name of model
   * @param lastName     Last name of model
   * @param heightInches Height of model
   * @param weightPounds Weight of model
   * @param canTravel    Default value (false)
   * @param smokes       Default value (false)
   */
  public Model(String firstName, String lastName, Integer heightInches, Double weightPounds,
      Boolean canTravel, Boolean smokes) {
    setFirstName(firstName);
    setLastName(lastName);
    setHeightInches(heightInches);
    setWeightPounds(weightPounds);
    setCanTravel(canTravel);
    setSmokes(smokes);
  }

  /**
   * Third Constructor
   *
   * @param firstName first name of model
   * @param lastName  last name of model
   * @param height    height of model
   * @param weight    weight of model
   */
  public Model(String firstName, String lastName, Integer height, Double weight) {
    setFirstName(firstName);
    setLastName(lastName);
    setHeightInches(height);
    setWeightPounds(weight);
    setCanTravel(true);
    setSmokes(false);
  }

  /**
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   */
  public void setFirstName(String firstName) {
    if (firstName.length() >= 3 & firstName.length() <= 20) {
      this.firstName = firstName;
      //System.out.println("Stored Data! (First name)");
    } else {
      throw new IllegalArgumentException("First name must be 3-20 characters");
    }
  }

  /**
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return
   */
  public Integer getHeightInches() {
    return heightInches;
  }

  /**
   * @return
   */
  public Double getWeightPounds() {
    return weightPounds;
  }

  /**
   * @return
   */
  public Boolean getCanTravel() {
    return canTravel;
  }

  /**
   * @return
   */
  public Boolean getSmokes() {
    return smokes;
  }

  /**
   * @return
   */
  public String getHeightInFeetAndInches() {
    double heightInches = getHeightInches();
    double heightInFeetAndInches = (heightInches / (double) INCHES_PER_FOOT);
    heightInFeetAndInches = Math.round(heightInFeetAndInches * 10.0) / 10.0;
    String strHeight = Double.toString(heightInFeetAndInches);
    String[] result = strHeight.split("[.]", 0);
    if (Integer.parseInt(result[1]) == 1) {
      return result[0] + " Feet " + result[1] + " inch";
    } else {
      return result[0] + " Feet " + result[1] + " inches";
    }
  }

  /**
   * @return
   */
  public long getWeightKg() {
    double weightKg = (getWeightPounds() / POUNDS_PER_KG);
    return Math.round(weightKg);
  }

  /**
   * @param lastName
   */
  public void setLastName(String lastName) {
    if (lastName.length() >= 3 & lastName.length() <= 20) {
      this.lastName = lastName;
      //System.out.println("Stored Data! (Last name)");
    } else {
      throw new IllegalArgumentException("Last name must  be 3-20 characters ");
    }
  }

  /**
   * @param heightInches
   */
  public void setHeightInches(Integer heightInches) {
    if (heightInches >= 24 & heightInches <= 84) {
      this.heightInches = heightInches;
      //System.out.println("Stored Data! (Height)");
    } else {
      throw new IllegalArgumentException("Height must be 24-84");
    }
  }

  /**
   * @param weightPounds
   */
  public void setWeightPounds(Double weightPounds) {
    if (weightPounds >= 80 & weightPounds <= 280) {
      this.weightPounds = weightPounds;
      //System.out.println("Stored Data! (Weight)");
    } else {
      throw new IllegalArgumentException("Weight must be 80-240");
    }
  }

  /**
   * @param canTravel
   */
  public void setCanTravel(Boolean canTravel) {
    this.canTravel = canTravel;
  }

  /**
   * @param smokes
   */
  public void setSmokes(Boolean smokes) {
    this.smokes = smokes;
  }

  /**
   * @return
   */
  public int calculatePayDollarsPerHour() {
    int hourlyRate = 0;
    if (getHeightInches() > TALL_INCHES & getWeightPounds() < THIN_POUNDS) {
      hourlyRate = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
      return hourlyRate;
    }
    if (getCanTravel()) {
      hourlyRate = (BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR
          + TRAVEL_BONUS_DOLLARS_PER_HOUR);
      return hourlyRate;
    }
    if (getSmokes()) {
      hourlyRate = (BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR
          + TRAVEL_BONUS_DOLLARS_PER_HOUR) - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
      return hourlyRate;
    }
    return hourlyRate;
  }

  /**
   * @param kilograms
   */
  public void setWeight(long kilograms) {
  }

  /**
   * @param pounds
   */
  public void setWeight(double pounds) {
  }

  /**
   * @param feet
   * @param inches
   */
  public void setHeight(int feet, int inches) {
  }

  /**
   * @param inches
   */
  public void setHeight(int inches) {
  }

  public void printDetails() {
    System.out.println("Name: " + getFirstName() + " " + getLastName());
    System.out.println("Height: " + getHeightInFeetAndInches());
    System.out.println("Weight: " + getWeightKg() + " Pound");
    if (getCanTravel()) {
      System.out.println("Does travel ");
    } else {
      System.out.println("Does not travel ");
    }
    if (getSmokes()) {
      System.out.println("Does smoke");
    } else {
      System.out.println("Does not smoke");
    }
  }

  public void displayModelDetails() {
    System.out.println("Name: " + getFirstName() + " " + getLastName());
    System.out.println("Height: " + getHeightInFeetAndInches());
    System.out.println("Weight: " + getWeightKg() + " Pound");
    if (getCanTravel()) {
      System.out.println("Travels: Yep ");
    } else {
      System.out.println("Smokes: Nop ");
    }
    if (getSmokes()) {
      System.out.println("Travels: Yep");
    } else {
      System.out.println("Smokes: Nope");
    }
    System.out.println("Hourly Rate: " + calculatePayDollarsPerHour());
  }

}
