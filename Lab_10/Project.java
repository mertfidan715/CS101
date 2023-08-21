public class Project{

    private String ID;
    private double finalScore;
    private String segment;
    private String credibility;
    private double[] rawScores;
    private double[] modifiedScores;
    private Hackathon hackathon;
    private int stringHelper = 0;
    private static int INITIAL = 0;
    private static int MODIFIED = 1;
    private static int FINAL = 2;


    public Project(String ID, double[] rawScores){
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

    public double[] getRawScores(){
        return this.rawScores;
    }

    public double[] getModifiedScores(){
        return this.modifiedScores;
    }

    public Hackathon getHackathon(){
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

    public void setHackathon(Hackathon hackathon){
        this.hackathon = hackathon;
    }

    public void setStringHelper(int stringHelper){
        this.stringHelper = stringHelper;
    }

    public void calcModifiedScores(){
        modifiedScores = rawScores;
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
    }

    public void calcWeightAvg(){
        double result1 = (modifiedScores[0] * getHackathon().getWeight(0)) / 100;
        double result2 = (modifiedScores[1] * getHackathon().getWeight(1)) / 100;
        double result3 = (modifiedScores[2] * getHackathon().getWeight(2)) / 100;
        double result4 = (modifiedScores[3] * getHackathon().getWeight(3)) / 100;
        finalScore = result1 + result2 + result3 + result4;
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
        else if (this.getFinalScore() >= 60.0 && this.getFinalScore() < 70.0){
            this.setSegment("C");
        }
        else if (this.getFinalScore() >= 40.0 && this.getFinalScore() < 60.0){
            this.setSegment("D");
        }
    }

    public void calcCredibility(){
        if (this.getSegment().equals("A+")){
            this.setCredibility("Perfect");
        }
        else if (this.getSegment().equals("A")){
            this.setCredibility("Very Good");
        }
        else if (this.getSegment().equals("B")){
            this.setCredibility("Good");
        }
        else if (this.getSegment().equals("C")){
            this.setCredibility("Considerable");
        }
        else if (this.getSegment().equals("D")){
            this.setCredibility("Not appropriate");
        }
    }

    public String toString(){
        if (this.stringHelper == INITIAL){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.rawScores[0])+String.format("%-15d", (int)this.rawScores[1])+String.format("%-15d", (int)this.rawScores[2])+String.format("%-15d", (int)this.rawScores[3])+" ".repeat(9)+"\n";
        }
        else if (this.stringHelper == MODIFIED){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.modifiedScores[0])+String.format("%-15d", (int)this.modifiedScores[1])+String.format("%-15d", (int)this.modifiedScores[2])+String.format("%-15d", (int)this.modifiedScores[3])+" ".repeat(9)+"\n";
        }
        else if (this.stringHelper == FINAL){
            return String.format("%-15s", this.getID())+String.format("%-15d", (int)this.rawScores[0])+String.format("%-15d", (int)this.rawScores[1])+String.format("%-15d", (int)this.rawScores[2])+String.format("%-15d", (int)this.rawScores[3])+String.format("%-15.2f", this.getFinalScore())+String.format("%-15s", this.getSegment())+String.format("%-15s", this.getCredibility())+"\n";
        }
        else{
            return "";
        }
    }
}