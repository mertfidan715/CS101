import java.util.Scanner;
public class Lab04_Q1{


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int F0 = 0; //First number in Fibonacci sequence
        int F1 = 1; //Second number in Fibonacci sequence
        int F2 = 0; 
        int counter = 1; //Counter to iterate with respect to user input
        System.out.print("Please input n: ");
        int input = in.nextInt();
        
        if (input < counter)
        {
            System.out.println("Fib("+input+")"+" is "+F0);
        }
        else if (input == counter)
        {
            System.out.println("Fib("+input+")"+" is "+F1);
        }
        else
        {
            while(counter < input) //Assigning first three numbers in the sequence and changing them according to the input
            {
                F2 = F0 + F1;
                F0 = F1;
                F1 = F2;
                counter++;
            }
            System.out.println("Fib("+input+")"+" is "+F2); 
        }
        

        in.close();
    }
}