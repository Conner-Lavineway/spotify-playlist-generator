package com.sitereader;

import java.io.IOException;

public class SpotifySender 
{
    public static void main(String[] args) 
    {
        
        Site_Reader reader = new Site_Reader();
        try 
        {
            reader.run();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
