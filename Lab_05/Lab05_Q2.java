import java.util.Random;
import java.util.Scanner;

public class Lab05_Q2 {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        String deck = "";

        for (int i = 1; i <= 9; i++) 
        {
            for (int q = 1; q <= 4; q++) 
            {
                deck += i;
            }

        }
        System.out.printf("Starting game with the following deck:%n" + deck + "%n%n");

        String player = "";
        String dealer = "";
        int playerSum = 0;
        int dealerSum = 0;
        for (int i = 1; i <= 4; i++) {
            int randomChoice = rand.nextInt(deck.length());
            if (i % 2 != 0) 
            {
                player += deck.charAt(randomChoice);
            } else 
            {
                dealer += deck.charAt(randomChoice);
            }
            String first = deck.substring(0, randomChoice);
            String last = deck.substring(randomChoice + 1);
            deck = first + last;
        }

        for (int k = 0; k < player.length(); k++) 
        {
            playerSum += Integer.parseInt(player.charAt(k)+"");
        }
        for (int k = 0; k < dealer.length(); k++) 
        {
            dealerSum += Integer.parseInt(dealer.charAt(k)+"");
        }

        System.out.println("Dealer is now dealing cards...");
        System.out.printf("Player's hand:%n" + player + "%nDealer's hand:%n" + dealer.charAt(0) + "?%n%n");

        int choice = 0;
        do {
            System.out.println("Please enter your choice:");
            System.out.printf("1) Hit%n2) Stand%n");
            choice = in.nextInt();
            if (choice == 1) 
            {
                System.out.println(" ");
                System.out.println("Hit! Dealer is giving the player a card...");
                int randomChoice2 = rand.nextInt(deck.length());
                player += deck.charAt(randomChoice2);
                String first2 = deck.substring(0, randomChoice2);
                String last2 = deck.substring(randomChoice2 + 1);
                deck = first2 + last2;
                System.out.printf("Player's hand:%n" + player + "%n%n");
                playerSum += Integer.parseInt(player.charAt(player.length()-1)+"");
            }
        } while (choice != 2 && playerSum < 21);

        if (playerSum == 21)
        {
            System.out.printf("Player scored 21. Player wins!%n%n");
        }
        else if (playerSum > 21)
        {
            System.out.printf("Player scored over 21. Player lost!%n%n");
        }
        
        if (choice == 2) 
        {
            System.out.println("Stand! Player's turn is now over. Player's hand sums to " + playerSum);
            System.out.println(" ");
            System.out.println("Dealer is drawing cards...");
            
            do
            {
                int randomChoice3 = rand.nextInt(deck.length());
                dealer += deck.charAt(randomChoice3);
                String first3 = deck.substring(0, randomChoice3);
                String last3 = deck.substring(randomChoice3 + 1);
                deck = first3 + last3;
                System.out.printf("Dealer's hand:%n" + dealer + "%n");
                dealerSum += Integer.parseInt(dealer.charAt(dealer.length()-1)+"");
            }while (dealerSum < 21 && dealerSum <= playerSum);

            System.out.println(" ");
            
            if (dealerSum == 21)
            {
                System.out.printf("Dealer scored 21. Dealer wins!%n%n");
            }
            else if (dealerSum > playerSum && dealerSum < 21)
            {
                System.out.printf("Dealer scored more than player. Dealer wins!%n%n");
            }
            else if (dealerSum > 21)
            {
                System.out.printf("Dealer scored over 21. Dealer lost!%n%n");
            }
        }

        System.out.printf("Ending the game with the following deck:%n"+deck+"%n");


        in.close();
    }
}