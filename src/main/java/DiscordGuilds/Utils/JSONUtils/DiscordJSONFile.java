package DiscordGuilds.Utils.JSONUtils;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.ComponentType;
import DiscordGuilds.DirectMessages.DiscordDirectConversation;
import DiscordGuilds.Groups.DiscordGroup;
import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Guilds.DiscordGuildManager;
import DiscordGuilds.FileType;
import DiscordGuilds.Utils.CsvUtils.DiscordCsvFile;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DiscordJSONFile {
    public String fileName;
    public String fileContents;
    public String CSVName;
    public File currFile;
    public String output;
    JSONObject obj;

    public DiscordJSONFile(File fileIn, FileType fileType) throws IOException {
        currFile = fileIn;
        fileContents = readFileAsString(fileIn);
        DiscordJSONFileManager.addFile(this);
        obj = new JSONObject(fileContents);
        if (fileType == FileType.GUILD)
            scanForGuilds();
        else if (fileType == FileType.MESSAGE)
            scanForChannels();

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

    public void scanForGuilds() {

        int type = 5;
        try {
            type = obj.getInt("type");
        } catch (JSONException e) {
        }

        if (type == 5) {
            String guild_id = obj.getString("id");
            String guild_name = obj.getString("name");
            DiscordGuild g = new DiscordGuild(guild_id, guild_name);
            DiscordGuildManager.addGuild(g);
            System.out.println("Added guild '" + guild_name + "' to the Guild list");
        }
    }

    public boolean scanForChannels() {
        //channel
        ComponentType type = null;
        try {
            type = ComponentType.values()[obj.getInt("type") <= 4 ? obj.getInt("type") : 0];
        } catch (JSONException e) {
            System.out.println("[ERROR] No type in file " + currFile.getName());
        }

        if (type == ComponentType.CHANNEL && !DiscordGuildManager.guilds.isEmpty()) {
            String id = null;
            String channelName = null;
            try {
                id = obj.getString("id");
                channelName = obj.getString("name");
            }catch(JSONException e){

                DiscordDirectConversation directConv = new DiscordDirectConversation(id);
                File csv = new File(currFile.getParent() + "/messages.csv");
                DiscordCsvFile csvFile = new DiscordCsvFile(csv);
                if (csvFile.read()) {
                    List<DiscordMessage> messages = new ArrayList<>();
                    for (String[] currLine : csvFile.content) {
                        if(currLine.length < 4)
                            continue;
                        messages.add(new DiscordMessage(currLine[0], currLine[1], currLine[2]));
                        System.out.println("Current Message for DirectConversation [" + id + "]: " + currLine[0] + " " + currLine[1] + " " + currLine[2]);
                    }
                    directConv.setMessages(messages);
                } else {
                    System.out.println("[ERROR] Something went wrong reading the csv File!");
                }
                return true;
            }
            JSONObject guildId1 = obj.getJSONObject("guild");
            String guildId = guildId1.getString("id");
            DiscordGuild curGuild = DiscordGuildManager.getGuildById(guildId);
            DiscordGuildChannel channel = new DiscordGuildChannel(id, channelName, curGuild);
            File csv = new File(currFile.getParent() + "/messages.csv");
            DiscordCsvFile csvFile = new DiscordCsvFile(csv);
            if (csvFile.read()) {
                List<DiscordMessage> messages = new ArrayList<>();
                for (String[] currLine : csvFile.content) {
                    if(currLine.length < 4)
                        continue;
                    messages.add(new DiscordMessage(currLine[0], currLine[1], currLine[2]));
                    System.out.println("Current Message for " + channel.channelName + ": " + currLine[0] + " " + currLine[1] + " " + currLine[2]);
                }
                channel.setMessages(messages);
            } else {
                System.out.println("[ERROR] Something went wrong reading the csv File!");
            }
            curGuild.addChannel(channel);
            System.out.println("Added channel '" + channelName + "' to the Guild '" + curGuild.getGuildName() + "' ");
        } else if (type == ComponentType.GROUP) {
            DiscordGroup group = new DiscordGroup(obj.getString("id"), obj.getJSONArray("recipients").toList());
            File csv = new File(currFile.getParent() + "/messages.csv");
            DiscordCsvFile csvFile = new DiscordCsvFile(csv);
            if (csvFile.read()) {
                List<DiscordMessage> messages = new ArrayList<>();
                for (String[] currLine : csvFile.content) {
                    if(currLine.length < 4)
                        continue;
                    messages.add(new DiscordMessage(currLine[0], currLine[1], currLine[2]));
                    System.out.println("Current Message for " + group.id + ": " + currLine[0] + " " + currLine[1] + " " + currLine[2]);
                }
                group.setMessages(messages);
            } else {
                System.out.println("[ERROR] Something went wrong reading the csv File!");
            }
        }
        return true;
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
