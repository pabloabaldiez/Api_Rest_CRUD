package com.api.manager.product.controller.product;



import com.api.manager.product.model.Product;
import com.api.manager.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){ //esto pasa en el body de la consulta

        Product newProduct=this.productService.insertProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    };

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Optional> getProductById(@PathVariable("id") Long id){ //esto pasa en el path de la consulta

       Optional<Product> product= this.productService.getProductById(id);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/editproduct/{id}")
    public ResponseEntity<Product>  updateProductById( @PathVariable("id") Long id,@RequestBody Product request){

        Product product=this.productService.updateProductById(request, id);

        return  new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteproductbyid/{id}")
    public ResponseEntity<HashMap<String, Boolean>> deleteProductById(@PathVariable("id") Long id){

        this.productService.deleteProduct(id);
        HashMap<String, Boolean> stateProductDelete=new HashMap<>();

        stateProductDelete.put("deleted", true);

        return ResponseEntity.ok(stateProductDelete);
    }

}
