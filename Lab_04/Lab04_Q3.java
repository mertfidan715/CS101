import java.util.Scanner;
public class Lab04_Q3 {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Please input n: ");
        int n = in.nextInt();
        System.out.println("Now input "+n+" positive integers:");
        double sum = 0;
        int counter = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        while (counter < n)
        {
            int input = in.nextInt();
            if (input > max)
            {
                max = input;
            }
            if (input < min)
            {
                min = input;
            }
            sum = sum + input;
            counter++;
        }
        double average = (sum / n); 
        System.out.println("Min: "+min);
        System.out.println("Max: "+max);
        System.out.println("Average: "+average);

        in.close();
    }
}
