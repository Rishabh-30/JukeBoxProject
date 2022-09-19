import dao.PlaylistDao;
import dao.SongDao;
import data.Song;
import org.junit.After;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JukeBoxTest {

    @After
    public void tearDown () {

    }

    @Test
    public void getAllSongs() throws SQLException, ClassNotFoundException {
        SongDao songDao = new SongDao();
        List<Song>allSongList = songDao.getAllSongs();
        assertEquals(7, allSongList.size());
    }

    @Test
    public void songListOnTheBasisOfGenre() throws SQLException, ClassNotFoundException {
        SongDao songDao = new SongDao();
        String genre = "romantic";
        List<Song> sortedlist = songDao.songListOnTheBasisOfGenre(genre);
        assertEquals(6,sortedlist.size());
    }

    @Test
    public void songListOnTheBasisOfArtist() throws SQLException, ClassNotFoundException {
        SongDao songDao = new SongDao();
        String song_artist = "arjit";
        List<Song> sortedlist = songDao.songListOnTheBasisOfArtist(song_artist);
        assertEquals(1,sortedlist.size());
    }

    @Test
    public void songListOnTheBasisOfAlbum() throws SQLException, ClassNotFoundException {
        SongDao songDao = new SongDao();
        String song_album = "bolywood";
        List<Song> sortedlist = songDao.songListOnTheBasisOfAlbum(song_album);
        assertEquals(4,sortedlist.size());
    }

    @Test
    public void creatingAPlaylist()throws SQLException, ClassNotFoundException {
        PlaylistDao pd = new PlaylistDao();
        assertFalse(pd.getAllPlaylist().isEmpty());
        assertEquals(3, pd.getAllPlaylist().size());
    }

}