package goIT.zaikin.homework;

public class Cube extends Shape implements HasVolume, HasArea{
    private int side;
    public Cube(int side) {
        super("Cube");
        this.side = side;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }
}
