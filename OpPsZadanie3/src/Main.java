import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static class Point {
        private int x;
        private int y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point other) {
            this.x = other.x;
            this.y = other.y;
        }
    }

    public static class Section {
        private int pointA;
        private int pointB;

        public Section() {
            this.pointA = 0;
            this.pointB = 0;
        }

        public Section(int pointA, int pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
        }

        public Section(Section other) {
            this.pointA = other.pointA;
            this.pointB = other.pointB;
        }
    }

    public static class Circle {

        private int srodek;
        private double promien;

        public Circle() {
            this.srodek = 0;
            this.promien = 0;
        }

        public Circle(int srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
        }

        public Circle(Circle other) {
            this.x = other.x;
            this.y = other.y;
        }
    }

    public static class Picture {

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
                 //Wyświetl sumę
                    break;
                default:
                    System.out.println("Brak opcji");
                    break;
            }
        } while (!"w".equals(opcja));

        scanner.close();
    }
}
