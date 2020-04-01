package DiscordGuilds.Channels;

import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;

import java.util.ArrayList;
import java.util.List;

public class DiscordGuildChannel {
    public String channelId;
    public String channelName;
    public DiscordGuild Guild;
    public List<DiscordMessage> messages = new ArrayList<>();

    public DiscordGuildChannel(String channelId, String channelName, DiscordGuild guild) {
        this.channelId = channelId;
        this.channelName = channelName;
        Guild = guild;
    }

    public void addMessage(String messageId, String timeStamp, String messageContent) {
        this.messages.add(new DiscordMessage(messageId, timeStamp, messageContent));
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

    public List<DiscordMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<DiscordMessage> messages) {
        this.messages = messages;
    }
}
