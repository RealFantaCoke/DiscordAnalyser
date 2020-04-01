package DiscordGuilds.Groups;

import DiscordGuilds.Utils.CsvUtils.DiscordCsvFile;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;

import java.util.List;

public class DiscordGroup {
    public String id;
    public List<Object> recipients;
    public List<DiscordMessage> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Object> recipients) {
        this.recipients = recipients;
    }

    public List<DiscordMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<DiscordMessage> messages) {
        this.messages = messages;
    }

    public DiscordGroup(String id, List<Object> recipients){
        this.id = id;
        this.recipients = recipients;
        DiscordGroupManager.groups.add(this);
    }
}
