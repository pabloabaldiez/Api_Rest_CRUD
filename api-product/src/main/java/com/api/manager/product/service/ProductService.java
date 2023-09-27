package com.api.manager.product.service;

import com.api.manager.product.model.Product;
import com.api.manager.product.repository.dao.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> getProductList(){

       // return (List<Product>) productDao.findAll();
        return productDao.findAll();
    }

    public Product insertProduct(Product product){

        return productDao.save(product);
    }

    public Optional<Product> getProductById(Long id) {  //Optional puede devolver null o no

        return  productDao.findById(id);
    }

    public Product updateProductById(Product request, Long id){

        Product product=productDao.findById(id).get();

        System.out.println(product.getName());
        product.setName(request.getName());
        System.out.println(product.getName());
        product.setPrice(request.getPrice());
        product.setAvaiable(request.getAvaiable());
        product.setStock(request.getStock());

        productDao.save(product);

        return product;
    }

    public Boolean deleteProduct(Long id){

        try{
            productDao.deleteById(id);
            return true;

        }catch (Exception exception){

            return false;
        }
    }
}
