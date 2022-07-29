package com.tgdd.dto;



import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManufacturerDto {
	private Long manufacturerId;
	private String manufacturerName;


}
