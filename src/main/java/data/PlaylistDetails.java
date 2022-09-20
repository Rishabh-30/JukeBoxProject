package data;

public class PlaylistDetails {
    private int playlist_Id;
    private String song_name;

    public PlaylistDetails(int playlist_Id, String song_name) {
        this.playlist_Id = playlist_Id;
        this.song_name = song_name;
    }


    public int getPlaylist_Id() {
        return playlist_Id;
    }

    public void setPlaylist_Id(int playlist_Id) {
        this.playlist_Id = playlist_Id;
    }

    public String getSong_name() {
        return song_name;
    }

    public String setSong_name(String song_name) {
        this.song_name = song_name;
        return song_name;
    }

    @Override
    public String toString() {
        return "PlaylistDetails{" +
                ", playlist_Id=" + playlist_Id +
                ", song_name='" + song_name + '\'' +
                '}';
    }
}
