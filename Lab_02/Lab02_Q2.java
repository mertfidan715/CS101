import java.util.Scanner;
public class Lab02_Q2 {


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the odometer reading of the car in kilometers: ");
        int odometerReading = in.nextInt();
        /* Initializing the percentages as constants*/
        final int OIL_CHANGE_PERCENTAGE = 30;
        final int BATTERY_PERCENTAGE = 15;
        final int BRAKES_PERCENTAGE = 25;
        final int TIRE_PERCENTAGE = 13;
        final int OTHER_PERCENTAGE = 17;
        /* Creating strings to omit spaces in the output*/
        String oilChange = "Oil Change";
        String battery = "Battery";
        String brakes = "Brakes";
        String tire = "Tire";
        String other = "Other";
        String total = "TOTAL";
        char star = '*';
        double totalValue = (double)(odometerReading * 0.1); //Calculating total maintenance value
        double oilChangeCost = ((totalValue) * OIL_CHANGE_PERCENTAGE / 100.00);//Calculating oil change value
        double batteryCost = ((totalValue) * BATTERY_PERCENTAGE / 100.00);//Calculating total battery change cost value
        double brakesCost = ((totalValue) * BRAKES_PERCENTAGE / 100.00);//Calculating brake changing cost value
        double tireCost = ((totalValue) * TIRE_PERCENTAGE / 100.00);//Calculating tire changing cost value
        double otherCost = ((totalValue) * OTHER_PERCENTAGE / 100.00);//Calculating other remaining costs value
        
        /* Making the table of values*/
        System.out.printf("%n"+"*".repeat(49)+"%n*****  Maintenance Cost Distribution Table  *****%n"+"*".repeat(49)+"%n");
        System.out.printf("*%-21s", oilChange);
        System.out.print("%" + OIL_CHANGE_PERCENTAGE);
        System.out.printf("%18.2f", oilChangeCost);
        System.out.printf("%6s", star);
        System.out.printf("%n*%-21s", battery);
        System.out.print("%" + BATTERY_PERCENTAGE);
        System.out.printf("%18.2f", batteryCost);
        System.out.printf("%6s", star);
        System.out.printf("%n*%-21s", brakes);
        System.out.print("%" + BRAKES_PERCENTAGE);
        System.out.printf("%18.2f", brakesCost);
        System.out.printf("%6s", star);
        System.out.printf("%n*%-21s", tire);
        System.out.print("%" + TIRE_PERCENTAGE);
        System.out.printf("%18.2f", tireCost);
        System.out.printf("%6s", star);
        System.out.printf("%n*%-21s", other);
        System.out.print("%" + OTHER_PERCENTAGE);
        System.out.printf("%18.2f", otherCost);
        System.out.printf("%6s", star);
        System.out.printf("%n*%26s", total);
        System.out.printf("%16.2f", totalValue);
        System.out.printf("%6s", star);
        System.out.printf("%n"+"*".repeat(49)+"%n");
        
        
        in.close();
    }
} 
