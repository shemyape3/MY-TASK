/**
 * Connects a Customer to up to three MenuItem objects and handles order calculations and receipt generation.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1, item2, item3;
    private int itemCount;
    private String orderId;

    /**
     * Constructs an Order with a specific ID and customer.
     *
     * @param orderId  the unique order identifier
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
        this.item1 = null;
        this.item2 = null;
        this.item3 = null;
    }

    /**
     * Places a menu item into the first available slot (up to three items max).
     *
     * @end
     * @param item the menu item to add
     * @return true if successfully added, false if order is full
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            return false;
        }

        // Place item in the first empty slot using if-else statements
        if (itemCount == 0) {
            item1 = item;
            itemCount++;
            return true;
        } else if (itemCount == 1) {
            item2 = item;
            itemCount++;
            return true;
        } else if (itemCount == 2) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            System.out.println("Order is full. Cannot add " + item.getName() + " [" + item.getItemCode() + "].");
            return false;
        }
    }

    /**
     * Computes the subtotal by summing the polymorphic computePrice() of each non-null item.
     *
     * @return the subtotal amount
     */
    public double computeSubtotal() {
        double subtotal = 0.0;
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the total, applying a 10% student discount if applicable.
     *
     * @return the discounted total
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Apply 10% student discount if customer is a student
        if (customer != null && customer.isStudent()) {
            return subtotal * 0.90;
        }
        return subtotal;
    }

    /**
     * Overloaded computeTotal method: applies a voucher deduction, ensuring the total never goes below 0.
     *
     * @param voucher the monetary discount voucher amount
     * @return the final total after voucher
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        double finalTotal = total - voucher;
        // Total may never go below 0
        if (finalTotal < 0) {
            return 0.0;
        }
        return finalTotal;
    }

    /**
     * Prints the receipt including item descriptions, prices, subtotal, discounts/vouchers, totals, and updated loyalty points.
     */
    public void printReceipt() {
        String studentTag = (customer != null && customer.isStudent()) ? " (Student)" : "";
        System.out.println("Order #" + orderId + " — " + (customer != null ? customer.getName() : "Guest") + studentTag);

        if (item1 != null) {
            System.out.printf("  %-38s ... %6.2f\n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("  %-38s ... %6.2f\n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("  %-38s ... %6.2f\n", item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        System.out.printf("  Subtotal: %.2f\n", subtotal);

        double finalTotal;
        if (customer != null && customer.isStudent()) {
            double discount = subtotal * 0.10;
            finalTotal = subtotal - discount;
            System.out.printf("  Student discount (10%%): -%.2f\n", discount);
        } else {
            finalTotal = subtotal;
        }

        System.out.printf("  TOTAL: %.2f\n", finalTotal);

        // Update customer's loyalty points based on total spent
        if (customer != null) {
            customer.addPoints(finalTotal);
            System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
        }
        System.out.println();
    }
}