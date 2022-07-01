package com.tgdd.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDto implements Serializable{
	private Integer manufacturerId;
	@NotEmpty
	private String manufacturerName;
	private Boolean isEdit = false;

}
