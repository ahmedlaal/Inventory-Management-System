package com.example.Inventory.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.Entity.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {
    // You can define custom query methods here if needed
}
