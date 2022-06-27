package com.tgdd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="bill_id")
	private int billId;
	@Column(name ="price")
	private int price;
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order orders;
	@ManyToOne
	@JoinColumn(name="phone_number")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product products;
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
;
}
