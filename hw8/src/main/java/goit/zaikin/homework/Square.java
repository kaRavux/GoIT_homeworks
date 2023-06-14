package goIT.zaikin.homework;

public class Square extends Shape implements HasArea{
    private int side;
    public Square(int side) {
        super("Square");
        this.side = side;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
