import JSONUtils.DiscordJSONFile;

import java.io.File;
import java.io.IOException;

public class Core {
    public String name = "DiscordAnalyser";
    public String version = "v1.0 alpha";

    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.home") + "/desktop/test");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.getName().endsWith(".json")) {
                    try {
                        readJSON_CSVFile(child);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {

        }
    }

    public static void readJSON_CSVFile(File f) throws IOException {
        DiscordJSONFile discordJSONFile = new DiscordJSONFile(f);
    }

}
