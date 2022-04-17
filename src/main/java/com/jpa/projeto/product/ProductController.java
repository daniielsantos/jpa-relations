package com.jpa.projeto.product;

import com.jpa.projeto.order.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private ProductService productService;
    private OrdersService ordersService;

    @Autowired
    public ProductController(ProductService productService, OrdersService ordersService) {
        this.productService = productService;
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
