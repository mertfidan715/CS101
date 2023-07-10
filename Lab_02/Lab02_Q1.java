import java.util.Scanner;

public class Lab02_Q1{


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the width of the rectangle: ");
        double width = in.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        double height = in.nextDouble();
        double area = height * width;//Area formula
        double circumference = (2 * (height + width));//Circumference formula
        double diagonal = Math.hypot(height, width);//Calculating the hypothenuse(diagonal)  
        System.out.println(" ");                         
        System.out.printf("The area of the rectangle is              :%20.3f%n" , area);
        System.out.printf("The circumference of the rectangle is     :%20.3f%n" , circumference);
        System.out.printf("The diagonal of the rectangle is          :%20.3f%n" , diagonal);
        
        
        in.close();


    }
}