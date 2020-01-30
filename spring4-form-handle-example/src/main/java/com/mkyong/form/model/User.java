package com.mkyong.form.model;

public class User {
	private Integer id;
	private String name;

	private int age;
	private String neptunKod;

	public boolean isNew() {
		return (this.id == null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNeptunKod() {
		return neptunKod;
	}

	public void setNeptunKod(String neptunKod) {
		this.neptunKod = neptunKod;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", neptunKod=" + neptunKod + "]";
	}

	
	
}
