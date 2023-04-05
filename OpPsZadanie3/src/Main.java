import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static class Point {
        private double x;       // int na double
        private double y;       // int na double

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(double x, double y) {      // int na double
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

    public static class Section {
        private Point pointA;      // int na Point
        private Point pointB;      // int na Point

        public Section() {                      //dodano .x i .y do oznaczenia doubli w pointA i pointB
            this.pointA.x = 0;
            this.pointA.y = 0;
            this.pointB.x = 0;
            this.pointB.y = 0;
        }

        public Section(Point pointA, Point pointB) {      // int na Point
            this.pointA = pointA;
            this.pointB = pointB;
        }

        public Section(Section other) {
            this.pointA = other.pointA;
            this.pointB = other.pointB;
        }
        public void move(double dx, double dy){         //zmieniono 'public' na 'public void'
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

    public static class Circle {

        private Point srodek;   // int na Point
        private double promien;

        public Circle() {
            this.srodek.x = 0;              // dodano .x i .y do this.srodek
            this.srodek.y = 0;
            this.promien = 0;
        }

        public Circle(Point srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
        }

        public Circle(Circle other) {               // dodano '.srodek' po 'other'
            this.srodek.x = other.srodek.x;
            this.srodek.y = other.srodek.y;
        }

        public void move(double dx, double dy) {
            srodek.move(dx, dy);
        }

        public String centerToString(){                                                 //dodano metodę centerToString, uzupełniającą toString
            return "x:" + this.srodek.x + " y:" + this.srodek.y;
        }
        @Override
        public String toString() {
            return "Circle(center= " + centerToString() + ", radius = " + this.promien + ")";           //dodano centerToString() zamiast 'center' oraz 'this.' przed promien
        }

        public double getArea(){
            return this.promien*this.promien*3.1415;
        }
    }

    //Klasa Picture zawierająca 3 kolekcje (listy lub tablice) obiektów 1,2,3
    // oraz metody umożliwiające dodawanie nowych obiektów do kolekcji.
    public static class Picture {

        public Point pointList[];
        public Section sectionList[];
        public Circle circleList[];
        int pointCell, sectionCell, circleCell=0;
        public Picture(){
            this.pointCell = 0;
            this.sectionCell = 0;
            this.circleCell = 0;
        }
        public void addPoint(Point newPoint){
            this.pointList[pointCell] = newPoint;
            pointCell++;
        }
        public void addSection(Point newSection){
            this.pointList[sectionCell] = newSection;
            sectionCell++;
        }
        public void addCircle(Point newCircle){
            this.circleList[circleCell] = newCircle;
            circleCell++;
        }
        public Picture move(double dx, double dy){
            for(int i = 0; i<=pointCell; i++){
                pointList[i].move(dx, dy);
            }
            for(int i = 0; i<=sectionCell; i++){
                sectionList[i].move(dx, dy);
            }
            for(int i = 0; i<=circleCell; i++){
                circleList[i].move(dx, dy);
            }
        }
        @Override
        public  String toString(){
            for(int i = 0; i<=pointCell; i++){
                pointList[i].toString();
            }
            for(int i = 0; i<=sectionCell; i++){
                sectionList[i].toString();
            }
            for(int i = 0; i<=circleCell; i++){
                circleList[i].toString();
            }
        }
        public double getArea(){
            double areaSum = 0;
            for(int i = 0; i<=pointCell; i++){
                areaSum += pointList[i];
            }
            for(int i = 0; i<=sectionCell; i++){
                areaSum += sectionList[i];
            }
            for(int i = 0; i<=circleCell; i++){
                areaSum += circleList[i];
            }
            return areaSum;
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
                            //dodaj punkt
                            break;
                        case "2":
                            //dodaj odcinek
                            break;
                        case "3":
                            //dodaj okrąg
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