package com.springboot.product.controller;

import com.springboot.exception.InvalidInputException;
import com.springboot.product.entity.ProductEntity;
import com.springboot.product.model.Product;
import com.springboot.product.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/product")
@Validated
public class ProductController {
  private final ProductService productService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  List<ProductEntity> getAllProduct(){
    return productService.fetchAllProduct();
  }
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  ResponseEntity<ProductEntity> addNewProduct(@RequestBody @Valid Product product){
    if(Objects.isNull(product)){
      throw new InvalidInputException("Product Can't be Null !!");
    }
    ProductEntity entity = ProductEntity.builder()
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .quantity(product.getQuantity())
            .build();
    System.out.println("<<<<<<<<<< Request >>>>>>>>>>>>");
    System.out.println(entity.toString());
    System.out.println("<<<<<<<<<< Request >>>>>>>>>>>>");
    return new ResponseEntity<>(productService.insertNewProduct(entity), HttpStatus.CREATED);
  }
  @RequestMapping(method = RequestMethod.GET, value = "/test/{param}")
  String testParam(@PathVariable("param") @Size(min = 5, max = 10, message = "Parameter Validation Error") String param){
    return "Request Parameter is : " + param;
  }
}

