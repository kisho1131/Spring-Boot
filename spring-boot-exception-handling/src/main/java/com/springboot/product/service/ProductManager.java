package com.springboot.product.service;

import com.springboot.product.entity.ProductEntity;
import com.springboot.product.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductManager implements ProductService {
  private final ProductEntityRepository repository;
  @Override
  public Optional<ProductEntity> findById(Integer id) {
    return repository.findById(id);
  }
  @Override
  public List<ProductEntity> findAllById(List<Integer> ids) {
    return repository.findAllById(ids);
  }
  @Override
  public ProductEntity insertNewProduct(ProductEntity entity){
    return repository.save(entity);
  }
  @Override
  public List<ProductEntity> fetchAllProduct(){
    return repository.findAll();
  }
}
