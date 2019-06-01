/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdi;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import main.Order;
import main.Product;
import service.OrdersManagerBean;
import service.ProductsManagerBean;

@Named
@SessionScoped
public class OrderBean implements Serializable{
    @EJB
    private OrdersManagerBean ordersManagerBean;
    
    @EJB
    private ProductsManagerBean productsManagerBean;
    private Product selectedProduct;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    private Order order;
    private String name;
    private int quantity;
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public List<Product> getProductsInOrder(){
        if(order == null){
            return Collections.emptyList();
        }

        return ordersManagerBean.getProductsInOrder(order.getId());
    }
    public void addProduct(Product product){
        createOrder();
        if(order == null){
            return;
        }
        ordersManagerBean.addToOrder(product.getId(),order.getId(),product.getPrice(),1);
    }
    public boolean deleteProduct(Product product){
        if(order == null){
            return false;
        }
        ordersManagerBean.deleteFromOrder(product.getId());
        return true;
    }
    public void createOrder(){
        if(order == null){
            order = ordersManagerBean.createOrder();
        }
    }
    public List<Product> getProducts(){
        return productsManagerBean.getProducts();
    }
    public boolean redirec(){
        return true;
    }
    public boolean redirecS(){
        return true;
    }
    public boolean redirecStart(){
        return true;
    }
    
    
}
