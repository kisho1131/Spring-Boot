package com.springboot.product.service;

import com.springboot.product.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  Optional<ProductEntity> findById(Integer id);
  List<ProductEntity> findAllById(List<Integer> id);
  ProductEntity insertNewProduct(ProductEntity entity);
  List<ProductEntity> fetchAllProduct();
}
