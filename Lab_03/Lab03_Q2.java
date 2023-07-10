import java.util.Scanner;
public class Lab03_Q2 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the year to be evaluated: ");
        int year = in.nextInt();
        int century = (year / 100) + 1;
        String leapYear = "is a leap year.";
        String notLeapYear = "is not a leap year.";
        int lastDigit = century % 10;
        String centurySuffix="th";
       
        if (year % 10 == 0)
        {
            century = century - 1;
        }
        if(lastDigit==1 && century != 11)
        {
            centurySuffix="st";
        }
        else if(lastDigit==2 && century != 12)
        {
            centurySuffix="nd";
        }
        else if(lastDigit==3 && century != 13)
        {
            centurySuffix="rd";
        }
        else if (century == 11)
        {
            centurySuffix="th";
        }
        else if (century == 12)
        {
            centurySuffix="th";
        }
        else if (century == 13)
        {
            centurySuffix="th";
        }
        

        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0) //Leap year
                {
                    System.out.print("The year "+year);
                    System.out.print(" is in the "+century);
                    System.out.println(centurySuffix+" century and "+leapYear);

                }
                else //Not a leap year
                {
                    System.out.print("The year "+year);
                    System.out.print(" is in the "+century);
                    System.out.println(centurySuffix+" century and "+notLeapYear);
                }
            }
            else //Leap year
            {
                System.out.print("The year "+year);
                System.out.print(" is in the "+century);
                System.out.println(centurySuffix+" century and "+leapYear);
            }
        }    
        else //Not a leap year
        {
            System.out.print("The year "+year);
            System.out.print(" is in the "+century);
            System.out.println(centurySuffix+" century and "+notLeapYear); 
        }
    
        in.close();
    }

}