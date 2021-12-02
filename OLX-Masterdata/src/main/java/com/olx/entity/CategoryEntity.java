package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "categories")

public class CategoryEntity {
	
	
	@Id	
	private int id;
	@Column(name = "name")
	private String categoryName;
	@Column(name = "description")
	private String desc;


}
