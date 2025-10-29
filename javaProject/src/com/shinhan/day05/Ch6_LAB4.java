package com.shinhan.day05;

public class Ch6_LAB4 {
	public static void main(String[] args) {
		Book[] b = new Book[5];
		b[0] = new Book("Java Program",30000);
		b[1] = new Book("JSP Program",25000);
		b[2] = new Book("SQL Fundamentals",20000);
		b[3] = new Book("JDBC Program",32000);
		b[4] = new Book("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();

	}
}

class Book {
	private String title;
	private int price;
	
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Book> title: "+title+" | price: "+price;
	}
}

class BookMgr {
	Book[] booklist;
	
	public BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}
	
	void printBookList() {
		System.out.println("=== 책 목록 ===");
		for (Book b: booklist) {
			System.out.println(b.getTitle());
		}
		System.out.println();
	}
	
	void printTotalPrice() {
		int total = 0;
		for (Book b: booklist) {
			total+=b.getPrice();
		}
		System.out.println("=== 책 가격의 총합 ===");
		System.out.println("전체 책 가격의 총합 : "+total);
	}
}