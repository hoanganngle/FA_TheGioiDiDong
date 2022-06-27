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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "collaborators")
public class Collaborator implements Serializable{
	@Id
	@Column(name ="collab_name")
	private String collabName;
	private String password;
	@ManyToOne
	@JoinColumn(name= "role_id")
	private Role role;
	
}
