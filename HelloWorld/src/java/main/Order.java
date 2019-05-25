
package main;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "zakaz")
public class Order implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

    @OneToMany(mappedBy = "order")
    private List<ProductInOrder> productInOrders;

    public List<ProductInOrder> getProductInOrders() {
        return productInOrders;
    }

    public void setProductInOrders(List<ProductInOrder> productInOrders) {
        this.productInOrders = productInOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    


}
