package com.tgdd.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	private Date time;
	private Integer total;
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private Set<Bill> bills;
	@ManyToOne
	@JoinColumn(name = "phone_number")
	private Customer customer;
}
