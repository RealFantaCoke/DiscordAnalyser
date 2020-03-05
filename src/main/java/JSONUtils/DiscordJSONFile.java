package JSONUtils;

import DiscordGuilds.DiscordGuild;
import DiscordGuilds.DiscordGuildManager;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DiscordJSONFile {
    public String fileName;
    public String fileContents;
    public String CSVName;

    public DiscordJSONFile(File fileIn) throws IOException {
        fileContents = readFileAsString(fileIn);
        DiscordJSONFileManager.addFile(this);
        scanFile();
    }

    public static String readFileAsString(File f) {
        String text = "";
        try {
            text = new String(Files.readAllBytes(f.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    public void scanFile() {
        JSONObject obj = new JSONObject(fileContents);
        int type = obj.getInt("type");
        switch (type) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                DiscordGuild g = new DiscordGuild(obj.getString("id"),obj.getString("name"));
                if(g.guildId != null && g.guildName != null){
                    DiscordGuildManager.addGuild(g);
                    System.out.println("Added Guild '" + g.guildName + "' to the GuildList");
                }
                break;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public String getCSVName() {
        return CSVName;
    }

    public void setCSVName(String CSVName) {
        this.CSVName = CSVName;
    }

}
