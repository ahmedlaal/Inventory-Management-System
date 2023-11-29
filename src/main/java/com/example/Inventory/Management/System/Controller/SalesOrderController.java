package com.example.Inventory.Management.System.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Inventory.Management.System.Entity.SalesOrders;
import com.example.Inventory.Management.System.Repository.SalesOrderRepository;

@Controller
@RequestMapping("/api")
public class SalesOrderController {

    private final SalesOrderRepository salesOrderRepository;

    @Autowired
    public SalesOrderController(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    @GetMapping("/salesorders")
    public String getAllSalesOrders(Model model) {
        model.addAttribute("salesOrders", salesOrderRepository.findAll());
        return "salesorders"; // This will be the name of your HTML file
    }

     @PostMapping("/sales-orders")
    public ResponseEntity<String> createSalesOrder(@RequestBody SalesOrders salesOrder) {
        try {
            SalesOrders createdOrder = salesOrderRepository.save(salesOrder);
            return new ResponseEntity<>("Sales Order created with ID: " + createdOrder.getSalesNumber(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create Sales Order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
