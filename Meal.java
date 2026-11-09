/**
 * Represents a rice meal menu item that can be upsized and include extra sides.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor for Meal.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor for Meal.
     *
     * @param name       the name of the meal
     * @param basePrice  the base price
     * @param itemCode   the item code
     * @param upsized    true if upsized, false otherwise
     * @param extraSides the number of extra sides ordered
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes the final price: basePrice + 20 if upsized + 12 per extra side.
     *
     * @return the computed price of the meal
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add 20 if upsized
        if (upsized) {
            price += 20;
        }
        // Add 12 for each extra side
        price += (12.0 * extraSides);
        return price;
    }

    /**
     * Returns the description detailing upsize status and number of extra sides.
     *
     * @return the detailed description string
     */
    @Override
    public String getDescription() {
        String upsizeStr = upsized ? "Upsized" : "Regular";
        return super.getDescription() + " " + upsizeStr + ", " + extraSides + " side" + (extraSides == 1 ? "" : "s");
    }

    /**
     * Checks if the meal is upsized.
     *
     * @return true if upsized, false otherwise
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets the upsized status.
     *
     * @param upsized the new upsized status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the extra sides count
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides, rejecting negative values.
     *
     * @param extraSides the number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Reject negative values using an if statement
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        }
    }
}