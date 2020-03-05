package DiscordGuilds.Channels;

import DiscordGuilds.DiscordGuild;

import java.util.HashMap;

public class DiscordGuildChannel {
    public String channelId;
    public String channelName;
    public DiscordGuild Guild;
    public HashMap<String, String> messages = new HashMap<>();

    public DiscordGuildChannel(String channelId, String channelName, DiscordGuild guild) {
        this.channelId = channelId;
        this.channelName = channelName;
        Guild = guild;
    }

    public void addMessage(String messageId,String messageContent) {
        this.messages.put(messageId,messageContent);
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public DiscordGuild getGuild() {
        return Guild;
    }

    public void setGuild(DiscordGuild guild) {
        Guild = guild;
    }

    public HashMap<String, String> getMessages() {
        return messages;
    }

    public void setMessages(HashMap<String, String> messages) {
        this.messages = messages;
    }
}
