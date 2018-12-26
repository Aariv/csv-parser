/**
 * 
 */
package com.ariv.demo.domain;

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
@Table(name = "tbl_solution")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solution {

	@Id
	@GeneratedValue
	private Integer id;

	private String solution;

	private Category category;
}
