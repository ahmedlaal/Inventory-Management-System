package com.example.Inventory.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Inventory.Management.System.Entity.SalesOrders;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrders, Integer> {
    
}
