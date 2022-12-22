package com.optimuminfo.metadata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "modules")
public class Modules {

	@Id
    @Column(name="module_id")
	private int module_id;
	
	@Column(name="module_name")
	private String module_name;
}
