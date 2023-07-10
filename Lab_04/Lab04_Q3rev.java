import java.util.Scanner;
public class Lab04_Q3rev {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int counter = 1;
        int input = 1;
        System.out.print("Please input a positive integer: ");
            input = in.nextInt();
            if (input > 0)
            {
                if (input > max)
                {
                    max = input;
                }
                if (input < min)
                {
                    min = input;
                }
                sum = sum + input;
                while (input > 0)
                {
                System.out.print("Please input a positive integer: ");
                input = in.nextInt();
            
                if (input > 0)
                {
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

                }
        
                double average = (sum / counter); 
                System.out.println("Min: "+min);
                System.out.println("Max: "+max);
                System.out.println("Average: "+average);
            }
            else
            {
                System.out.println("Bye!");
            }
        
        in.close();
    }
}

