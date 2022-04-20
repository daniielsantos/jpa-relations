package com.jpa.projeto.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public List<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    public void saveOrder(Orders orders) {
        ordersRepository.save(orders);
    }

    public void deleteOrder(Long orderId) {
        Orders orders = ordersRepository.findById(orderId).orElseThrow(() -> new IllegalStateException("Not found"));
        ordersRepository.delete(orders);
    }

    public List<Orders> findByName(String clientName) {
        return ordersRepository.findByClientNameIgnoreCase(clientName);
    }
}
