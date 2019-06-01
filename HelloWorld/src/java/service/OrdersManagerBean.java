package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import main.Order;
import main.Product;
import main.ProductInOrder;
import org.hibernate.Query;
import org.hibernate.Session;

@Stateless
@LocalBean
public class OrdersManagerBean {

    @EJB
    private SessionFactoryService sessionFactoryService;

    public Order createOrder() {
        Order order = new Order();
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        return order;
    }

    public boolean addToOrder(int productId, int orderId, int price, int amount) {
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Product WHERE id = :productId ");
        query.setInteger("productId", productId);        
        List<?> list = query.list();
        Product product = (Product)list.get(0);
        
        if (product == null) {
            return false;
        }

        Query query1 = session.createQuery("from Order WHERE id = :orderId");
        query1.setInteger("orderId", orderId);        
        List<?> list1 = query1.list();
        Order order = (Order)list1.get(0);
        
       
       
        if (order == null) {
            return false;
        }

        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(product);
        productInOrder.setPrice(price);
        productInOrder.setAmount(amount);

        session.save(productInOrder);
        session.getTransaction().commit();

        return true;
    }
    public boolean deleteFromOrder(int productId) {
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        
//        ProductInOrder itemDelete=(ProductInOrder)session.get(ProductInOrder.class, productId);
//        session.delete(itemDelete);
//        session.getTransaction().commit();
        Query query = session.createQuery("delete from ProductInOrder WHERE product_id = :productId ");
        query.setInteger("productId", productId);        
        query.executeUpdate();
        session.getTransaction().commit();
        //getProductsInOrder(orderId);
        

        return true;
    }
    
    
    public List<Product> getProductsInOrder(int orderId) {
        Session session = sessionFactoryService.getSession();
        session.beginTransaction();
        Query query1 = session.createQuery("from Order WHERE id = :orderId");
       

        query1.setInteger("orderId", orderId);
        List<?> list1 = query1.list();
        Order order = (Order) list1.get(0);
        if (order == null) {
            return Collections.emptyList();
        }

        List<ProductInOrder> productInOrders = order.getProductInOrders();
        List<Product> result = new ArrayList<>();
        for (ProductInOrder productInOrder : productInOrders) {
            result.add(productInOrder.getProduct());
        }

        return result;
    }
}
 
