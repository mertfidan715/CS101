import java.util.Scanner;
public class Lab02_Q3 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the title: ");  
        String title = in.nextLine();
        System.out.println("-".repeat(38));
        System.out.println("Number of characters:"+title.length()); //Calculating the length of the input
        System.out.println("All uppercase:"+title.toUpperCase()); //Converting the input to upper case
        System.out.println("Remove leading and trailing blank characters:"+title.trim()); //Trimming the input's leading and trailing blank characters
        System.out.println("Character at index position 5:"+title.charAt(5)); //Getting the character at index position 5
        System.out.println("Title from 3rd character to 8th character (not included): "+title.substring(3,7)); //Getting a substring from the input
        System.out.println("First occurence of character 'a':"+title.indexOf('a'));
        System.out.println("Last occurence of character 'a':"+title.lastIndexOf('a'));
        
        in.close();
    }
}
