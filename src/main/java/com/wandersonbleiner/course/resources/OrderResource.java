package com.wandersonbleiner.course.resources;

import com.wandersonbleiner.course.entities.Order;
import com.wandersonbleiner.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll()
    {
        var Orders = service.findAll();
        return ResponseEntity.ok().body(Orders);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Order> findById(@PathVariable Long id)
    {
        var Order = service.findById(id);

        return ResponseEntity.ok().body(Order);
    }
}
