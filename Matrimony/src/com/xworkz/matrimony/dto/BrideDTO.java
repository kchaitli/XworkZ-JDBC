package com.xworkz.matrimony.dto;

public class BrideDTO {
	private int id;
	private String name;
	private int age;
	private double height;
	private double weight;
	private String qualification;
	private String expectation;
	private String phoneNumber;
	private double salary;
	private String Address;
	private String occupation;
	
	public BrideDTO() {
		
	}
	

	@Override
	public String toString() {
		return "BrideDTO [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", qualification=" + qualification + ", expectation=" + expectation + ", phoneNumber=" + phoneNumber
				+ ", salary=" + salary + ", Address=" + Address + ", occupation=" + occupation + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
}
