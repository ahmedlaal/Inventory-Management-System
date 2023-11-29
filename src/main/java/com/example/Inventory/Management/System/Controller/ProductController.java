package com.example.Inventory.Management.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Inventory.Management.System.Entity.Product;
import com.example.Inventory.Management.System.Service.ProductService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/products")
public class ProductController {
     @Autowired
	private ProductService service;

    @PostMapping("/add")
	public String ProductRegister(@ModelAttribute Product e, HttpSession session,Model model) {
		service.addProduct(e);
		session.setAttribute("msg", "Product Added Sucessfully..");
		List<Product> productList = service.getAllProduct();

		model.addAttribute("products", productList);

		return "allproducts";
	}

	@GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> productList = service.getAllProduct();

		model.addAttribute("products", productList);

        return "allproducts"; // Return the name of your HTML file where the table will be displayed

	}

	@GetMapping("/edit/{id}")
public String editProduct(@PathVariable int id, Model model) {
    // Fetch the product details by ID
    Product product = service.getProductById(id);

    model.addAttribute("product", product);

    return "updationForm"; // Return the name of your HTML file for the update form
}


@PostMapping("/update")
public String updateProduct(@ModelAttribute Product e, HttpSession session,Model model) {
    // Use a method in ProductService to update the existing product
	 service.updateProduct(e);
    session.setAttribute("msg", "Data updated successfully..");
	List<Product> productList = service.getAllProduct();

	model.addAttribute("products", productList);

	return "updateinventory"; // Return the name of your HTML file where the table will be displayed

}



	@GetMapping("/UPDATE-DELETE")
	public String listALLProducts(Model model) {
		List<Product> productList = service.getAllProduct();

		model.addAttribute("products", productList);

		return "updateinventory"; // Return the name of your HTML file where the table will be displayed

	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id, HttpSession session) {

		service.deleteProduct(id);
		session.setAttribute("msg", "Data Delete Sucessfully..");
		return "redirect:/";
	}

	

}
