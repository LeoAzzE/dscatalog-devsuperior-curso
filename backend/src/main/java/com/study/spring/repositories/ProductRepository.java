package com.study.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.spring.entities.Category;
import com.study.spring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
