import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static class Point {
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

        public Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }

        public void move(double dx, double dy) {
            x+=dx; y+=dy;
        }

        @Override
        public String toString(){
            return "Punkt> x:"+x+", y:"+y+"\n";
        }

        public double getArea(){
            return 0;
        }
    }

    public static class Section {
        private Point pointA;
        private Point pointB;

        public Section() {
            this.pointA.x = 0;
            this.pointA.y = 0;
            this.pointB.x = 0;
            this.pointB.y = 0;
        }

        public Section(Point pointA, Point pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }

        public Section(Section other) {
            this.pointA = other.pointA;
            this.pointB = other.pointB;
        }
        public void move(double dx, double dy){
            pointA.move(dx, dy);
            pointB.move(dx, dy);
        }

        @Override
        public String toString(){
            return "Odcinek> \n{\n1: "+pointA+"2: "+pointB+"}\n";
        }
        public double getArea(){
            return 0;
        }
    }

    public static class Circle {

        private Point srodek;
        private double promien;

        public Circle() {
            this.srodek.x = 0;
            this.srodek.y = 0;
            this.promien = 0;
        }

        public Circle(Point srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
        }

        public Circle(Circle other) {
            this.srodek.x = other.srodek.x;
            this.srodek.y = other.srodek.y;
        }

        public void move(double dx, double dy) {
            srodek.move(dx, dy);
        }

        @Override
        public String toString() {
            return "Koło>\n{\nŚrodek = " + centerToString() + "\nPromiń = " + this.promien + "\n}\n";
        }

        public double getArea(){
            return this.promien*this.promien*3.1415;
        }
    }

    public static class Picture {
        private ArrayList<Point> points;
        private ArrayList<Section> sections;
        private ArrayList<Circle> circles;

        public Picture() {
            this.points = new ArrayList<>();
            this.sections = new ArrayList<>();
            this.circles = new ArrayList<>();
        }

        public void addPoint(Point p) {
            this.points.add(p);
        }

        public void addSection(Section s) {
            this.sections.add(s);
        }

        public void addCircle(Circle c) {
            this.circles.add(c);
        }

        public void move(double dx, double dy) {
            for (Point p : points) {
                p.move(dx, dy);
            }
            for (Section s : sections) {
                s.move(dx, dy);
            }
            for (Circle c : circles) {
                c.move(dx, dy);
            }
        }

        public double getArea() {
            double area = 0;
            for (Point p : points) {
                area += p.getArea();
            }
            for (Section s : sections) {
                area += s.getArea();
            }
            for (Circle c : circles) {
                area += c.getArea();
            }
            return area;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Obraz:\n");

            sb.append("Punkty:\n");
            for (Point p : points) {
                sb.append(p.toString());
            }

            sb.append("Odcinki:\n");
            for (Section s : sections) {
                sb.append(s.toString());
            }

            sb.append("Koła:\n");
            for (Circle c : circles) {
                sb.append(c.toString());
            }

            return sb.toString();
        }
    }
    public static void main(String[] args) {
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
                            picture.addPoint(p);
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

                            Section s = new Section(p1, p2);
                            picture.addSection(s);
                            System.out.println("Nowy odcinek stworzony: " + s.toString());
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
                            picture.addCircle(c);
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
