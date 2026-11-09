public class Pastry extends MenuItem {
    private boolean warmed;

    /**
     * Default constructor for Pastry.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor for Pastry.
     *
     * @param name      the name of the pastry
     * @param basePrice the base price
     * @param itemCode  the item code
     * @param warmed    true if warmed, false otherwise
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the final price, adding 10 if warmed using a single if statement.
     *
     * @return the computed price of the pastry
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add 10 if the pastry is warmed
        if (warmed) {
            price += 10;
        }
        return price;
    }

    /**
     * Returns the description, appending "(Warmed)" when applicable.
     *
     * @return the detailed description string
     */
    @Override
    public String getDescription() {
        String desc = super.getDescription();
        if (warmed) {
            desc += " (Warmed)";
        }
        return desc;
    }

    /**
     * Checks if the pastry is warmed.
     *
     * @return true if warmed, false otherwise
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets the warmed status.
     *
     * @param warmed the new warmed status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}