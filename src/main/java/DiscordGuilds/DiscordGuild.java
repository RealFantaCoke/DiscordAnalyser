package DiscordGuilds;

import DiscordGuilds.Channels.DiscordGuildChannel;

import java.util.ArrayList;

public class DiscordGuild {
    public String guildId;
    public String guildName;
    public String[] messages;
    public ArrayList<DiscordGuildChannel> channels = new ArrayList();

    public DiscordGuild(String guildId, String guildName) {
        this.guildId = guildId;
        this.guildName = guildName;
    }
}
