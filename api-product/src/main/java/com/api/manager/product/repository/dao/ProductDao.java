package com.api.manager.product.repository.dao;


import com.api.manager.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product, Long > {//el Long es el tipo de dato del id


}
