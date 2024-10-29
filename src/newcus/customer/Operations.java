//keep for now
package newcus.customer;

public interface Operations {
    void addCustomer(Customer customer);
    void deleteCustomer(int cid);
    void updateCustomer(Customer customer);
    Customer searchCustomer(int cid);

    void deleteProduct(int productID);

    void searchCustomerbyID(int cid);
    void addProducts(Product product);
    void addInteraction(Interaction interaction);
    void displayProducts();
    void displayInteractions();
    void displayCustomers();

}


