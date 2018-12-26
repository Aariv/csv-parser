/**
 * 
 */
package com.ariv.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ariv.demo.domain.Problem;

/**
 * @author kloudone
 *
 */
public interface ProblemRepository extends CrudRepository<Problem, Integer>{

	Problem findByProblem(String problem);
}
