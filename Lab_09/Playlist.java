import java.util.ArrayList;
import java.util.Collections;
public class Playlist {
    
    private String name;
    private String creator;
    private String genre;
    private ArrayList<Song> songs = new ArrayList<Song>();;

    public Playlist(){
    }

    public Playlist(String name, String creator, String genre, ArrayList<Song> songs){
        this.name = name;
        this.creator = creator;
        this.genre = genre;
        this.songs = songs;
    }

    public String getName(){
        return this.name;
    }

    public String getCreator(){
        return this.creator;
    }
    
    public String getGenre(){
        return this.genre;
    }

    public ArrayList<Song> getSongs(){
        return this.songs;
    }

    public String getSongString(){
        String allSongs = "";
        for (int i = 0; i < songs.size(); i++){
            allSongs += "\n"+songs.get(i).toString()+"-".repeat(57);
        }
        return allSongs;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCreator(String creator){
        this.creator = creator;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setSongs(Song song){
        songs.add(song);
    }

    public boolean songExists(Song song){
        return songs.contains(song);
    }

    public void addSong(Song song){
            songs.add(song);
    }

    public void removeSong(Song song){
        if (songs.contains(song)){
            songs.remove(song);
        }
    }

    public void sortByDurationDesc(){
        Collections.sort(this.getSongs());
    }

    public String toString(){
        return "-".repeat(57)+"\nPlaylist Name: "+this.name+"\nCreator Name: "+this.creator+"\nGenre: "+this.genre+"\n"+"-".repeat(57)+this.getSongString();
    }
}
