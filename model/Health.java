package model;

import java.io.Serializable;
public class Health implements Serializable{
	private double height;
	private double weight;
	private double bmi;
	private String bodyType;
	private String messege;
	private String name;

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
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}