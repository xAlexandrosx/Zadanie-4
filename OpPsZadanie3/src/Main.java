import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

public class Main {

    public static abstract class Shape{

        String label;
        void setLabel(String label){
            this.label = label;
        }
        String getLabel(){
            return label;
        }

        double getArea(){
            return 0;
        }

        void move(double dx, double dy){
        }
    }
    /*
    public static class Point extends Shape{
        private double x;
        private double y;

        public Point() {
            this.x = 0.00;
            this.y = 0.00;
            this.label = "";
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.label = "";
        }

        public Point(double x, double y, String label) {
            this.x = x;
            this.y = y;
            this.label = label;
        }

        @Override
        public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

        @Override
        public String toString(){
            if(label==""){
                return "Punkt> x:"+x+", y:"+y+"\n";
            }
            else{
                return "Punkt> x:"+x+", y:"+y+"\nLabel:"+label+"\n";
            }
        }
    }

     */

    public static abstract class absPoint extends Shape{        //EKSPERYMENTALNY


        abstract public void move(double dx, double dy);


        abstract public String toString();

        abstract public double getArea();
    }

    public static class Point extends absPoint{
        private double x;
        private double y;

        public Point() {
            this.x = 0.00;
            this.y = 0.00;
            this.label = "";
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.label = "";
        }

        public Point(double x, double y, String label) {
            this.x = x;
            this.y = y;
            this.label = label;
        }
        @Override
        public void move(double dx, double dy) {
            {
                x += dx;
                y += dy;
            }
        }

        @Override
        public String toString(){
            if(label==""){
                return "Punkt> x:"+x+", y:"+y+"\n";
            }
            else{
                return "Punkt> x:"+x+", y:"+y+"\nLabel:"+label+"\n";
            }
        }

        public double getArea(){
            return 0;
        }
    }

    public static class Section extends Shape{
        private Point pointA;
        private Point pointB;

        public Section() {
            this.pointA = new Point();
            this.pointB = new Point();
            this.label = "";
        }

        public Section(Point pointA, Point pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.label = "";
        }

        public Section(Point pointA, Point pointB, String label) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.label = label;
        }

        @Override
        public void move(double dx, double dy){
            pointA.move(dx, dy);
            pointB.move(dx, dy);
        }

