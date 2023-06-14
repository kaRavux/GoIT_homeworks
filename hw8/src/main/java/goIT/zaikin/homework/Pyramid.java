package goIT.zaikin.homework;

public class Pyramid extends Shape implements HasVolume{
    private int baseArea;
    private int height;

    public Pyramid(int baseArea, int height) {
        super("Pyramid");
        this.baseArea = baseArea;
        this.height = height;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public double getVolume() {
        return (double) (baseArea * height) / 3;
    }
}
