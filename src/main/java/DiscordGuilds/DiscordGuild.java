package DiscordGuilds;

import DiscordGuilds.Channels.DiscordGuildChannel;

import java.util.ArrayList;

public class DiscordGuild {
    public String guildId;
    public String guildName;
    public ArrayList<DiscordGuildChannel> channels = new ArrayList();

    public DiscordGuild(String guildId, String guildName) {
        this.guildId = guildId;
        this.guildName = guildName;

    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public ArrayList<DiscordGuildChannel> getChannels() {
        return channels;
    }

    public void setChannels(ArrayList<DiscordGuildChannel> channels) {
        this.channels = channels;
    }


}