        @Override
        public String toString(){
            if(label == ""){
                return "Odcinek> \n{\n1: "+pointA+"2: "+pointB+"}\n";
            }
            else{
                return "Odcinek> \n{\n1: "+pointA+"2: "+pointB+"}\nLabel: "+label+"\n";
            }
        }
    }

    public static class Circle extends Shape{
        private Point srodek;
        private double promien;

        public Circle() {
            this.srodek = new Point();
            this.promien = 1.0;
            this.label = "";
        }

        public Circle(Point srodek, double promien) {
            this.srodek = srodek;
            this.promien = promien;
            this.label = "";
        }

        public Circle(Point srodek, double promien, String label) {
            this.srodek = srodek;
            this.promien = promien;
            this.label = label;
        }

        @Override
        public void move(double dx, double dy) {
            srodek.move(dx, dy);
        }

        @Override
        public String toString() {
            if(label==""){
                return "Koło>\n{\nŚrodek = " + this.srodek + "\nPromień = " + this.promien + "\n}\n";
            }
            else{
                return "Koło>\n{\nŚrodek = " + this.srodek + "\nPromień = " + this.promien + "\nLabel: "+label+"}\n";
            }
        }

        @Override
        public double getArea(){
            return this.promien*this.promien*3.1415;
        }
    }

    public static abstract class Picture extends Shape{

        public ArrayList<Shape> elements;

        public Picture(){
            this.elements = new ArrayList<>();
        }

        abstract boolean addElement(Shape element);

        @Override
        public void move(double dx, double dy) {
            for (Shape shape : elements) {
                shape.move(dx, dy);
            }
        }

        public double getArea(){
            double area = 0.00;
            for (Shape s : elements){
                area += s.getArea();
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
    public static class UniquePicture extends Picture{

        @Override
        public boolean addElement(Shape element) {
            for (Shape s : elements) {
                if (s.getLabel().equals(element.getLabel())) {
                    System.out.println("Błąd. Taki label już istnieje");
                    return false;
                }
            }
            elements.add(element);
            return true;
        }

    }
    public static class StandarizedPicture extends Picture{
        public boolean addElement(Shape element) {
            String tag = element.getLabel();
            Pattern labelPattern = Pattern.compile("^[A-Z][A-Z0-9]*$");         //sprawdzić poprawność kompilacji Pattern
            Matcher labelMatch = labelPattern.matcher(tag);
            if (labelMatch.matches()) {
                elements.add(element);
                return true;
            }
            System.out.println(tag+" zawiera niedozwolone znaki");
            return false;
        }
    }



    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in);
        String opcja;
        int wybierzObraz;

        UniquePicture picture = new UniquePicture();
        StandarizedPicture StdPicture = new StandarizedPicture();

        do {
            opcja = "";
            wybierzObraz = 0;

            System.out.println("1. Dodaj do obrazu\n2. Wyświetl Obraz\n3. Przesuń Obraz\n4. Wyświetl Sumę Pól\nw Wyjdź\nWybierz>");
            opcja = scanner.nextLine();
            switch (opcja) {
                case "1":
                    System.out.println("Do którego obrazu chcesz dodać?\n1 UniquePicture\n2 StandarizedPicture\nWybierz>");
                    wybierzObraz=scanner.nextInt();
                    scanner.nextLine();
                    if(wybierzObraz == 1 || wybierzObraz == 2){
                        opcja = "";
                        System.out.println("1 Punkt\n2 Odcinek\n3 Okrąg\nWybierz>");
                        opcja = scanner.nextLine();
                        switch (opcja) {

                            case "1":
                                System.out.println("Wprowadź koordynat x:");
                                double x = scanner.nextDouble();
                                System.out.println("Wprowadź koordynat y:");
                                double y = scanner.nextDouble();
                                System.out.println("Dodaj label (opcjonalne, ENTER by pominąć)");
                                scanner.nextLine();
                                String labelPoint = scanner.nextLine();

                                Point p = new Point(x, y, labelPoint);
                                if(wybierzObraz==1){
                                    picture.addElement(p);
                                }else if(wybierzObraz==2){
                                    StdPicture.addElement(p);
                                }
                                wybierzObraz=0;
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
                                System.out.println("Dodaj label (opcjonalne, ENTER by pominąć)");
                                scanner.nextLine();
                                String labelSection = scanner.nextLine();
                                Point p1 = new Point(xA, yA);
                                Point p2 = new Point(xB, yB);

                                Section se = new Section(p1, p2, labelSection);
                                if(wybierzObraz==1){
                                    picture.addElement(se);
                                }else if(wybierzObraz==2){
                                    StdPicture.addElement(se);
                                }
                                wybierzObraz=0;
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
                                System.out.println("Dodaj label (opcjonalne, ENTER by pominąć)");
                                scanner.nextLine();
                                String labelCircle = scanner.nextLine();

                                Point k = new Point(xKolo, yKolo);
                                Circle c = new Circle(k, promien, labelCircle);
                                if(wybierzObraz==1){
                                    picture.addElement(c);
                                }else if(wybierzObraz==2){
                                    StdPicture.addElement(c);
                                }
                                wybierzObraz=0;
                                System.out.println("Nowe koło stworzone: " + c.toString());
                                scanner.nextLine();
                                break;
                        }
                    }
                    else {
                        System.out.println("Błąd. Nie ma takiego obrazu");
                    }
                    break;
                case "2":
                    System.out.println("Który obraz chcesz wyświetlić?\n1 UniquePicture\n2 StandarizedPicture\nWybierz>");
                    wybierzObraz = scanner.nextInt();
                    scanner.nextLine();
                    if(wybierzObraz == 1 || wybierzObraz ==2){
                        if(wybierzObraz==1){
                            System.out.println(picture.toString());
                        }else if(wybierzObraz==2){
                            System.out.println(StdPicture.toString());
                        }
                        wybierzObraz=0;
                    }else{
                        System.out.println("Błąd. Nie ma takiego obrazu");
                    }
                    break;
                case "3":
                    System.out.println("Który obraz chcesz przesunąć?\n1 UniquePicture\n2 StandarizedPicture\nWybierz>");
                    wybierzObraz = scanner.nextInt();
                    scanner.nextLine();
                    if(wybierzObraz == 1 || wybierzObraz == 2){
                        System.out.print("Wprowadź dx: ");
                        double dx = scanner.nextDouble();
                        System.out.print("Wprowadź dy: ");
                        double dy = scanner.nextDouble();
                        if(wybierzObraz==1){
                            picture.move(dx, dy);
                        }else if(wybierzObraz==2){
                            StdPicture.move(dx, dy);
                        }
                        wybierzObraz=0;
                    }else{
                        System.out.println("Błąd. Nie ma takiego obrazu");
                    }
                    break;
                case "4":
                    double area=0;
                    System.out.println("Sumę pól którego obrazu chcesz uzyskać?\n1 UniquePicture\n2 StandarizedPicture\nWybierz>");
                    wybierzObraz = scanner.nextInt();
                    scanner.nextLine();
                    if(wybierzObraz == 1 || wybierzObraz ==2){
                        if(wybierzObraz==1){
                            area = picture.getArea();
                        }else if(wybierzObraz==2){
                            area = StdPicture.getArea();
                        }
                        wybierzObraz=0;
                        System.out.println("Suma pól: " + area);
                    }else{
                        System.out.println("Błąd. Nie ma takiego obrazu");
                    }
                    break;
            }
        } while (!"w".equals(opcja));
        scanner.close();
    }
}



