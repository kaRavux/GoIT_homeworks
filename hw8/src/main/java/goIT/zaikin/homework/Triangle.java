package goIT.zaikin.homework;

public class Triangle extends Shape implements HasArea{
    private int base;
    private int height;
    public Triangle(int base, int height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public double getArea() {
        return (double) (base * height) / 2;
    }
}
