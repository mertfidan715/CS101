import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class MusicApp_RevTue {

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        ArrayList<Song> songs = new ArrayList<Song>();
        ArrayList<Playlist_RevTue> playlists = new ArrayList<Playlist_RevTue>();
        ArrayList<String> genres = new ArrayList<String>();
        genres.add(0, "Country");
        genres.add(1, "Electronic");
        genres.add(2, "Pop Music");
        genres.add(3, "Rock Music");
        genres.add(4, "Jazz");
        genres.add(5, "Classical");
        
        System.out.print("-".repeat(57)+"\nWelcome to Music App! Get Ready to create your playlist! \n"+"-".repeat(57));
        int choice = 0;
        int playlistCount = 0;
        do{
            System.out.println("\n1 - Create a new Playlist"+"\n2 - Display the Playlist"+"\n3 - Sort the Playlist"+"\n4 - Remove song by index from the current Playlist"+"\n5 - Display all Playlists"+"\n6 - Sort the playlists"+"\n7 - Exit");
            choice = scannerInt.nextInt(); 
            if (choice == 1){
                Playlist_RevTue playlist = new Playlist_RevTue();
                System.out.println("How many songs do you want to add to playlist?:");
                int count = scannerInt.nextInt();
                for (int i = 0; i < count; i++)
                {
                    System.out.println("Enter artist name for Song "+(i + 1)+":");
                    String name = scannerStr.nextLine();
                    System.out.println("Enter album name for Song "+(i + 1)+":");                
                    String album = scannerStr.nextLine();
                    System.out.println("Enter song name for Song "+(i + 1)+":");
                    String song = scannerStr.nextLine();
                    System.out.println("Enter song duration in seconds for Song "+(i + 1)+":");
                    int duration = scannerInt.nextInt();
                    System.out.println("Enter the times song has been played for Song "+(i + 1)+":");
                    int timesPlayed = scannerInt.nextInt();
                    Song newSong = new Song(song, name, album, duration, timesPlayed);
                    playlist.addSong(newSong);
                    songs.add(newSong);
                }
                System.out.println("Enter playlist name:");
                String playlistName = scannerStr.nextLine();
                playlist.setName(playlistName);
                System.out.println("Enter creator of playlist:");
                String creatorName = scannerStr.nextLine();
                playlist.setCreator(creatorName);
                System.out.println("0-"+genres.get(0)+"\n1-"+genres.get(1)+"\n2-"+genres.get(2)+"\n3-"+genres.get(3)+"\n4-"+genres.get(4)+"\n5-"+genres.get(5)+"\nSelect genre of playlist :");
                int genreChoice = scannerInt.nextInt();
                playlist.setGenre(genres.get(genreChoice));
                playlists.add(playlist);
                playlistCount++;
            }
            else if (choice == 2){
                System.out.println("Displaying the playlist: "+playlists.get(playlistCount - 1).getName());
                System.out.println(playlists.get(playlistCount - 1).toString());
            }
            else if (choice == 3){
                System.out.println("Sorted playlists:");
                playlists.get(playlistCount - 1).sortByDurationDesc();
                System.out.println(playlists.get(playlistCount - 1).toString());
            }
            else if (choice == 4){
                System.out.println("Which song do you want to remove? (Remove by index)");
                int index = scannerInt.nextInt();
                playlists.get(playlistCount - 1).removeSong(playlists.get(playlistCount - 1).getSongs().get(index));
                System.out.println(playlists.get(playlistCount - 1));
            }
            else if (choice == 5){
                System.out.println("All playlists:\n");
                for (int i = 0; i < playlistCount; i++){
                    System.out.println(playlists.get(i).toString());
                }
            }
            else if (choice == 6){
                Collections.sort(playlists);
                System.out.println("Sorted playlists:");
                for (int i = 0; i < playlistCount; i++){
                    System.out.println(playlists.get(i).toString());
                }
            }
        }while(choice != 7);
        
        scannerInt.close();
        scannerStr.close();
    }
}
