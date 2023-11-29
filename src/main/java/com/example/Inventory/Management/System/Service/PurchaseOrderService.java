package com.example.Inventory.Management.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventory.Management.System.Entity.PurchaseOrder;
import com.example.Inventory.Management.System.Repository.PurchaseOrderRepo;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepo purchaseOrderRepository;

    @Autowired
    public PurchaseOrderService(PurchaseOrderRepo purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    // You can add other methods as needed (update, delete, findById, etc.)
}
