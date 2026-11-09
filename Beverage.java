/**
 * Represents a beverage menu item whose price depends on its size.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /**
     * Default constructor for Beverage.
     * Calls super() and sets size to "S".
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor for Beverage.
     *
     * @param name      the name of the beverage
     * @param basePrice the base price
     * @param itemCode  the item code
     * @param size      the size ("S", "M", or "L")
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes the final price based on the beverage size using an if-else-if chain.
     *
     * @return the computed price of the beverage
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equalsIgnoreCase("L")) {
            return basePrice + 25;
        } else if (size.equalsIgnoreCase("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the description including the beverage size.
     *
     * @return the detailed description string
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size.toUpperCase();
    }

    /**
     * Gets the size of the beverage.
     *
     * @return the size string
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size, accepting only "S", "M", or "L"; otherwise keeps the old value.
     *
     * @param size the desired size
     */
    public void setSize(String size) {
        // Accept only S, M, or L (case-insensitive)
        if (size != null && (size.equalsIgnoreCase("S") || size.equalsIgnoreCase("M") || size.equalsIgnoreCase("L"))) {
            this.size = size.toUpperCase();
        }
    }
}