/**
 * The main driver class for the Campus Café Ordering System.
 *
 * @author Elijah Shem Yape & Kurt Andrey Ardosa 
 * @version 1.0
 */
public class CafeApp {

    /**
     * Main entry point of the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");

        
        Beverage tempItem = new Beverage();
        tempItem.setBasePrice(-5); 
        tempItem.setBasePrice(80); // Set to valid price afterwards

        
        Beverage bev1 = new Beverage("Iced Latte", 95.0, "B-01", "L");
        Pastry pastry1 = new Pastry("Ensaymada", 45.0, "P-01", true);
        Meal meal1 = new Meal("Chicken Adobo", 110.0, "M-01", true, 1);

       
        Order order1 = new Order("1001", customer1);
        order1.addItem(bev1);
        order1.addItem(pastry1);
        order1.addItem(meal1);

       
        Pastry pastry2 = new Pastry("Cookie", 30.0, "P-02", false);
        order1.addItem(pastry2); // Should trigger limit warning message

        
        order1.printReceipt();

       
        Beverage bev2 = new Beverage();
        bev2.setName("Hot Chocolate");
        bev2.setBasePrice(80.0);
        bev2.setItemCode("B-02");
        bev2.setSize("M");

        Meal meal2 = new Meal("Beef Tapa", 130.0, "M-02", false, 0);

        Order order2 = new Order("1002", customer2);
        order2.addItem(bev2);
        order2.addItem(meal2);

       
        double sub2 = order2.computeSubtotal();
        double voucherAmt = 20.00;
        double total2 = order2.computeTotal(voucherAmt);
        
        System.out.println("Order #1002 — Ben Cruz");
        if (bev2 != null) System.out.printf("  %-38s ... %6.2f\n", bev2.getDescription(), bev2.computePrice());
        if (meal2 != null) System.out.printf("  %-38s ... %6.2f\n", meal2.getDescription(), meal2.computePrice());
        System.out.printf("  Subtotal: %.2f\n", sub2);
        System.out.printf("  Voucher: -%.2f\n", voucherAmt);
        System.out.printf("  TOTAL: %.2f\n", total2);
        
        customer2.addPoints(total2);
        System.out.println("  Loyalty points: " + customer2.getLoyaltyPoints());
    }
}