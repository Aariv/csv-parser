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
@Table(name = "tbl_problem")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

	@Id
	@GeneratedValue
	private Integer id;

	private String problem;
	
	private Set<Category> categories;

}
