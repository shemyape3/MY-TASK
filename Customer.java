/**
 * Represents a café customer placing an order, tracking student status and loyalty points.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor for Customer.
     */
    public Customer() {
        this.name = "Guest";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Overloaded constructor taking a name.
     *
     * @param name the customer's name
     */
    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Overloaded constructor taking name and student status.
     *
     * @param name    the customer's name
     * @param student true if student, false otherwise
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points the points to add
     */
    public void addPoints(int points) {
        if (points > 0) {
            this.loyaltyPoints += points;
        }
    }

    /**
     * Overloaded method: adds 1 point for every 50 pesos spent.
     *
     * @param amountSpent the total amount spent on an order
     */
    public void addPoints(double amountSpent) {
        int earnedPoints = (int) (amountSpent / 50.0);
        addPoints(earnedPoints);
    }

    /**
     * Gets the customer's name.
     *
     * @return the name string
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the customer is a student.
     *
     * @return true if student, false otherwise
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the student status.
     *
     * @param student the new student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the current loyalty points.
     *
     * @return the loyalty points count
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets loyalty points, ensuring they never become negative.
     *
     * @param loyaltyPoints the new loyalty points value
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Ensure loyaltyPoints never become negative
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}