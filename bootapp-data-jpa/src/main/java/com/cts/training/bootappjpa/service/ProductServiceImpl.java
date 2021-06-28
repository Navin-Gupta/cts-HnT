package com.cts.training.bootappjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.training.bootappjpa.entity.Product;
import com.cts.training.bootappjpa.exception.ProductNotFoundException;
import com.cts.training.bootappjpa.repository.ProductRepository;

// @Component
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository repository;
	
	@Autowired
	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Product findProductById(Integer productId) {
		// TODO Auto-generated method stub
		Optional<Product> record = this.repository.findById(productId);
		/*Product product = new Product();
		if(record.isPresent())
			product = record.get();
		return product;*/
		return record.map(product -> product).orElseThrow(()->new ProductNotFoundException("Product with Id " + productId + " not found!"));
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return this.repository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return this.repository.save(product);
	}

	@Override
	public Product deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		Product product = this.findProductById(productId);
		this.repository.deleteById(productId);
		return product;
	}

}
