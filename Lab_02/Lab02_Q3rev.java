import java.util.Scanner;
public class Lab02_Q3rev {


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the title: ");  
        String title = in.nextLine();
        String upperCased = title.substring(14,15);//Getting the character at position 14 to then convert it to upper case
        System.out.println("-".repeat(38));
        System.out.println("Number of characters:"+title.length());
        System.out.println("All uppercase:"+title.toUpperCase());
        System.out.println("Remove leading and trailing blank characters:"+title.trim());
        System.out.println("Character at index position 5:"+title.charAt(5));
        System.out.println("Title from 3rd character to 8th character (not included): "+title.substring(3,7));
        System.out.println("First occurence of character 'a':"+title.indexOf('a'));
        System.out.println("Last occurence of character 'a':"+title.lastIndexOf('a'));
        /* Modifying input by using substrings*/
        System.out.println("New modified string is: "+ title.substring(7,10)+" "+title.substring(11,14)+upperCased.toUpperCase()+title.charAt(15)+" "+title.substring(3,6));
        
        in.close();
    }
}
   