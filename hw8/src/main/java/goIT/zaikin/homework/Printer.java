package goIT.zaikin.homework;

public class Printer {
    public void printShapeInfo(Shape shape) {
        System.out.println("The shape is: " + shape.getName());
        if (shape instanceof HasVolume) {
            System.out.println("Its volume is: " + ((HasVolume) shape).getVolume());
        }
        if (shape instanceof HasArea) {
            System.out.println("Its area is: " + ((HasArea) shape).getArea());
        }

        System.out.println('\n');
    }
}