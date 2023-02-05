package com.springboot.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@Entity
@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PR_ID")
  private Long id;
  @Column(name = "PR_NAME")
  private String name;
  @Column(name = "PR_DESC")

  private String description;
  @Column(name = "PR_PRICE")
  private Double price;
  @Column(name = "PR_QUAN")
  private Integer quantity;
}
