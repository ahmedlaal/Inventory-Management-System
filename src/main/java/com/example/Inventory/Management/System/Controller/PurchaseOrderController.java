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

import com.example.Inventory.Management.System.Entity.PurchaseOrder;
import com.example.Inventory.Management.System.Service.PurchaseOrderService;

@Controller
@RequestMapping("/api")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/purchase-orders")
    public String showPurchaseOrders(Model model) {
        model.addAttribute("purchaseOrders", purchaseOrderService.getAllPurchaseOrders());
        return "purchaseorders"; // This corresponds to the HTML file name
    }

    @PostMapping("/purchaseorders")
    public ResponseEntity<String> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        try {
            PurchaseOrder createdOrder = purchaseOrderService.createPurchaseOrder(purchaseOrder);
            return new ResponseEntity<>("Purchase Order created with ID: " + createdOrder.getPurchaseNumber(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create Purchase Order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

