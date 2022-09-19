package dao;

import data.PlaylistDetails;
import util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PlaylistDetailsDao {
    Scanner scanner = new Scanner(System.in);

    public void addingSongsToPlayList(PlaylistDetails playlistDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getConnection();
        PreparedStatement prs=connection.prepareStatement("insert into playlist_details values(?,?)");
        prs.setInt(1, playlistDetails.getPlaylist_Id());
        prs.setString(2, playlistDetails.getSong_name());
        int rows=prs.executeUpdate();
        if(rows>0){
            System.out.println("\nsong added in the playlist successfully");
        }
        boolean response = true;
        while(response){
            System.out.println("want to add more songs in the playlist : ");
            System.out.println("press y for YES and n for NO ");
            String add = scanner.next();
            if (add.equalsIgnoreCase("y")){
                System.out.println("enter the song name which you wnat to add");
                String songName = scanner.next();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into playlist_details values(?,?)");
                preparedStatement.setInt(1, playlistDetails.getPlaylist_Id());
                preparedStatement.setString(2, playlistDetails.getSong_name());
                int row = preparedStatement.executeUpdate();
                System.out.println("another song is added successfully in the playlist ");
            }
            else {
                response = false;
            }
        }
    }
}
