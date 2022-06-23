package com.tgdd.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int Product_ID;
	private String product_name;
	private int price;
	private int manufacture_id;
	private int category_id;
	private int product_warranty;
	private String image;
	private String description;
	private String store_Name;
	private boolean status;

}
