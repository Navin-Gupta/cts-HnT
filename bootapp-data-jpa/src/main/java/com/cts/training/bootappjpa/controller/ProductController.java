package com.cts.training.bootappjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.bootappjpa.entity.Product;
import com.cts.training.bootappjpa.exception.ProductErrorResponse;
import com.cts.training.bootappjpa.exception.ProductNotFoundException;
import com.cts.training.bootappjpa.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	private ProductService service;
	
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = this.service.findAllProducts();
		ResponseEntity<List<Product>> response =
				new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> findById(@PathVariable Integer productId){
		/*try {
			return this.service.findProductById(productId);
		}
		catch(ProductNotFoundException ex) {
			
		}*/
		Product product = this.service.findProductById(productId);
		ResponseEntity<Product> response =
				new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> add(@RequestBody Product product){
		Product productRes = this.service.addProduct(product);
		ResponseEntity<Product> response =
				new ResponseEntity<Product>(productRes, HttpStatus.OK);
		return response;
	}

	
	@PutMapping("/products")
	public ResponseEntity<Product> update(@RequestBody Product product){
		Product productRes = this.service.updateProduct(product);
		ResponseEntity<Product> response =
				new ResponseEntity<Product>(productRes, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<Product> delete(@PathVariable Integer productId){
		Product product = this.service.deleteProduct(productId);
		ResponseEntity<Product> response =
				new ResponseEntity<Product>(product, HttpStatus.OK);
		return response;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ProductErrorResponse> productNotFoundExceptionHandler(ProductNotFoundException ex) {
		ProductErrorResponse error = 
				new ProductErrorResponse(ex.getMessage(), 
										 HttpStatus.NOT_FOUND.value(),
										 System.currentTimeMillis());
		ResponseEntity<ProductErrorResponse> response =
				new ResponseEntity<ProductErrorResponse>(error, HttpStatus.NOT_FOUND);
		return response;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProductErrorResponse> ExceptionHandler(Exception ex) {
		ProductErrorResponse error = 
				new ProductErrorResponse(ex.getMessage(), 
										 HttpStatus.BAD_REQUEST.value(),
										 System.currentTimeMillis());
		ResponseEntity<ProductErrorResponse> response =
				new ResponseEntity<ProductErrorResponse>(error, HttpStatus.NOT_FOUND);
		return response;
	}
}
