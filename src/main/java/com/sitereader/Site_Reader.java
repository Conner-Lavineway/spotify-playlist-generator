package com.sitereader;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class Site_Reader
{
    final int MAX_PAGES = 10;
    public void run() throws IOException
    {
        String mylink = "https://www.albumoftheyear.org/list/1500-rolling-stones-500-greatest-albums-of-all-time-2020/";
        File outputFile = new File("Output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8));
        for(int i = 1; i <= MAX_PAGES; i++)
        {
            writer.write(checkSite(mylink, i));
        }
        writer.close();
    }

    private String checkSite(String site, int page) throws IOException
    {
        String mylink = site + page;

        Connection connection = Jsoup.connect(mylink);
        connection.userAgent("Mozilla/5.0");

        Document doc = connection.get();
        
        Elements text = doc.select("h2[class=albumListTitle]");

        Iterator<org.jsoup.nodes.Element> textChecker = text.iterator();
        
        StringBuilder out = new StringBuilder();
        while(textChecker.hasNext())
        {
            StringBuffer buffer = new StringBuffer(textChecker.next().text());
            buffer.delete(0, buffer.indexOf(".") + 2);
            out.append(buffer);

            if(textChecker.hasNext())
            {
                out.append("\n");
            }
            
        }
        if(page < MAX_PAGES)
        {
            out.append("\n");
        }
        
       return out.toString();
    }

    //textChecker.next().text()  linkChecker.next().select("a[href][data-track-action=\"Spotify\"]").attr("href")
}
