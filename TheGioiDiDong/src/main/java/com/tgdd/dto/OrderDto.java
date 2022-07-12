package com.tgdd.dto;

import java.util.Date;
import java.util.Set;

import com.tgdd.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
	private Long orderId;
	private Date time;
	private Integer total;
	private Customer customer;
	private Set<OrderDetailDto> orderDetails;

}
