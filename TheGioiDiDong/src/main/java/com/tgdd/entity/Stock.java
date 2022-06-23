package com.tgdd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
public class Stock implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int store_id;
	private int product_id;
	private String stock;
}
