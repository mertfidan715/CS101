public class Player_Rev1{

    private int id;
    private int rosterNumber;
    private double gamesPlayed = 0;
    private double pointsPerGame;
    private int pointSum = 0;
    private double assistsPerGame;
    private int assistSum = 0;
    private double reboundsPerGame;
    private int reboundSum = 0;
    private double turnoversPerGame;
    private int turnoverSum = 0;
    private double efficiency;
    private String name;
    private String position;
    private Team team;
    private String teamName;
    private boolean isActive = true;
    private static int count;
    private static int allCount;

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(String position){
        this.positionSetter(position);
    }

    public void setRosterNumber(int rosterNumber){
        this.rosterNumber = rosterNumber;
    }

    public void register(){
        allCount++;
        if (isActive)
        {
            count++;
        }
    }

    public void remove(){
        allCount--;
        if (isActive)
        {
            count--;
        }
    }

    public void retire(){
        this.isActive = false;
        count--;
        this.name = null;
        this.position = null;
        this.team = null;
        this.id = 0;
        this.rosterNumber = 0;
    }

    public void transfer(Team newTeam){
        if (this.team.equals(newTeam))
        {
            System.out.println("Player is already in that team.");
        }
        else
        {
            team.releasePlayer(team);
            this.team = newTeam;
            team.transferPlayer(newTeam);
        }
    }
    
    public String getName(){
        return this.name;
    }

    public void setTeamName(Team team){
        teamName = team.getName();
    }

    public int getID(){
        return this.id;
    }

    public String getPosition(){
        return this.position;
    }

    public String getTeam(){
        return this.team.toString();
    }

    public double getEfficiency(){
        return this.efficiency;
    }

    public Player_Rev1(String name, String position, Team team, int rosterNumber){
        this.name = name;
        this.position = position;
        this.team = team;
        this.rosterNumber = rosterNumber;
        this.register();
        this.id = allCount;
        team.setCount();
    }
    
    public boolean isBeforeThan(Player i){
        String first = this.name;
        String second = i.getName();
        int result = first.compareTo(second);
        if (result < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void positionSetter(String position){
        if (position.equals("SF")||position.equals("PF")||position.equals("SG")||position.equals("PG")||position.equals("C"))
        {
            this.position = position;
        }
        else
        {
            System.out.println("Enter a valid position.");
        }
    }

    public void recordGame(int points, int assists, int rebounds, int turnovers){
        this.gamesPlayed++;
        pointSum += points;
        assistSum += assists;
        reboundSum += rebounds;
        turnoverSum += turnovers;
        this.pointsPerGame = pointSum / this.gamesPlayed;
        this.assistsPerGame = assistSum / this.gamesPlayed;
        this.reboundsPerGame = reboundSum / this.gamesPlayed;
        this.turnoversPerGame = turnoverSum / this.gamesPlayed;
    }
    
    public double calculateEfficiency(){
        this.efficiency = 1.0 * this.pointsPerGame + 0.7 * this.assistsPerGame + 0.7 * this.reboundsPerGame - 0.9 * this.turnoversPerGame;
        return this.efficiency;
    }

    public boolean isMoreEfficient(Player i){
        if (this.calculateEfficiency() > i.calculateEfficiency())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String toString(){
        if (this.isActive == true)
        {
            setTeamName(team);
            return "*".repeat(50) + "\nPlayer ID: "+this.id+"\nPlayer Name: "+this.name+"\nPlayer Position: "+this.position+"\nCurrent Team: "+teamName+"\nJersey Number: "+this.rosterNumber+"\n"+"-".repeat(50)+"\nStats:\n"+"PPG: "+String.format("%.2f", this.pointsPerGame)+"\nAPG: "+String.format("%.2f", this.assistsPerGame)+"\nRPG: "+String.format("%.2f", this.reboundsPerGame)+"\nTPG: "+String.format("%.2f", this.turnoversPerGame)+"\nEfficiency: "+String.format("%.2f", this.calculateEfficiency())+"\n"+"-".repeat(50)+"\nRetirement Status: Active among "+count+" active player(s)\n"+"*".repeat(50);
        }
        else
        {
            setTeamName(team);
            return "*".repeat(50) + "\nPlayer ID: "+this.id+"\nPlayer Name: "+this.name+"\nPlayer Position: "+this.position+"\nCurrent Team: "+teamName+"\nJersey Number: "+this.rosterNumber+"\n"+"-".repeat(50)+"\nStats:\n"+"PPG: "+String.format("%.2f", this.pointsPerGame)+"\nAPG: "+String.format("%.2f", this.assistsPerGame)+"\nRPG: "+String.format("%.2f", this.reboundsPerGame)+"\nTPG: "+String.format("%.2f", this.turnoversPerGame)+"\nEfficiency: "+String.format("%.2f", this.calculateEfficiency())+"\n"+"-".repeat(50)+"\nRetirement Status: Retired\n"+"*".repeat(50);
        }    
    }
}
