package com.example.store.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.json.ProductsJson;
import com.example.store.model.Products;
import com.example.store.payload.ProductsPayload;
import com.example.store.service.ProductsService;

@Service
public class ProductsBusiness{
     @Autowired
    ProductsService productsService;

    public ProductsJson getCustomerId(long id) {
		return ProductsJson.packJson(productsService.findById(id));
	}

    public void saveProducts(ProductsPayload productsPayload) {
		Products product = new Products(
            productsPayload.getProductName(),
            productsPayload.getPrice(),
            productsPayload.getCreatedAt()
                );
		productsService.save(product);
	}
    public void updateProducts(long id, ProductsPayload productsPayload) {
		Products productData = productsService.findById(id);
		productData.setProductName(productsPayload.getProductName());
		productData.setPrice(productsPayload.getPrice());
        productData.setCreatedAt(productsPayload.getCreatedAt());
		productsService.save(productData);
	}
}
