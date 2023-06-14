package goIT.zaikin.homework;

public class Circle extends Shape implements HasArea{
    private int radius;
    public Circle(int radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
