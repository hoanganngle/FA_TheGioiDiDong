package com.tgdd.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")

public class Customer implements Serializable {

	@Id
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "user_name")
	private String userName;
	private String address;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Cart> carts;

}
