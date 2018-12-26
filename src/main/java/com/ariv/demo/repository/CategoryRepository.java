/**
 * 
 */
package com.ariv.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ariv.demo.domain.Category;

/**
 * @author kloudone
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Integer>{

	Category findByCategory(String category);
}
