/**
 * 
 */
package com.ariv.demo.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kloudone
 *
 */
@Entity
@Table(name = "tbl_category")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue
	private Integer id;

	private String category;

	private Set<Solution> solution;
	
	private Problem problem;
}
