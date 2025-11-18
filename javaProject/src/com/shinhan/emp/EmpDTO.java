package com.shinhan.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class EmpDTO {
	@NonNull
	private int employee_id;
	private String first_name;
	@NonNull
	private String last_name;
	@NonNull
	private String email;
	private String phone_number;
	@NonNull
	private Date hire_date;
	@NonNull
	private String job_id;
	private double salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
}
