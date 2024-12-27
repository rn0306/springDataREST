/**
 * 
 */
package com.spring.data.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.data.rest.model.Product;

/**
 * @author Rahul Narwane
 *
 */

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("Select p From Product p WHERE "
			+ "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "
			+ "LOWER(p.description) LIKE(CONCAT('%', :keyword,'%')) OR "
			+ "LOWER(p.brand) LIKE(CONCAT('%',:keyword,'%')) OR "
			+ "LOWER(p.category) LIKE(CONCAT('%',:keyword,'%'))" )
	List<Product> searchByKeyword(String keyword);

}
