package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="adv_status")
@Data
public class StatusEntity {

	@Id
	private int id;
	private String status;
}
