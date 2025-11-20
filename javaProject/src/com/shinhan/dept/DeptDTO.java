package com.shinhan.dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class DeptDTO {
	@NonNull
	int department_id;
	@NonNull
	String department_name;
	Integer manager_id;
	Integer location_id;
}
