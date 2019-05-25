/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import main.Product;
import org.hibernate.Query;
import org.hibernate.Session;

@Stateless
@LocalBean
public class ProductsManagerBean {
    @EJB
    private SessionFactoryService sessionFactoryService;
    

    public Product createProduct(String name, int price, int amount){
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
        session.save(product);
        session.getTransaction().commit();
        session.close();
        
        return product;
    }

    public List<Product> getProducts(){
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT c from Product c");       
        return query.list();
    }
}

