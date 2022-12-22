package com.optimuminfo.metadata.entity;

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
@Table(name = "module_columns")
public class ModuleColumns {
	
	@Id
	private int module_column_id;
	//module_id is primary key of modules table
	private int module_id;
	private String module_column_name;
	private String module_column_type;
	private String module_column_data_type;
}
