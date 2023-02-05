package com.springboot.product.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @NotNull(message = "Product Name Can't be Null !!")
  @NotBlank(message = "Product Name Can't be Blank !!")
  private String name;

  @NotNull(message = "Product Description Can't be Null !!")
  @NotBlank(message = "Product Description Can't be Blank !!")
  private String description;
  private Double price;
  @Min(20)
  @Max(30)
  private Integer quantity;
}
