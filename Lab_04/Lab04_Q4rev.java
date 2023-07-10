import java.util.Scanner;
public class Lab04_Q4rev {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of lines: ");
        int n = in.nextInt();
        int space = (2 * n - 1);
        int counter = 0;
        String star = "*";
        while (counter < n)
        {
            System.out.printf("-%"+ (space) +"s%n", star);
            star = star + "**";
            counter++;
        }

        in.close();
    }
}