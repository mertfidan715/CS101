import java.util.Scanner;
public class Lab03_Q3 {
    

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String PIN = "1234";
        double initialBalance = 1000.0;

        System.out.print("Enter your PIN: ");
        String inputPIN = in.nextLine();

        if (inputPIN.equals(PIN))
        {
            System.out.printf("1- Withdraw money%n2- Open a new account%n3- Change PIN%nSelect an operation: ");
            int option = in.nextInt();
            if (option == 1)
            {
                System.out.print("Enter the amount to withdraw: ");
                double withdrawValue = in.nextDouble();
                double newBalance = (initialBalance - withdrawValue);
                System.out.println("Your new balance is "+newBalance+" TRY. Bye!");
            }
            else if (option == 2)
            {
                System.out.printf("1- TRY%n2- USD%nSelect currency type: ");
                int currencyType = in.nextInt();
                if (currencyType == 1)
                {
                    System.out.println("Your new TRY account is opened! Bye!");
                }
                else
                {
                    System.out.println("Your new USD account is opened! Bye!");
                }

            }
            else if (option == 3)
            {
                System.out.print("Enter your new PIN: ");
                String newPIN = in.next();
                System.out.println("Your PIN is changed to: "+newPIN.charAt(0)+"**"+newPIN.charAt(3)+". Bye!");
                PIN = newPIN; 
            }
        }
        else
        {
            System.out.println("Invaild PIN! Bye!");
        }

        in.close();
    }
}
