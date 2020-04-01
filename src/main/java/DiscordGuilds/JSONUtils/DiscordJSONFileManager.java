package DiscordGuilds.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class DiscordJSONFileManager {

    public static List<DiscordJSONFile> JSONFileList = new ArrayList();

    public DiscordJSONFile getFileByName(String name){
        for(DiscordJSONFile f : JSONFileList){
            if(f.getFileName().substring(".json".length()) == name){
                return f;
            }
        }
        return null;
    }

    public static void addFile(DiscordJSONFile fileIn){
        JSONFileList.add(fileIn);
    }
}
