package com.eblj.sistema._e_commerce.repositories;

import com.eblj.sistema._e_commerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
