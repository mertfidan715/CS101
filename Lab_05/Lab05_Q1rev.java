import java.util.Scanner;
public class Lab05_Q1rev {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Please enter city plan string: ");
        String input = in.nextLine();
        char D = 'D';
        
        int max = 0;
        for (int i = input.length() - 1; i >= 0; i--)
        {
            if (input.charAt(i) == D)
            {
                i--;
            }
            else
            {
                int currentNum=Integer.parseInt(input.charAt(i)+"");
                if (currentNum > max)
                {
                    max = currentNum;
                }
            }
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
                if (input.charAt(q) != D)
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
                else 
                {
                    int curNum = Integer.parseInt(input.charAt(q + 1)+"");
                    if(curNum >= k)
                    {
                        output = output + "**";
                    }
                    else
                    {
                        output+= "  ";
                    }
                    q++;
                }
            }
            System.out.println(output);
        }

        in.close();
    }
}
    