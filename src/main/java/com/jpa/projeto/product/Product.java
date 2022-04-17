package com.jpa.projeto.product;

import com.jpa.projeto.order.OrderItem;
import com.jpa.projeto.order.Orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;

    @OneToMany()
    @JoinColumn(name = "product_id")
    private List<OrderItem> orderItem = new ArrayList<>();

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public Product(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
