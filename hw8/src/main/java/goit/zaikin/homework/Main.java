package goIT.zaikin.homework;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Shape c1 = new Circle(5);
        printer.printShapeInfo(c1);

        Shape c2 = new Cube(5);
        printer.printShapeInfo(c2);

        Shape p1 = new Pyramid(100, 20);
        printer.printShapeInfo(p1);

        Shape s1 = new Square(10);
        printer.printShapeInfo(s1);

        Shape t1 = new Triangle(10, 5);
        printer.printShapeInfo(t1);

    }
}