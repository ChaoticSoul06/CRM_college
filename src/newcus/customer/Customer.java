package newcus.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int cid;
    private String cname;
    private String pno;
    private String email;
    private List<Product> productList ;

    public Customer(int cid, String cname, String email, String pno) {
        this.cid = cid;
        this.cname = cname;
        this.email = email;
        this.pno = pno;
        this.productList = new ArrayList<>();
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pno='" + pno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addProducts(Product product){
        productList.add(product);
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

