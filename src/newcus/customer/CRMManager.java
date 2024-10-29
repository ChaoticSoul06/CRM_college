package newcus.customer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRMManager implements Operations {
    private List<Customer> customerList;
    private List<Product> productList ;
    private List<Interaction> interactionList;

    public CRMManager() {
        customerList = new ArrayList<>();
        productList = new ArrayList<>();
        interactionList = new ArrayList<>();
    }
    @Override
    public void addCustomer(Customer customer){
        customerList.add(customer);
        System.out.println("Customer added successfully.");
    }
    @Override
    public void addProducts(Product product){
        productList.add(product);
        System.out.println("Products added successfully.");
    }
    @Override
    public void addInteraction(Interaction interaction){
        interactionList.add(interaction);
        System.out.println("Interaction added successfully.");
    }
    public Customer searchCustomer(int cid){
        for(Customer customer:customerList){
            if(customer.getCid() == cid){
                return customer;
            }
        }
        return null;
    }

@Override
    public void displayProducts(){
        if(productList.isEmpty()){
            System.out.println("No products to be displayed");
        }else{
            for(Product product : productList){
                System.out.println(product);
            }
        }
    }
@Override
    public void displayInteractions(){
        if(interactionList.isEmpty()){
            System.out.println("No interactions to be displayed");
        }else{
            for(Interaction interaction : interactionList){
                System.out.println(interaction);
            }
        }
    }

    @Override
    public void displayCustomers() {
        if(customerList.isEmpty()){
            System.out.println("No customers to be displayed");
        }else{
            for(Customer customer : customerList){
                System.out.println(customer);
            }
        }
    }
@Override
    public void deleteCustomer(int cid){
        Customer customer = searchCustomer(cid);
        if(customer != null){
            customerList.remove(customer);
            System.out.println("Customer deleted successfully.");
        }else{
            System.out.println("Customer not found.");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {

    }
@Override
    public void deleteProduct(int productID){
        Product productToDelete = null;
        for(Product product: productList){
            if(product.getProductID() == productID){
                productToDelete = product;
                break;
            }
        }
        if(productToDelete != null){
            productList.remove(productToDelete);
            System.out.println("Product deleted successfully.");
        }else{
            System.out.println("Product not found");
        }
    }
@Override
    public void searchCustomerbyID(int cid){
        for (Customer customer : customerList){
            System.out.println("Customer details are:" + customer);
            System.out.println("Products for this customer are:");

            for(Product product : productList){
                System.out.println(product);
            }
        }
    }


    public static void main(String[] args){
        CRMManager manager = new CRMManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1 = Add Customer, 2 = Add Product, 3 = Record Interaction, 4 = Display Customers, 5 = Display Products, 6 = Display Interactions, 7 = Delete Customer, 8 = Delete Product, 9 = Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter customer ID, name, email, and phone number:");
                    int cid = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    String cname = scanner.nextLine();
                    String email = scanner.nextLine();
                    String pno = scanner.nextLine();
                    Customer customer = new Customer(cid, cname, email, pno
                    );
                    manager.addCustomer(customer);
                    break;
                case 2:
                    System.out.println("Enter product ID, name, and price:");
                    int productID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    String proName = scanner.nextLine();
                    double price = scanner.nextDouble();
                    Product product = new Product(productID, proName, price);
                    manager.addProducts(product);
                    break;
                case 3:
                    System.out.println("Enter interaction ID, customer ID, and interaction details:");
                    int interactionId = scanner.nextInt();
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    String interactionDetails = scanner.nextLine();
                    Interaction interaction = new Interaction(interactionId, customerId, interactionDetails);
                    manager.addInteraction(interaction);
                    break;

                case 4:
                    manager.displayCustomers();
                    break;

                case 5:

                    manager.displayProducts();
                    break;

                case 6:
                    manager.displayInteractions();
                    break;

                case 7:
                    cid = scanner.nextInt();
                   manager.deleteCustomer(cid);

                case 8:
                    productID = scanner.nextInt();
                    manager.deleteProduct(productID);

            }
        }while (choice!=8);
    }



    //private int findCustomer()


}
