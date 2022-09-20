package dao;

import data.Song;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDao {
    List<Song> songs = new ArrayList<>();


    public List<Song> getAllSongs() throws SQLException, ClassNotFoundException {

        List<Song> allSongsList = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs; ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            allSongsList.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return allSongsList;
    }


    public static List<Song> songListOnTheBasisOfGenre(String genre) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_genre = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,genre);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }
    public static List<Song> songListOnTheBasisOfArtist(String song_artist) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_artist = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,song_artist);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }
    public static List<Song> songListOnTheBasisOfAlbum(String song_album) throws SQLException, ClassNotFoundException {
        List<Song> sortedlist = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        String sql = "Select * from songs where song_album = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,song_album);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            sortedlist.add(new Song(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5), resultSet.getString(6)));
        }
        return sortedlist;
    }
    public static void printPlaylist(List<Song> songList) {
        System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "song_Id", "song_name", "song_album", "song_genre", "song_duration", "song_artist");
        System.out.println(" ");
        for (Song song : songList) {
            System.out.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", song.getSongId(), song.getSongName(), song.getArtist(), song.getDuration(), song.getAlbum(), song.getGenre());
        }
    }


}


