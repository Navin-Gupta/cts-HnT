package com.cts.training.bootappjpa.service;

import java.util.List;

import com.cts.training.bootappjpa.entity.Product;

public interface ProductService {

	List<Product> findAllProducts();
	Product findProductById(Integer productId);
	Product addProduct(Product product);
	Product updateProduct(Product product);
	Product deleteProduct(Integer productId);
}
