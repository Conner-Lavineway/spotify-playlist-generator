package com.sitereader;
import java.io.IOException;

public class SpotifySender 
{
    public static void main(String[] args) 
    {
        
        //Site_Reader reader = new Site_Reader();
        Authenticator speaker = new Authenticator();
        try 
        {
            //reader.run();
            speaker.getAuthCode();
            //speaker.getAlbum();

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
