package JSONUtils;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.DiscordGuild;
import DiscordGuilds.DiscordGuildManager;
import org.json.JSONArray;
import org.json.JSONException;
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
        int type = 5;
        try {
            type = obj.getInt("type");
        } catch (JSONException e) {
        }
        switch (type) {
            case 0:
                //channel
                String id = obj.getString("id");
                String channelName = obj.getString("name");

                JSONObject guildId1 = obj.getJSONObject("guild");
                String guildId = guildId1.getString("id");
                DiscordGuild curGuild = DiscordGuildManager.getGuildById(guildId);

                DiscordGuildChannel channel = new DiscordGuildChannel(id, channelName, curGuild);
                //curGuild.addChannel(channel);
                System.out.println("Added channel '" + channelName + "' to the Guild '" + guildId +  "' ");
                break;
            case 1:
                //gruppen
                String id1 = obj.getString("id");
                break;
            case 2:
                break;
            case 3:
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
