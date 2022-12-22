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
@Table(name = "module_column_values")
public class ModuleColumnValues {

	@Id
	private int module_column_value_id;
	//module_column_id is primary key of modulecolumns table
	private int module_column_id;
	private String module_colum_key;
	private String module_column_key_value;
}
