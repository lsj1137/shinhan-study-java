package com.shinhan.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobDTO {
	String job_id;
	String job_title;
	int min_salary;
	int max_salary;
}
