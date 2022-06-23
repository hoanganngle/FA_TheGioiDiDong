package com.tgdd.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	private int bill_id;
	private String phone_number;
	private int product_id;
	private int store_id;
	private int order_id;
	private int price
;
}
