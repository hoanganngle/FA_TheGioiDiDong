package com.tgdd.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Role")
public class Role implements Serializable{

	private boolean role_id;
	private String role_name;
}
