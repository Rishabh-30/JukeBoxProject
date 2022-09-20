package util;

// Java program to play an Audio
// file using Clip Object
import data.PlaylistDetails;
import data.Song;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMusic {

    public void PlaySong(String song_name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        try{
            String path="src/main/resources/songs/"+song_name+".wav";
            File file = new File(path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while(!response.equals("Q")) {
                System.out.println("P = play, T= Pause, S=Stop, L=Loop, R = Reset, Q = Quit, N = Next");
                System.out.print("Enter your choice: ");

                response = scanner.next();
                response = response.toUpperCase();

                switch(response) {
                    case ("P"): {
                        clip.start();
                        long clip_position = clip.getMicrosecondPosition();

                        break;
                    }
                    case ("T"): {
                        clip.stop();
                        long clip_position = clip.getMicrosecondPosition();
                        break;
                    }
                    case("S"):{
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }
                    case("L"):{
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("R"): clip.setMicrosecondPosition(0);
                        break;

                    case ("Q"): clip.close();
                        break;
                    case("N"):
                        clip.stop();
                        System.out.println("Enter the song name which you want to play");
                        scanner.nextLine();
                        String songname = scanner.nextLine();
                        try{
                            PlaySong(song_name);
                        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
                            throw new RuntimeException(e);
                    }
                        break;
                    default: System.out.println("Not a valid response");
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }


}

