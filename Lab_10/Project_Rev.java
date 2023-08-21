public class Project_Rev{

    private String ID;
    private double finalScore;
    private String segment = "";
    private String credibility;
    private double[] rawScores;
    private double[] modifiedScores;
    private Hackathon_Rev hackathon;
    private int stringHelper = 0;
    private static int INITIAL = 0;
    private static int MODIFIED = 1;
    private static int FINAL = 2;


    public Project_Rev(String ID, double[] rawScores){
        this.ID = ID;
        this.rawScores = rawScores;
    }

    public String getID(){
        return this.ID;
    }

    public String getSegment(){
        return this.segment;
    }

    public String getCredibility(){
        return this.credibility;
    }

    public double getFinalScore(){
        return this.finalScore;
    }

    public double getRawScores(int index){
        return this.rawScores[index];
    }

    public double getModifiedScores(int index){
        return this.modifiedScores[index];
    }

    public Hackathon_Rev getHackathon(){
        return this.hackathon;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public void setSegment(String segment){
        this.segment = segment;
    }

    public void setCredibility(String credibility){
        this.credibility = credibility;
    }

    public void setFinalScore(double finalScore){
        this.finalScore = finalScore;
    }

    public void setRawScores(double[] rawScores){
        this.rawScores = rawScores;
    }

    public void setModifiedScore(double[] modifiedScores){
        this.modifiedScores = modifiedScores;
    }

    public void setHackathon(Hackathon_Rev hackathon){
        this.hackathon = hackathon;
    }

    public void setStringHelper(int stringHelper){
        this.stringHelper = stringHelper;
    }

    public void calcModifiedScores(){
        modifiedScores = new double[5];
        for (int i = 0; i < rawScores.length; i++){
            modifiedScores[i] = rawScores[i];
        }
        modifiedScores[0] = rawScores[0];
        if (rawScores[1] > 0 && rawScores[1] <= 500)
            modifiedScores[1] = 20;
        else if (rawScores[1] > 500 && rawScores[1] <= 1000)
            modifiedScores[1] = 80;
        else
            modifiedScores[1] = 100;
        if (rawScores[2] > 0 && rawScores[2] <= 6)
            modifiedScores[2] = 100;
        else if (rawScores[2] > 6 && rawScores[2] <= 12)
            modifiedScores[2] = 80;
        else
            modifiedScores[2] = 20;
        if (rawScores[3] > 0 && rawScores[3] <= 10)
            modifiedScores[3] = 20;
        else if (rawScores[3] > 10 && rawScores[3] <= 15)
            modifiedScores[3] = 80;
        else
            modifiedScores[3] = 100;
        if (rawScores[4] > 0 && rawScores[4] <= 2)
            modifiedScores[4] = 1;
        else if (rawScores[4] > 2 && rawScores[4] <= 5)
            modifiedScores[4] = 20;
        else if (rawScores[4] > 5 && rawScores[4] <= 10)
            modifiedScores[4] = 80;
        else
            modifiedScores[4] = 100;
    }

    public void calcWeightAvg(){
        double result1 = (modifiedScores[0] * getHackathon().getWeight(0)) / 100;
        double result2 = (modifiedScores[1] * getHackathon().getWeight(1)) / 100;
        double result3 = (modifiedScores[2] * getHackathon().getWeight(2)) / 100;
        double result4 = (modifiedScores[3] * getHackathon().getWeight(3)) / 100;
        double result5 = (modifiedScores[4] * getHackathon().getWeight(4)) / 100;
        finalScore = result1 + result2 + result3 + result4 + result5;
    }

    public void calcSegment(){
        if (this.getFinalScore() == 100.0){
            this.setSegment("A+");
        }
        else if (this.getFinalScore() >= 90.0 && this.getFinalScore() < 100.0){
            this.setSegment("A");
        }
        else if (this.getFinalScore() >= 75.0 && this.getFinalScore() < 90.0){
            this.setSegment("B");
        }
        else if (this.getFinalScore() >= 60.0 && this.getFinalScore() < 75.0){
            this.setSegment("C");
        }
        else if (this.getFinalScore() >= 40.0 && this.getFinalScore() < 60.0){
            this.setSegment("D");
        }
    }

    public void calcCredibility(){
        if (this.rawScores[4] > 0 && this.rawScores[4] <= 2)
            this.setCredibility("REMOVED");
        else if (this.getSegment().equals("A+") && (this.modifiedScores[4] == 100 || this.modifiedScores[4] == 80 || this.modifiedScores[4] == 20)){
            this.setCredibility("INVEST");
        }    
        else if (this.getSegment().equals("A") && (this.modifiedScores[4] == 100 || this.modifiedScores[4] == 80 || this.modifiedScores[4] == 20)){
            this.setCredibility("INVEST");
        }
        else if (this.getSegment().equals("B") && (this.modifiedScores[4] == 100 || this.modifiedScores[4] == 80)){
            this.setCredibility("INVEST");
        }
        else if (this.getSegment().equals("C") && (this.modifiedScores[4] == 100)){
            this.setCredibility("INVEST");
        }
        if (this.getSegment().equals("D") && !(this.rawScores[4] > 0 && this.rawScores[4] <= 2))
            this.setCredibility("DO NOT INVEST");
    }

    public String toString(){
        if (this.stringHelper == INITIAL){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.rawScores[0])+String.format("%-15d", (int)this.rawScores[1])+String.format("%-15d", (int)this.rawScores[2])+String.format("%-15d", (int)this.rawScores[3])+String.format("%-15d", (int)this.rawScores[4])+" ".repeat(9)+"\n";
        }
        else if (this.stringHelper == MODIFIED){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.modifiedScores[0])+String.format("%-15d", (int)this.modifiedScores[1])+String.format("%-15d", (int)this.modifiedScores[2])+String.format("%-15d", (int)this.modifiedScores[3])+String.format("%-15d", (int)this.modifiedScores[4])+" ".repeat(9)+"\n";
        }
        else if (this.stringHelper == FINAL){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.rawScores[0])+String.format("%-15d", (int)this.rawScores[1])+String.format("%-15d", (int)this.rawScores[2])+String.format("%-15d", (int)this.rawScores[3])+String.format("%-15d", (int)this.rawScores[4])+String.format("%-15.2f", this.getFinalScore())+String.format("%-15s", this.getSegment())+String.format("%-15s", this.getCredibility())+"\n";
        }
        else{
            return "";
        }
    }
}
