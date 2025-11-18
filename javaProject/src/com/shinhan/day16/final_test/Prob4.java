package com.shinhan.day16.final_test;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> productHashSet = new HashSet<Product>();
		System.out.println("*특정 금액 이상의 상품 결과입니다.*****************");
		productHashSet = Arrays.stream(prodList)
							.filter(p->p.getPrice()>=price)
							.peek(p->System.out.println(p.toString()))
							.collect(Collectors.toCollection(HashSet::new));
		return productHashSet;
	}


	private static void makeFile(HashSet resultList)  {
		try {
			FileOutputStream fos = new FileOutputStream("src/data.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Object p: resultList) {
				oos.writeObject(p);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void readFile()  {
		try {
			FileInputStream fis = new FileInputStream("src/data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Product product;
			System.out.println("\n\n*readFile결과입니다.*****************");
			while ((product = (Product) ois.readObject()) != null) {
				System.out.println(product);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}


class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}