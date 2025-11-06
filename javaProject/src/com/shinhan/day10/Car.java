package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Car {
	private String model;
	private int price;
	private String color;
	
	Car(String model) {
		
	}
}
