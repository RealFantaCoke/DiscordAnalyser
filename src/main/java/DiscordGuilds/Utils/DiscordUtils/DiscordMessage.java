package DiscordGuilds.Utils.DiscordUtils;

public class DiscordMessage {

    public String messageId;
    public String messageContent;
    public String timeStamp;

    public DiscordMessage(String messageId, String timeStamp, String messageContent){
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
    }
}
