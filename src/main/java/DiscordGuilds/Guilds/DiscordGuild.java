package DiscordGuilds.Guilds;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;

import java.util.ArrayList;
import java.util.List;

public class DiscordGuild {
    public String guildId;
    public String guildName;
    public ArrayList<DiscordGuildChannel> channels = new ArrayList();

    public DiscordGuild(String guildId, String guildName) {
        this.guildId = guildId;
        this.guildName = guildName;
    }

    public DiscordGuildChannel getChannelByName(String name){
        for(DiscordGuildChannel channel: channels){
            if(channel.channelName == name)
                return channel;
        }
        return null;
    }

    public List<DiscordMessage> searchGuildForMessage(String message){
        List<DiscordMessage> searchResult = new ArrayList<>();
        for(DiscordGuildChannel chan : channels){
            for(DiscordMessage msg : chan.messages){
                if(msg.messageContent.contains(message)){
                    searchResult.add(msg);
                }
            }
        }
        return searchResult;
    }

    public void addChannel(DiscordGuildChannel channel){
        this.channels.add(channel);
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
