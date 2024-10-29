package newcus.customer;

public class Product {
    int productID;
    double price;
    String proName;
    public Product(int productID, String proName, double price) {
        this.productID = productID;
        this.proName = proName;
        this.price = price;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", productID=" + productID +
                ", proName='" + proName + '\'' +
                '}';
    }
}
