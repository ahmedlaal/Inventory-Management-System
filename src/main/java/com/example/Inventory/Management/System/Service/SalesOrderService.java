package com.example.Inventory.Management.System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventory.Management.System.Entity.SalesOrders;
import com.example.Inventory.Management.System.Repository.SalesOrderRepository;

import java.util.List;

@Service
public class SalesOrderService implements SalesOrdersInterface{

    private final SalesOrderRepository salesOrderRepository;

    @Autowired
    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }
    @Override
    public List<SalesOrders> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }

    @Override
    public SalesOrders getSalesOrderById(Integer id) {
        return salesOrderRepository.findById(id).orElse(null);
    }
    @Override
    public SalesOrders createSalesOrder(SalesOrders salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }

    @Override
    public SalesOrders updateSalesOrder(Integer id, SalesOrders updatedSalesOrder) {
        if (salesOrderRepository.existsById(id)) {
            updatedSalesOrder.setSalesNumber(id);
            return salesOrderRepository.save(updatedSalesOrder);
        }
        return null;
    }
    @Override
    public boolean deleteSalesOrder(Integer id) {
        if (salesOrderRepository.existsById(id)) {
            salesOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

