package Sandbox;

public class Purchase {
    private String productName;
    private double price;

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    private Purchase() {

    }

    public Purchase(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}
