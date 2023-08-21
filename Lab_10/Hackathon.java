public class Hackathon {
    
    private int projectCount;
    private Project[] projects;
    private static final int MAX_NO_OF_PROJECTS = 6;
    private static final int INDICATOR_COUNT = 4;
    private static final double[] INDICATOR_WEIGHTS = {10, 25, 30, 35};

    public Hackathon(int projectCount, Project[] projects){
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

    public Project[] getProjects(){
        return this.projects;
    }

    public void addProject(Project project){
        projects[projectCount] = project;
        projectCount++;
        project.setHackathon(this);
    }

    public static void main(String[] args) {
        
        Project[] projects = new Project[6];
        
        Hackathon hackathon = new Hackathon(0, projects);

        double[] rawScores1 = {100, 240, 15, 26};
        Project project1 = new Project("A1", rawScores1);
        hackathon.addProject(project1);
        double[] rawScores2 = {20, 407, 13, 11};
        Project project2 = new Project("A2", rawScores2);
        hackathon.addProject(project2);
        double[] rawScores3 = {100, 281, 13, 39};
        Project project3 = new Project("A3", rawScores3);
        hackathon.addProject(project3);
        double[] rawScores4 = {80, 1264, 4, 38};
        Project project4 = new Project("A4", rawScores4);
        hackathon.addProject(project4);
        double[] rawScores5 = {20, 1020, 12, 11};
        Project project5 = new Project("A5", rawScores5);
        hackathon.addProject(project5);
        double[] rawScores6 = {100, 1162, 17, 34};
        Project project6 = new Project("A6", rawScores6);
        hackathon.addProject(project6);
        project1.setStringHelper(0);
        project2.setStringHelper(0);
        project3.setStringHelper(0);
        project4.setStringHelper(0);
        project5.setStringHelper(0);
        project6.setStringHelper(0);

        System.out.println("Initial Table\n"+"*".repeat(71)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(71));
        
        for (Project p : projects) {
            p.calcModifiedScores();
            p.calcWeightAvg();
            p.calcSegment();
            p.calcCredibility();
            p.setStringHelper(1);

        }

        System.out.println("Modified Table\n"+"*".repeat(71)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(71));

        project1.setStringHelper(2);
        project2.setStringHelper(2);
        project3.setStringHelper(2);
        project4.setStringHelper(2);
        project5.setStringHelper(2);
        project6.setStringHelper(2);

        System.out.println("Final Table\n"+"*".repeat(120)+"\n"+"Project ID     Indicator 1    Indicator 2    Indicator 3    Indicator 4    Weighted Mean  Segment        Credibility\n"+project1.toString()+project2.toString()+project3.toString()+project4.toString()+project5.toString()+project6.toString()+"*".repeat(120));

    }
}
