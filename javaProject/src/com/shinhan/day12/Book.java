package com.shinhan.day12;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(of= {"title","author"})
@ToString
@AllArgsConstructor
public class Book implements Comparable<Book>{
	String title;
	String author;
	int price;
	
	@Override
	public int compareTo(Book o) {
		return this.price-o.price;
	}
}
