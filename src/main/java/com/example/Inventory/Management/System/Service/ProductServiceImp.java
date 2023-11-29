package com.example.Inventory.Management.System.Service;

import java.util.List;

import com.example.Inventory.Management.System.Entity.Product;

public interface ProductServiceImp {
        public Product addProduct(Product emp);

	public List<Product> getAllProduct();

	public Product updateProduct(Product updatedProduct);

	public Product getProductById(int id);

	public boolean deleteProduct(int id);
}
