import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static class Point {     // Klasa Point i jej metody
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
            return "("+x+","+y+")";
        }

        public double getArea(){
            return 0;
        }
    }

    public static class Section {       // Klasa odcinek i jej metody
        private Point pointA;
        private Point pointB;

        public Section() {
            this.pointA = 0;
            this.pointB = 0;
        }

        public Section(Point pointA, Point pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }

        public Section(Section other) {
            this.pointA = other.pointA;
            this.pointB = other.pointB;
        }
        public move(double dx, double dy){
            pointA.move(dx, dy);
            pointB.move(dx, dy);
        }

        @Override
        public String toString(){
            return pointA+"-"+pointB;
        }
        public double getArea(){
            return 0;
        }
    }

    public static class Circle {        // klasa koło i jej metody

        private Point srodek;
        private double promien;

        public Circle() {
            this.srodek = new Point();
            this.promien = 0;
        }

        public Circle(Point srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
        }

        public Circle(Circle other) {
            this.x = other.x;
            this.y = other.y;
        }

        public void move(double dx, double dy) {
            srodek.move(dx, dy);
        }

        @Override
        public String toString() {
            return "Koło(śroek=" + srodek + ", Promień=" + promien + ")";
        }

        public double getArea(){
            return this.promien*this.promien*3.1415;
        }
    }

    public static class Picture {       //klasa picture i jej metody

        public void move(double dx, double dy){
            //metoda move
        }

        @Override
        public toString(){
            //metoda toString
        }

        public void getArea(){
            //metoda getArea
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello Github!");

        Scanner scanner = new Scanner(System.in);
        String opcja;

        do {
            opcja = "";
            System.out.println("1 Dodaj do obrazu\n2 Wyświetl Obraz\n3 Przesuń Obraz\n4 Wyświetl Sumę Pól\nw Wyjdź\nWybierz>");
            try {
                opcja = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Brak Opcji");
            }
            switch (opcja) {
                case "1":
                    opcja = "";
                    System.out.println("1 Punkt\n2 Odcinek\n3 Okrąg\nWybierz>");
                    try {
                        opcja = scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Brak Opcji");
                    }
                    switch (opcja) {

                        case "1":
                        System.out.println("Wprowadź koordynat x:");        //Tworzenie Point
                        double x = scanner.nextDouble();
                        System.out.println("Wprowadź koordynat y:");
                        double y = scanner.nextDouble();
                        Point newPoint = new Point(x,y);
                        System.out.println("Dodano punkt "+newPoint.toString());
                        scanner.nextLine();
                            break;

                        case "2":
                        System.out.println("Wprowadź koordynaty początku nowego odcinka:");     //Tworzenie Section
                        System.out.print("Wprowadź x: ");
                        double xA = scanner.nextDouble();
                        System.out.print("Wprowadź y: ");
                        double yA = scanner.nextDouble();
                        Point pointA = new Point(xA, yA);
            
                        System.out.println("Wprowadź koordynaty końca nowego odcinka:");
                        System.out.print("Wprowadź x: ");
                        double xB = scanner.nextDouble();
                        System.out.print("Wprowadź y: ");
                        double yB = scanner.nextDouble();
                        Point pointB = new Point(xB, yB);
            
                        Section newSection = new Section(pointA, pointB);
            
                        System.out.println("Nowy odcinek stworzony: " + newSection.toString());
                        scanner.nextLine();
                            break;

                        case "3":
                        System.out.println("Wprowadź koordynaty środka nowego koła:");      //Tworzenie Circle
                        System.out.print("Wprowadź x: ");
                        double xKoło = scanner.nextDouble();
                        System.out.print("Wprowadź y: ");
                        double yKoło = scanner.nextDouble();
                        Point srodek = new Point(xKoło, yKoło);
                        System.out.print("Wprowadź promień: ");
                        double promien = scanner.nextDouble();

                        Circle newCircle = new Circle(srodek, promien);

                        System.out.println("Nowe koło stworzone: " + newCircle.toString());
                        scanner.nextLine();
                            break;
                    }
                    break;
                case "2":
                    //Wyświetl obraz
                    break;
                case "3":
                    //przesuń obraz
                    break;
                case "4":

                    break;
            }
        } while (!"w".equals(opcja));

        scanner.close();
    }
}
