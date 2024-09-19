package com.sathwik.shopspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwik.shopspring.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
