package com.tgdd.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")

public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "product_name")
	private String productName;
	private Integer price;
	@Column(name = "product_warranty")
	private Integer productWarranty;
	private String image;
	private String description;
	@Column(name = "store_name")
	private String storeName;
	private boolean status;
	private Integer unit;
	@ManyToOne
	@JoinColumn(name = "manufacture_id")
	private Manufacturer manufacturer;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private Collection<Cart> cartCollection;

}