/*

        DONE - Zmodyfikuj zadanie z poprzednich zajęć:

        DONE - korzystając z techniki dziedziczenia dodaj do klas reprezentujących obiekty graficzne (punkty, linie, ....) pole String label, które pozwala na przypisanie etykiety tekstowej (stwórz osobną klasę Figure),
        DONE - zmodyfikuj klasę Picture, tak aby wszystkie rodzaje obiektów graficznych były przechowywane w jednej tablicy lub liście.
        zmodyfikuj implementację metod: toString, move, oraz getArea w klasie Picture, tak aby wykorzystywały mechanizm polimorfizmu
        wśród stworzonych wybierz i zamień wybrana klasę konkretną na klasę abstrakcyjną
        DONE - korzystając z dziedziczenia stwórz 2 dodatkowe wersje klasy Picture różniące się wymaganiami odnośnie etykiet (label)

        DONE - UniquePicture - pozwala na dodanie obiektów graficznych z unikalnymi etykietami, zwraca true jeśli udało się dodać
        DONE - StandarizedPicture - pozwala na dodanie obiektów graficznych z etykietami składającymi się wyłączeni z dużych liter i cyfr i rozpoczynających się od litery, użyj java.util.regex.Pattern, zwraca true jeśli udało się dodać;

        DONE - W implementacji UniquePicture i StandarizedPicture wykorzystaj  poniższą metodę add odziedziczoną z klasy bazowej - w klasach potomnych nadpisz jedynie metodę checkLabel

        DONE - public boolean add(Figure fig) {
        DONE - if (checkLabel(fig)) {
        DONE - addImpl(fig); // dodaje figurę do list lub tablicy
        DONE - return true;
        DONE - }
        DONE - return false;
        DONE - }

 */

// ***** ***
