public class Lab01_Q3 {
    

    public static void main(String[] args) {
        final long TOTAL_AREA = 510072000;
        final long AREA_OF_TURKEY = (long)(TOTAL_AREA * 0.001536);//Calculating the total area of Turkey by using the fraction = Total Area of Turkey/Total Area of the Earth
        double waterPercentageEarth = 70.8; //Dry land percentage in the world
        double waterPercentageTurkey = 1.3; // Percentage of water in Turkey
        long dryLandEarth = (long)((100 - waterPercentageEarth)/100 * TOTAL_AREA); //Calculating the total dry land in Earth
        long waterEarth = (long)(waterPercentageEarth / 100 * TOTAL_AREA);//Calculating the total water in Earth
        double dryLandTurkey = (long)(AREA_OF_TURKEY * (100 - waterPercentageTurkey) / 100);//Calculating the total dry land in Turkey
        double waterTurkey = (long)(AREA_OF_TURKEY * waterPercentageTurkey / 100);//Calculating the total water in Turkey
        double percentageLandTurkey = ((dryLandTurkey / dryLandEarth) * 100);//Percentage of Turkey's land with regards to total dry land of Earth
        double percentageWaterTurkey = ((waterTurkey / waterEarth) * 100);//Percentage of Turkey's water with regards to total water of Earth

        
        System.out.print("Earth has "+dryLandEarth);
        System.out.print(" km2 dry land and "+waterEarth);
        System.out.println(" km2 water.");
        System.out.printf("Turkey has %.0f " , dryLandTurkey);
        System.out.printf("km2 dry land and %.0f " , waterTurkey);
        System.out.println("km2 water.");
        System.out.printf("Turkey has %.15f" , percentageLandTurkey);
        System.out.println(" percent of the Earth's dry land.");
        System.out.printf("Turkey has %.16f" , percentageWaterTurkey);
        System.out.println(" percent of the Earth's water.");

        System.out.println("");
        
        /* The next part is for revision */

        final long AREA_OF_GREECE = 131957;//Total area of Greece
        double waterPercentageGreece = 1.51; // Percentage of water in Greece
        double dryLandGreece = (long)(AREA_OF_GREECE * (100 - waterPercentageGreece) / 100);//Calculating the total dry land in Greece
        double waterGreece = (long)(AREA_OF_GREECE * waterPercentageGreece / 100);//Calculating the total water in Greece
        double percentageLandGreece = ((dryLandGreece / dryLandEarth) * 100);//Percentage of Greece's land with regards to total dry land of Earth
        double percentageWaterGreece = ((waterGreece / waterEarth) * 100);//Percentage of Greece's water with regards to total water of Earth


        System.out.print("Earth has "+dryLandEarth);
        System.out.print(" km2 dry land and "+waterEarth);
        System.out.println(" km2 water.");
        System.out.printf("Greece has %.0f " , dryLandGreece);
        System.out.printf("km2 dry land and %.0f " , waterGreece);
        System.out.println("km2 water.");
        System.out.printf("Greece has %.15f" , percentageLandGreece);
        System.out.println(" percent of the Earth's dry land.");
        System.out.printf("Greece has %.16f" , percentageWaterGreece);
        System.out.println(" percent of the Earth's water.");
        


    }
}
