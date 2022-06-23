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
@Table(name = "Store")
public class Store implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int store_id;
	private String store_name;
	private int stock_in_store;
	private String address;
	private String city_name;
}
