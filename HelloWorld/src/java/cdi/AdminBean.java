

package cdi;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import main.Product;
import service.LoginService;
import service.ProductsManagerBean;

/**
 *
 * @author osboxes
 */
@Named
@RequestScoped
public class AdminBean {
    @EJB
    private ProductsManagerBean productsManagerBean ;
    
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    private int amount;
    
    public Product addProductToDB(){
        return productsManagerBean.createProduct(name, price, amount);
    }
    public String register(){
        return "register.xhtml";
    }
}
