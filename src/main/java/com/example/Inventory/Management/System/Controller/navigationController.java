package com.example.Inventory.Management.System.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class navigationController {

     @GetMapping("/allproducts")
    public String allproducts() {
        return "allproducts";
    }
    
    @GetMapping("/addinventory")
    public String addinventory() {
        return "addinventory";
    }

     @GetMapping("/updateinventory")
    public String updateinventory() {
        return "updateinventory";
    }

     @GetMapping("/purchaseorders")
    public String purchaseorders() {
        return "purchaseorders";
    }

    @GetMapping("/salesorders")
    public String saleorders() {
        return "salesorders";
    }

//  @GetMapping("/vendors")
//     public String  vendors() {
//         return "vendors";
//     }
    @GetMapping("/updationForm")
    public String  updationform() {
        return "updationForm";
    }

}
