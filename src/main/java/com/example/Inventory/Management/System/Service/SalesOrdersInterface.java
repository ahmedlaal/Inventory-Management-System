package com.example.Inventory.Management.System.Service;

import java.util.List;

import com.example.Inventory.Management.System.Entity.SalesOrders;

public interface SalesOrdersInterface {

    public List<SalesOrders> getAllSalesOrders();
    public SalesOrders getSalesOrderById(Integer id);
    public SalesOrders createSalesOrder(SalesOrders salesOrder);
    public SalesOrders updateSalesOrder(Integer id, SalesOrders updatedSalesOrder);
    public boolean deleteSalesOrder(Integer id);
}
