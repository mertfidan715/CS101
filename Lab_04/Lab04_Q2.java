import java.util.Scanner;
public class Lab04_Q2 {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String palindrome = "It is a palindrome.";
        String notPalindrome = "It is not a palindrome.";
        System.out.print("Please input the string: ");
        String input = in.nextLine();
        int length = input.length();
        int last = (length - 1); //Will be used for index position
        int first = 0; //Will be used for index position
        if (length % 2 != 0)
        {
            while (input.charAt(first) == input.charAt(last) && (first != last)) //Conditions to iterate the index positions and check them
            {
                first++;
                last--;
            }
            if (first == last)
            {
                System.out.println(palindrome);
            }
            else
            {
                System.out.println(notPalindrome);
            }
        }
        else if (length % 2 == 0)
        {
            while (input.charAt(first) == input.charAt(last) && (first != last-1)) //Conditions to iterate the index positions and check them
            {
                first++;
                last--;
            }
            if (first == last - 1)
            {
                System.out.println(palindrome);
            }   
            else
            {
                System.out.println(notPalindrome);
            }
        }
        
        in.close();

    }
    
}
