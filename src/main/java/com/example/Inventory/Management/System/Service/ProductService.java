package com.example.Inventory.Management.System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Inventory.Management.System.Entity.Product;
import com.example.Inventory.Management.System.Repository.repo;




@Service
public class ProductService implements ProductServiceImp {

	@Autowired
	private repo Product_repo;

	@Override
	public Product addProduct(Product e) {
		System.out.println("product"+ e);
		Product product = Product_repo.save(e);
			return product;
	}

	@Override
	public List<Product> getAllProduct() {
     List<Product> productList = Product_repo.findAll();
		System.out.println("product list: "+productList);
		return productList;
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> e = Product_repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public Product updateProduct(Product updatedProduct) {
		// Check if the product exists in the database
		Optional<Product> existingProductOptional = Product_repo.findById(updatedProduct.getId());

		if (existingProductOptional.isPresent()) {
			// If the product exists, update its details

			Product existingProduct = existingProductOptional.get();
			existingProduct.setCode(updatedProduct.getCode());
			existingProduct.setName(updatedProduct.getName());
			existingProduct.setVname(updatedProduct.getVname());
			existingProduct.setType(updatedProduct.getType());
			existingProduct.setPrice(updatedProduct.getPrice());
			existingProduct.setDetail(updatedProduct.getDetail());

			 //Save the updated product to the database
			return Product_repo.save(existingProduct);
		} else {
			// Handle the case where the product to update is not found
			return null; // Or throw an exception, depending on your business logic
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		Product product = Product_repo.findById(id).get();
		if (product != null) {
			Product_repo.delete(product);
			return true;
		}
		return false;
	}

	// public Page<Product> getProductByPaginate(int currentPage, int size) {
	// 	Pageable p = PageRequest.of(currentPage, size);
	// 	return Product_repo.findAll(p);
	// }

}