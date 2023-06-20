package com.vinay.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.insurance.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
