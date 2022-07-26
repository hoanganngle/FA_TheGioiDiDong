package com.tgdd.entity;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tgdd.dto.CategoryDto;
import com.tgdd.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObject {
	public ResponseObject(String string, String string2, ResponseEntity<List<ProductDto>> responseEntity) {
		// TODO Auto-generated constructor stub
	}
	private String status;
	private String message;
	private Object data;
	
	
}
