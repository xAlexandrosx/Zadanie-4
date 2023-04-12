import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static abstract class Shape{

        // String label;
        // void setLabel(String label){
        //     this.label = label;                  Na razie nie używane
        // }
        // String getLabel(){
        //     return label;
        // }
        
        double getArea(){
            return 0;
        }

        void move(double dx, double dy){
        };
    }
    public static class Point extends Shape{
        private double x;
        private double y;

        public Point() {
            this.x = 0.00;
            this.y = 0.00;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

        @Override
        public String toString(){
            return "Punkt> x:"+x+", y:"+y+"\n";
        }

        // String label;
    }

    public static class Section extends Shape{
        private Point pointA;
        private Point pointB;

        public Section() {
            this.pointA = new Point();
            this.pointB = new Point();
        }

        public Section(Point pointA, Point pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }

        @Override
        public void move(double dx, double dy){
            pointA.move(dx, dy);
            pointB.move(dx, dy);
        }

        @Override
        public String toString(){
            return "Odcinek> \n{\n1: "+pointA+"2: "+pointB+"}\n";
        }

        // String label;
    }

    public static class Circle extends Shape{
        private Point srodek;
        private double promien;

        public Circle() {
            this.srodek = new Point();
            this.promien = 1.0;
        }

        public Circle(Point srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
        }

        @Override
        public void move(double dx, double dy) {
            srodek.move(dx, dy);
        }

        @Override
        public String toString() {
            return "Koło>\n{\nŚrodek = " + centerToString() + "\nPromiń = " + this.promien + "\n}\n";
        }

        @Override
        public double getArea(){
            return this.promien*this.promien*3.1415;
        }

        //String label
    }

    public static class Picture extends Shape{        //zmienić później na abstract

        private ArrayList<Shape> elements;

        public Picture(){
            this.elements = new ArrayList<>();
        }

        public void addElement(Shape s){
            this.elements.add(s);
        }

        @Override
        public void move(double dx, double dy) {
            for (Shape shape : elements) {
                shape.move(dx, dy);
            }
        }

        public double getArea(){
            double area = 0.00;
            for (Shape s : elements){
                area+=s.getArea();
            }
            return area;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Obraz:\n");

            sb.append("Elementy:\n");
            for (Shape s : elements) {
                sb.append(s.toString());
            }
            return sb.toString();
        }
    }
    // public class UniquePicture extends Picture{

    // }

    // public class StandarizedPicture extends Picture{         Na razie nie używane

    // }





    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String opcja;

        Picture picture = new Picture();

        do {
            opcja = "";
            System.out.println("1. Dodaj do obrazu\n2. Wyświetl Obraz\n3. Przesuń Obraz\n4. Wyświetl Sumę Pól\nw Wyjdź\nWybierz>");
            opcja = scanner.nextLine();
            switch (opcja) {
                case "1":
                    opcja = "";
                    System.out.println("1 Punkt\n2 Odcinek\n3 Okrąg\nWybierz>");
                    opcja = scanner.nextLine();
                    switch (opcja) {

                        case "1":
                            System.out.println("Wprowadź koordynat x:");
                            double x = scanner.nextDouble();
                            System.out.println("Wprowadź koordynat y:");
                            double y = scanner.nextDouble();

                            Point p = new Point(x, y);
                            picture.addElement(p);
                            scanner.nextLine();
                            break;

                        case "2":
                            System.out.println("Wprowadź koordynaty początku nowego odcinka:");
                            System.out.print("Wprowadź x: ");
                            double xA = scanner.nextDouble();
                            System.out.print("Wprowadź y: ");
                            double yA = scanner.nextDouble();

                            System.out.println("Wprowadź koordynaty końca nowego odcinka:");
                            System.out.print("Wprowadź x: ");
                            double xB = scanner.nextDouble();
                            System.out.print("Wprowadź y: ");
                            double yB = scanner.nextDouble();
                            Point p1 = new Point(xA, yA);
                            Point p2 = new Point(xB, yB);

                            Section se = new Section(p1, p2);
                            picture.addElement(se);
                            System.out.println("Nowy odcinek stworzony: " + se.toString());
                            scanner.nextLine();
                            break;

                        case "3":
                            System.out.println("Wprowadź koordynaty środka nowego koła:");
                            System.out.print("Wprowadź x: ");
                            double xKolo = scanner.nextDouble();
                            System.out.print("Wprowadź y: ");
                            double yKolo = scanner.nextDouble();
                            System.out.print("Wprowadź promień: ");
                            double promien = scanner.nextDouble();

                            Point k = new Point(xKolo, yKolo);
                            Circle c = new Circle(k, promien);
                            picture.addElement(c);
                            System.out.println("Nowe koło stworzone: " + c.toString());
                            scanner.nextLine();
                            break;
                    }
                    break;
                case "2":
                    System.out.println(picture.toString());
                    break;
                case "3":
                    System.out.print("Wprowadź dx: ");
                    double dx = scanner.nextDouble();
                    System.out.print("Wprowadź dy: ");
                    double dy = scanner.nextDouble();
                    picture.move(dx, dy);
                    break;
                case "4":
                    double area = picture.getArea();
                    System.out.println("Suma pól: " + area);
                    break;
            }
        } while (!"w".equals(opcja));

        scanner.close();
    }
}
