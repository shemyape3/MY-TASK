/**
 * Represents an abstract menu item in the campus café.
 * Serves as the parent class for all specific food and beverage items.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor for MenuItem.
     * Sets name to "Unnamed Item", basePrice to 0.0, and itemCode to "N/A".
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor for MenuItem.
     *
     * @param name      the name of the item
     * @param basePrice the base price of the item
     * @param itemCode  the unique code of the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of the menu item.
     * Implemented by subclasses to handle item-specific pricing rules.
     *
     * @return the computed price
     */
    public abstract double computePrice();

    /**
     * Returns a description string containing the name and item code.
     *
     * @return the item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the name of the item.
     *
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the new item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the base price of the item.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price, rejecting values below 0 using an if-else statement.
     *
     * @param basePrice the new base price
     */
    public void setBasePrice(double basePrice) {
        // Reject negative prices and print an error message
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the unique item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the unique item code.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}