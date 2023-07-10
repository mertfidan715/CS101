import java.util.Scanner;
public class Lab04_Q4 {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of lines: ");
        int n = in.nextInt();
        int counter = 0;
        String star = "*";
        while (counter < n)
        {
            System.out.println(star);
            counter++;
            star = star + "*";
        }

        in.close();
    }
}
