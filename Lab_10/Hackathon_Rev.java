public class Hackathon_Rev {
    
    private int projectCount;
    private Project_Rev[] projects;
    private String[][] decisions = new String[MAX_NO_OF_PROJECTS][MAX_NO_OF_PROJECTS];
    private int[] index;
    private int[] maxGoals;
    private int[] maxDurations;
    private static final int MAX_NO_OF_PROJECTS = 6;
    private static final int INDICATOR_COUNT = 5;
    private static final double[] INDICATOR_WEIGHTS = {10, 20, 30, 35, 5};

    public Hackathon_Rev(int projectCount, Project_Rev[] projects){
        this.projectCount = projectCount;
        this.projects = projects;
    }

    public static int getMaxNoOfProjects(){
        return MAX_NO_OF_PROJECTS;
    }

    public static int getIndicatorCount(){
        return INDICATOR_COUNT;
    }

    public static double[] getIndicatorWeights(){
        return INDICATOR_WEIGHTS;
    }

    public double getWeight(int index){
        return INDICATOR_WEIGHTS[index];
    }

    public int getProjectCount(){
        return this.projectCount;
    }

    public Project_Rev[] getProjects(){
        return this.projects;
    }

    public void addProject(Project_Rev project){
        projects[projectCount] = project;
        projectCount++;
        project.setHackathon(this);
    }

    public int maxCalc(int[] x){
        int max = 0;
        for (int i = 0; i < x.length; i++){
            if (x[i] > max){
                max = x[i];
            }
        }
        return max;
    }

    public String[][] makeDecision(){
        decisions[1][1] = String.format("%-15s", "ProjectID");
        decisions[1][2] = String.format("%-15s", "Goals");
        decisions[1][3] = String.format("%-15s", "Duration");
        decisions[5][1] = String.format("%9s", "MAX:");
        int numberOfInvestments = 0;
        for (int i = 0; i < projects.length; i++){
            if (projects[i].getCredibility().equals("INVEST")){
                numberOfInvestments++;
            }
        }
        index = new int[numberOfInvestments];
        int indexCounter = 0;
        for (int i = 0; i < projects.length; i++){
            if (projects[i].getCredibility().equals("INVEST")){
                index[indexCounter] = i;
                indexCounter++;
            }
        }
        maxDurations = new int[indexCounter];
        maxGoals = new int[indexCounter];
        for (int i = 0; i < index.length; i++){
            decisions[i+2][1] = String.format("%-15s", projects[index[i]].getID());
        }
        for (int i = 0; i < index.length; i++){
            decisions[i+2][2] = String.format("%-15d", (int)projects[index[i]].getRawScores(4));
            maxGoals[i] = (int)projects[index[i]].getRawScores(4);
        }
        for (int i = 0; i < index.length; i++){
            decisions[i+2][3] = String.format("%-15d", (int)projects[index[i]].getRawScores(2));
            maxDurations[i] = (int)projects[index[i]].getRawScores(2);
        }
        decisions[5][2] = String.format("%8d", maxCalc(maxGoals));
        decisions[5][3] = String.format("%15d", maxCalc(maxDurations));
        return decisions;
    }

    public String getDecision(int x, int y){
        return this.decisions[x][y];
    }

    public static void main(String[] args) {
        
        Project_Rev[] projects = new Project_Rev[6];
        
        Hackathon_Rev hackathon = new Hackathon_Rev(0, projects);

        double[] rawScores1 = {100, 240, 15, 26, 12};
        Project_Rev project1 = new Project_Rev("A1", rawScores1);
        hackathon.addProject(project1);
        double[] rawScores2 = {20, 407, 13, 11, 1};
        Project_Rev project2 = new Project_Rev("A2", rawScores2);
        hackathon.addProject(project2);
        double[] rawScores3 = {100, 281, 13, 39, 9};
        Project_Rev project3 = new Project_Rev("A3", rawScores3);
        hackathon.addProject(project3);
        double[] rawScores4 = {80, 1264, 4, 38, 7};
        Project_Rev project4 = new Project_Rev("A4", rawScores4);
        hackathon.addProject(project4);
        double[] rawScores5 = {20, 1020, 12, 11, 1};
        Project_Rev project5 = new Project_Rev("A5", rawScores5);
        hackathon.addProject(project5);
        double[] rawScores6 = {100, 1162, 17, 34, 6};
        Project_Rev project6 = new Project_Rev("A6", rawScores6);
        hackathon.addProject(project6);
        project1.setStringHelper(0);
        project2.setStringHelper(0);
        project3.setStringHelper(0);
        project4.setStringHelper(0);
        project5.setStringHelper(0);
        project6.setStringHelper(0);

        System.out.println("Initial Table\n"+"*".repeat(86)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4    Indicator 5\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(86));

        for (Project_Rev p : projects) {
            p.calcModifiedScores();
            p.calcWeightAvg();
            p.calcSegment();
            p.calcCredibility();
            p.setStringHelper(1);
        }

        System.out.println("Modified Table\n"+"*".repeat(86)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4    Indicator 5\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(86));

        project1.setStringHelper(2);
        project2.setStringHelper(2);
        project3.setStringHelper(2);
        project4.setStringHelper(2);
        project5.setStringHelper(2);
        project6.setStringHelper(2);

        System.out.println("Final Table\n"+"*".repeat(135)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4    Indicator 5    Weighted Mean  Segment        Credibility\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(135));
        hackathon.makeDecision();
        System.out.println("Investment Decision\n"+"*".repeat(45)+"\n"+hackathon.getDecision(1, 1)+hackathon.getDecision(1, 2)+hackathon.getDecision(1, 3)+"\n"+hackathon.getDecision(2, 1)+hackathon.getDecision(2, 2)+hackathon.getDecision(2, 3)+"\n"+hackathon.getDecision(3, 1)+hackathon.getDecision(3, 2)+hackathon.getDecision(3, 3)+"\n"+hackathon.getDecision(4, 1)+hackathon.getDecision(4, 2)+hackathon.getDecision(4, 3)+"\n"+"-".repeat(45)+"\n"+hackathon.getDecision(5, 1)+hackathon.getDecision(5, 2)+hackathon.getDecision(5, 3)+"\n"+"*".repeat(45));
    }
}
