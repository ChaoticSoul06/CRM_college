package com.crm;

import java.util.Scanner;

class Customer {
    private int cid;
    private String cname;
    private String pno;



    public Customer(int cid,String pno, String cname) {
        this.cid = cid;
        this.pno = pno;
        this.cname = cname;


    }

    public String getPno() {
        return pno;
    }
    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }


    public String toString() {
        return "Customer [cid=" + cid + ", cname=" + cname + ", phone=" + pno + "]";
    }

}


class Products{
    int pid;
    String pur_date;
    String feedback;


    public Products(int pid, String pur_date, String feedback) {
        this.pid = pid;
        this.pur_date = pur_date;
        this.feedback =feedback;

    }



    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPur_date() {
        return pur_date;
    }
    public void setPur_date(String pur_date) {
        this.pur_date = pur_date;
    }
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    @Override
    public String toString() {
        return "Products [pid=" + pid + ", pur_date=" + pur_date + ", feedback="+ feedback + "]";
    }



}
//Enter customer details , product details and their feedback

public class CustomerManager {
    // operations on a list of customers and for each customer you create a product review
    private Customer[] customerList;
    private int cus_count;
    Products[][] productsList;
    private int[] pro_count;

//make arrays for number of elements= capacity and number of products
    public CustomerManager(int capacity, int numPro) {
        customerList = new Customer[capacity];
        productsList = new Products[capacity][numPro];
        pro_count = new int[capacity];//This line creates an array that can hold capacity number of integers.
        cus_count = 0;
    }


//adds customer

    public void add(Customer customer){

        if(cus_count<customerList.length){
            customerList[cus_count++] = customer;
            System.out.println("Customer added successfully.");
        }else{
            System.out.println("Customer list is full");
        }

    }

    //adds review of each product
    public void addReview(int cid, Products products){
        int cus_index = findCustomer(cid);
        if(pro_count[cus_count]<productsList.length){
            productsList[cus_index][pro_count[cus_index]] = products;
          pro_count[cus_index]++;
            System.out.println("Product added");
        }else{
            System.out.println("Product list is full");
        }

    }

    public void display(){//until list is not empty, keep displaying
        if(cus_count==0){
            System.out.println("No customer data to be displayed.");
        }else{
            for(int i=0;i<cus_count;i++){
                System.out.println(customerList[i]);
                if(pro_count[i]>0){
                    System.out.println("Products for customer" + customerList[i].getCid() + ":");
                    for(int j=0;j<pro_count[i];j++) {
                        System.out.println(productsList[i][j]);
                    }
                    }else{
                    System.out.println("Np products");
                }
            }
        }
    }


    public void delete(int cid){
        int cus_index = findCustomer(cid);
        if(cus_index!=0){
            for (int i = cus_index;i<cus_count;i++){
                customerList[i]  =customerList[i+i];
                productsList[i] = productsList[i+1];
                pro_count[i]= pro_count[i+1];

            }
        customerList[--cus_count] = null;
System.out.println("Deleted successfully");


    }
        else{
        System.out.println("Not found");
    }
}

//look for a record using the cid
    public void search(int cid) {
        int cus_index = findCustomer(cid);
        if(cus_index!=-1){
            System.out.println(customerList[cus_index]);
            for (int j = 0;j<pro_count[cus_index];j++){
                System.out.println(productsList[cus_index][j]);
            }

        } else{
                System.out.println("Not found.");
            }
        }


private int findCustomer(int cid){
        for(int i=0;i<cus_count;i++){
            if(customerList[i].getCid() == cid){
                return i;
            }
        }
        return -1;
}


    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager(5, 5);
        Scanner scanner = new Scanner(System.in);


        int choice;
        do {
            System.out.println("Enter choice. 1=add, 2=display, 3= delete, 4=search");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter cid, phone, name.");
                    int cid = scanner.nextInt();
                    scanner.nextLine();
                    String pno = scanner.nextLine();
                    String cname = scanner.nextLine();
                    Customer customer = new Customer(cid,pno, cname);
                    manager.add(customer);
                    System.out.println("Enter number of products:");
                    int numPro = scanner.nextInt();
                    for(int i=0;i<numPro;i++) {
                        System.out.println("Enter pr_id:");
                        int pid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter pur_date:");
                        String pur_date = scanner.nextLine();
                        System.out.println("Enter feedback:");
                        String feedback = scanner.nextLine();
                        Products products = new Products(pid, pur_date, feedback);
                        manager.addReview(cid,products);
                    }

                    break;
                case 2:
                    manager.display();

                    break;
                case 3:
                    //can't delete multiple products with the same cid
                    System.out.println("Enter id to be deleted:");
                    int deleteId = scanner.nextInt();
                    manager.delete(deleteId);
                    break;
                case 4:
                    System.out.println("Enter id to be searched:");
                    int searchId = scanner.nextInt();
                    manager.search(searchId);
                    break;

            }
        } while (choice != 5);
    }
}
