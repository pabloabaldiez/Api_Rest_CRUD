package com.api.manager.product.controller.product;



import com.api.manager.product.model.Product;
import com.api.manager.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class Controller_product {

    @Autowired
    private ProductService productService;


    @GetMapping("/getproduct")
    public List<Product> getProductList(){

        return this.productService.getProductList();
    };

    @PostMapping("/insertproduct")
    public Product saveProduct(@RequestBody Product product){ //esto pasa en el body de la consulta

        return this.productService.insertProduct(product);
    };

    @GetMapping("/getProductById/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id){ //esto pasa en el path de la consulta
        return this.productService.getProductById(id);
    }

    @PutMapping("/editproduct/{id}")
    public Product updateProductById( @PathVariable("id") Long id,@RequestBody Product request){
        return this.productService.updateProductById(request, id);
    }

    @DeleteMapping("/deleteproductbyid/{id}")
    public String deleteProductById(@PathVariable("id") Long id){

        boolean ok=this.productService.deleteProduct(id);

        if(ok){
            return "User with id" + id + "deleted";
        } else {
            return "Error, we have a problem and can´t delete user id: "+ id;
        }
    }

}
