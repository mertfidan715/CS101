import java.util.Scanner;
public class Lab05_Q1 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Please enter city plan string: ");
        String input = in.nextLine();
        
        int max = 0;
        for (int i = input.length() - 1; i >= 0; i--)
        {
            int currentNum=Integer.parseInt(input.charAt(i)+"");
            if (currentNum > max)
            {
                max = currentNum;
            }
        }
        
        for (int k = max; k > 0; k--)
        {
            String output = "";

            for(int q = 0; q < input.length(); q++)
            {   
                int curNum = Integer.parseInt(input.charAt(q)+"");
                if(curNum >= k)
                {
                    output+= '*';
                }
                else
                {
                    output+= ' ';
                }
            }
            System.out.println(output);
        }

        in.close();
    }
}
