package com.example.demoDISetter.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Vehicle 
{
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private String state;
	private String country;
	private int mobile;
	private String vehicleType;
	private String vehicleModel;
	private String insTime;
	@JsonFormat(shape = JsonFormat.Shape.OBJECT,pattern = "dd-MM-yyyy")
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getInsTime() {
		return insTime;
	}
	public void setInsTime(String insTime) {
		this.insTime = insTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Vehicle(int id, String firstName, String lastName, int age, String city, String state, String country,
			int mobile, String vehicleType, String vehicleModel, String insTime, Date date) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mobile = mobile;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.insTime = insTime;
		this.date = date;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", city="
				+ city + ", state=" + state + ", country=" + country + ", mobile=" + mobile + ", vehicleType="
				+ vehicleType + ", vehicleModel=" + vehicleModel + ", insTime=" + insTime + ", date=" + date + "]";
	}
	
	
}
