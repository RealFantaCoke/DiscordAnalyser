import DiscordGuilds.FileType;
import DiscordGuilds.JSONUtils.DiscordJSONFile;

import java.io.File;
import java.io.IOException;

public class Core {
    public String name = "DiscordAnalyser";
    public String version = "v1.0 alpha";

    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.home") + "/desktop/test");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File folder : directoryListing) {
                File[] subFiles = folder.listFiles();
                if(folder.getName().equals("messages"))
                    checkForMessages(folder);
                else if(folder.getName().equals("servers"))
                    checkForGuilds(folder);
            }
        } else {

        }
    }

    private static void checkForGuilds(File folder) {

        for (File f : folder.listFiles()) {
            if(f.listFiles() == null)
                continue;
            for (File subFile : f.listFiles()) {
                if (subFile.getName().endsWith("guild.json")) {
                    try {

                        readGuildFile(subFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void checkForMessages(File folder) {
        for (File f : folder.listFiles()) {
            for (File subFile : f.listFiles()) {
                if (subFile.getName().endsWith(".json")) {
                    try {

                        readJSON_CSVFile(subFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void readJSON_CSVFile(File f) throws IOException {
        DiscordJSONFile discordJSONFile = new DiscordJSONFile(f, FileType.MESSAGE);
    }
    public static void readGuildFile(File f) throws IOException {
        DiscordJSONFile discordJSONFile = new DiscordJSONFile(f, FileType.GUILD);
    }
}
