package day05;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[4];
		shapes[0] = new Square(1);
		shapes[1] = new Square(2);
		shapes[2] = new Circle(1);
		shapes[3] = new Circle(2);

		maxArea(shapes);
	}

	public static void maxArea(Shape[] shapes) {
		double max = shapes[0].area();
		int maxIndex = 0;
		for (int i = 0; i < shapes.length; ++i) {
			if (shapes[i].area() > max) {
				max = shapes[i].area();
				maxIndex = i;
			}
		}
		System.out.println("The maxSquare is: " + max
					+ ", the position is: " + maxIndex);
	}
		
}

abstract class Shape {
	double c;
	
	Shape() {
		this(0.0);
	}
	
	Shape(double c) {
		this.c = c;
	}
	
	public abstract double area();
}

class Square extends Shape {
	
	Square() {
		super();
	}
	
	Square(double x) {
		super(x);
	}
	
	public double area() {
		return 0.0625 * c * c;
	}
}

class Circle extends Shape {
	
	Circle() {
		super();
	}
	
	Circle(double x) {
		super(x);
	}
	
	public double area() {
		return 0.0796 * c * c;
	}
}








