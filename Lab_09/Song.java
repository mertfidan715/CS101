public class Song implements Comparable<Song>{

    private String title;
    private String artist;
    private String album;
    private int duration;
    private int timesPlayed;

    public Song(String title, String artist, String album, int duration, int timesPlayed){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.timesPlayed = timesPlayed;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getAlbum(){
        return this.album;
    }

    public int getDuration(){
        return this.duration;
    }

    public int getTimesPlayed(){
        return this.timesPlayed;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public void setTimesPlayed(int timesPlayed){
        this.timesPlayed = timesPlayed;
    }

    public int compareTo(Song song){
        int less = -1;
        int more = 1;
        int equal = 0;
        if (this.getDuration() > song.getDuration()){
            return less;
        }
        else if (this.getDuration() < song.getDuration()){
            return more;
        }
        else{
            return equal;
        }
    }

    public String toString(){
        return "Song Name: "+this.title+"\nArtist Name: "+this.artist+"\nAlbum Name: "+this.album+"\nDuration: "+(this.duration / 60)+":"+String.format("%02d",(this.duration % 60))+"\nTimes Played: "+this.timesPlayed+"\n";
    }
}