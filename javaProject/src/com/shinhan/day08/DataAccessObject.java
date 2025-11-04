package com.shinhan.day08;

public interface DataAccessObject {

	public abstract void select();
	public abstract void insert();
	public abstract void update();
	public abstract void delete();
	
}

class Parent{
	
}

class MySQLDAO extends Parent implements DataAccessObject{

	void f1() {
		System.out.println("MySQLDAO에서 추가한 함수이다.");
	}
	
	
	@Override
	public void select() {
		System.out.println(getClass().getSimpleName()+"select");
		
	}

	@Override
	public void insert() {
		System.out.println(getClass().getSimpleName()+"insert");
		
	}

	@Override
	public void update() {
		System.out.println(getClass().getSimpleName()+"update");
		
	}

	@Override
	public void delete() {
		System.out.println(getClass().getSimpleName()+"delete");
		
	}
	
}

class OracleDAO implements DataAccessObject{

	@Override
	public void select() {
		System.out.println(getClass().getSimpleName()+"select");
		
	}

	@Override
	public void insert() {
		System.out.println(getClass().getSimpleName()+"insert");
		
	}

	@Override
	public void update() {
		System.out.println(getClass().getSimpleName()+"update");
		
	}

	@Override
	public void delete() {
		System.out.println(getClass().getSimpleName()+"delete");
		
	}
	
}

