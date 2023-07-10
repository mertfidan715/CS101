import java.util.Scanner;
public class Lab02_Q1rev {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter one side of a regular octagon : ");
        double side = in.nextDouble();
        double area = 2 * Math.pow(side, 2) * (1 + Math.sqrt(2)) ;//Area formula of an octagon
        double circumference = (8 * side);//Circumference formula
        double diagonal = side * Math.sqrt(4 + (2 * Math.sqrt(2)));//Diagonal formula for an octagon  
        System.out.println(" ");                         
        System.out.printf("The area of the octagon is              :%20.3f%n" , area);
        System.out.printf("The circumference of the octagon is     :%20.3f%n" , circumference);
        System.out.printf("The diagonal of the octagon is          :%20.3f%n" , diagonal);
        
        
        in.close();

    }
}
