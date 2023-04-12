import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public abstract class Shape{

        String label;
        void setLabel(String label){
            this.label = label;
        }
        String getLabel(){
            return label;
        }
    }

    public class Point extends Shape{
        int x,y;
        public Point(double x, double y) {
            this.x = x; this.y = y;
        }

        public Point() {
        }

        double getArea() {
            return 0;
        }

        String label;
    }

    public class Section extends Shape{

    }

    public class Circle extends Shape{

    }

    public abstract class Picture{
        public boolean add(Figure fig){
            if (checkLabel(fig)){
                addImpl(fig);
            }
        }
    }

    public class UniquePicture extends Picture{

    }

    public class StandarizedPicture extends Picture{

    }

    public static void main(String[]args){

    }
}
