/**
 * 
 */
package com.ariv.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ariv.demo.domain.Solution;

/**
 * @author kloudone
 *
 */
public interface SolutionRepository extends CrudRepository<Solution, Integer>{

	Solution findBySolution(String solution);
}
