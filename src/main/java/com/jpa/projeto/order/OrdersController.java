package com.jpa.projeto.order;

import com.jpa.projeto.product.Product;
import com.jpa.projeto.product.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/orders")
public class OrdersController {

    private ProductService productService;
    private OrdersService ordersService;

    @Autowired
    public OrdersController(ProductService productService, OrdersService ordersService) {
        this.productService = productService;
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> getOrders() {
        return ordersService.getOrders();
    }

    @PostMapping
    public void saveOrder(@RequestBody Orders orders) {
        try {
            ordersService.saveOrder(orders);
        } catch (Exception e) {
            throw new IllegalStateException("Deu ruim "+ e);
        }
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        try {
            ordersService.deleteOrder(orderId);
        } catch (Exception e) {
            throw new IllegalStateException("Pedido nao encontrado");
        }
    }

    @GetMapping(path = "name/{clientName}")
    private List<Orders> findByName(@PathVariable String clientName) {
        return ordersService.findByName(clientName);
    }
}
