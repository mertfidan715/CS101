import java.util.Scanner;
public class Lab06_Q1rev {


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number to be examined: ");
        int input = in.nextInt();
        System.out.println("Number of digits: "+countDigits(input));
        System.out.println("Sum of digits: "+sumOfDigits(input));
        if (isFibonacci(input) == true)
        {
            System.out.println(input+" is a Fibonacci number.");
        }
        else
        {
            System.out.println(input+" is not a Fibonacci number.");
        }
        if (isNeon(input) == true)
        {
            System.out.println(input+" is a Neon number.");
        }
        else
        {
            System.out.println(input+" is not a Neon number.");
        }
        if (isNarcissistic(input) == true)
        {
            System.out.println(input+" is Narcissistic.");
        }
        else
        {
            System.out.println(input+" is not Narcissistic.");
        }
        if (isPrime(input) == true)
        {
            System.out.println(input+" is a Prime number.");
        }
        else
        {
            System.out.println(input+" is not a Prime number.");
        }
        
        in.close();
    }

    public static boolean isPerfectSquare(int a) {

        int b = 0; //Helper to find if input is equal to b to the number 2
        for (int i = a; i >= 0 && b * b != a; i--)//Finding b that provides b * b = a
        {
            b++;
        }
        if (b * b == a || b == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isFibonacci(int a){

        int condition1 = (5 * power(a, 2) + 4);//First condition of being a Fibonacci number
        int condition2 = (5 * power(a, 2) - 4);//Second condition of being a Fibonacci number
        if (isPerfectSquare(condition1) == true || isPerfectSquare(condition2) == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int sumOfDigits(int a){

        int newA = 0;//Helper to update a
        int sum = 0;
        while (a > 0)
        {
            newA = a / 10;
            sum += a % 10;//Adding last digit to the sum
            a = newA; 
        }
        return sum;
    }

    public static boolean isNeon(int a){

        if (sumOfDigits(power(a, 2)) == a)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isPrime(int a){

        int dividerSum = 0;
        for (int i = 1; i <= a; i++)
        {
            if (a % i == 0)//Checking if the sum of dividers for a is equal to a + 1, which means it is a prime number
            {
                dividerSum += i;
            }
        }
        if (dividerSum == a + 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int power(int a, int b){

        int result = 1;
        for (int i = b; i>0; i--)//Incrementing by the power
        {
            result = result * a;//Multiplying the base with itself
        }
        return result;
    }

    public static int countDigits(int a){
        
        int result = 0;
        while (a > 0)
        {
            a = a / 10;
            result++;//Adding one to the sum for evry digit
        }
        return result;
    }

    public static boolean isNarcissistic(int a){

        int sum = 0;
        int b = a;
        while (b > 0)
        {
            int digit = b % 10;//Finding last digit
            sum += power(digit, countDigits(a));//Gettin the last digit to the power count of digits
            b = b / 10;
        }
        if (sum == a)//Checking if it is narcissistic
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
