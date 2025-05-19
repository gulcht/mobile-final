package com.example.store.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.business.ProductsBusiness;
import com.example.store.json.ProductsJson;
import com.example.store.model.Products;
import com.example.store.payload.ProductsPayload;
import com.example.store.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
	ProductsService productsService;
	
	@Autowired
	ProductsBusiness productsBusiness;

	public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
	
	@PostMapping("/products/save")
	public ResponseEntity<Void> saveProducts(@RequestBody ProductsPayload payload) throws Exception {
		productsBusiness.saveProducts(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductsJson> getCustomerById(@PathVariable("id") long id) throws Exception{
		return ResponseEntity.ok(productsBusiness.getCustomerId(id));
	}

	@PutMapping(value = "/products/update/{id}")
	public ResponseEntity<ProductsJson> updateProducts(@PathVariable("id") long id, @RequestBody ProductsPayload payload){
		Optional<Products> productsData = productsService.findOptionalById(id);
		if(productsData.isPresent()) {
			productsBusiness.updateProducts(productsData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
