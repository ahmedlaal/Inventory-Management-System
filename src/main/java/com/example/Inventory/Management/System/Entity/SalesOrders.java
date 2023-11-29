package com.example.Inventory.Management.System.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "SalesOrders")
public class SalesOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesNumber;
    private String productCode;
    private String customerName;
    private String productName;
    private String status;
    private String amount;

    // Constructors, getters, and setters
    public SalesOrders() {
    }

    public SalesOrders(String customerName, String productName, String status, String amount,String productCode) {
        this.customerName = customerName;
        this.productCode =productCode;
        this.productName = productName;
        this.status = status;
        this.amount = amount;
    }

    // Getters and Setters
    public Integer getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(Integer salesNumber) {
        this.salesNumber = salesNumber;
    }
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
