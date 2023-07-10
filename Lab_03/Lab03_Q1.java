import java.util.Scanner;
public class Lab03_Q1{


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = in.nextDouble();
        System.out.print("Enter your height in meters: ");
        double height = in.nextDouble();
        double BMI = weight / (height * height);

        if (BMI < 18.5)
        {
            System.out.printf("Your BMI is %.2f", BMI);
            System.out.println(" and you are in the category of underweight.");
        }
        else if (BMI < 25)
        {
            System.out.printf("Your BMI is %.2f", BMI);
            System.out.println(" and you are in the category of healthy.");

        }
        else if (BMI < 30)
        {
            System.out.printf("Your BMI is %.2f", BMI);
            System.out.println(" and you are in the category of overweight.");

        }
        else
        {
            System.out.printf("Your BMI is %.2f", BMI);
            System.out.println(" and you are in the category of obese.");

        }


        in.close();


    }
}