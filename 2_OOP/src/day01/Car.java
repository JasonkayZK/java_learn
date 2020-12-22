package day01;

public class Car {
	public String brand;
	public double price;
	public String color;
	
	public void show() {
		System.out.println("The brand of the car: " + brand
				+ "; The price of the car: " + price 
				+ "; The color of the car: " + color);
	}
	
	public void startup() {
		System.out.println("The " + brand + " car is start!");
	}
	
}
