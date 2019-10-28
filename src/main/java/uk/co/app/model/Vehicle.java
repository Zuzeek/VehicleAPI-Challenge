package uk.co.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id; 
	
	@Column
	private String brand; 
	
	@Column
	private String make; 
	
	@Column
	private String colour;
	
	@Column
	private Integer age; 
	
	@Column
	private Double value;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String brand, String make, String colour, Integer age, Double value) {
		this.brand = brand;
		this.make = make;
		this.colour = colour;
		this.age = age;
		this.value = value;
	}
	

	public int getId() {
		return id; 
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	} 
}
