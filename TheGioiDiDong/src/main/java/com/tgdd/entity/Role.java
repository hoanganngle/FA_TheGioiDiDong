package com.tgdd.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "role")
public class Role implements Serializable{

	@Id
	@Column(name ="role_id")
	private boolean roleId;
	@Column(name ="role_name")
	private String roleName;
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Collaborator> collaborators;
}
