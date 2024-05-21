package com.kerven.storagemanager.service;

import com.kerven.storagemanager.model.Product;
import com.kerven.storagemanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product){
       return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        if(productRepository.existsById(id)){ 
        Product existingProduct = productRepository.findById(id).orElse(null);
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setQuantity(product.getQuantity());
                return productRepository.save(existingProduct);
            } else {
            return null;
        }
    }
    
    public void deleteProduct(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
        }
    }
}
