package JSONUtils;

import jdk.nashorn.internal.runtime.JSONFunctions;
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
        scanJSONforCSVFILE();
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

    public String scanJSONforCSVFILE() {
        JSONObject obj = new JSONObject(fileContents);
        for(String j : obj.keySet()){
            if(j.contains("csv")){
                System.out.println("Yeet");
            }
        }
        System.out.println(obj.get("id"));
        return "";
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
