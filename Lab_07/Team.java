public class Team {
    
    private String name;
    private String abbreviation;
    private String stadiumName;
    private String city;
    private int playerCount;

    public Team(String name, String abbreviation, String stadiumName, String city){
        this.name = name;
        this.abbreviation = abbreviation;
        this.stadiumName = stadiumName;
        this.city = city;
        this.playerCount = 0;
    }

    public String getName(){
        return this.name;
    }
    
    public String getAbb(){
        return this.abbreviation;
    }
    
    public String getStadName(){
        return this.stadiumName;
    }
    
    public String getCity(){
        return this.city;
    }

    public int getCount(){
        return this.playerCount;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setAbb(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public void setStadName(String stadiumName){
        this.stadiumName = stadiumName;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCount(){
        this.playerCount++;
    }

    public void transferPlayer(Team i){
        i.playerCount++;
    }

    public void releasePlayer(Team i){
        i.playerCount--;
    }

    public void changeStadium(String stadiumName){
        this.stadiumName = stadiumName;
    }

    public void changeOwnership(String name, String abbreviation, String city){
        this.name = name;
        this.abbreviation = abbreviation;
        this.city = city;
    }

    public String toString(){
        return "*".repeat(40)+"\nTeam name: "+this.getName()+"\nAbbreviation: "+this.getAbb()+"\nNumber of players: "+this.getCount()+"\nStadium name:"+this.getStadName()+"\nCity: "+this.getCity()+"\n"+"*".repeat(40);
    }
}
