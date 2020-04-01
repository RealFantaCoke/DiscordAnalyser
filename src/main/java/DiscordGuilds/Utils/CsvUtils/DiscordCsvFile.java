package DiscordGuilds.Utils.CsvUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DiscordCsvFile{
    public String[] headers;
    public String[][] content;
    public File f;

    public DiscordCsvFile(String[] headers, String[][] content){
        this.headers = headers;
        this.content = content;
    }

    public DiscordCsvFile(File f){
       this. f = f;
    }

    public boolean read() {
        try {

            if(f == null)
                return false;
            List<String> lines = Files.readAllLines(f.toPath());
            content = new String[lines.size()][3];
            for(int i = 0; i < lines.size(); i++){
                String currLine = lines.get(i);
                if(currLine == null)
                    continue;
                String[] lineSplit = currLine.split(",");
                if(lineSplit[0].equals("ID") && lineSplit[1].equals("Timestamp") && lineSplit[2].equals("Contents") && lineSplit[3].equals("Attachements") || lineSplit[0].equals("ID") && lineSplit[1].equals("Timestamp") && lineSplit[2].equals("Contents")){
                    headers = lineSplit;
                }else {
                    content[i] = lineSplit;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}