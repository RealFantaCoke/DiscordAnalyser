package DiscordGuilds.Guilds;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;

import java.util.ArrayList;
import java.util.List;

public class DiscordGuildManager {

    public static List<DiscordGuild> guilds = new ArrayList<>();

    public static void addGuild(DiscordGuild g) {
        guilds.add(g);
    }

    public static DiscordGuild getGuildById(String id) {
        for (DiscordGuild g : guilds) {
            if (g.guildId.equals(id))
                return g;
        }
        return null;
    }

    public static DiscordGuild getGuildByName(String name) {
        for (DiscordGuild g : guilds) {
            if (g.guildName.equals(name))
                return g;
        }
        return null;
    }

    public static List<DiscordMessage> searchInGuildsForMessage(String message){
        List<DiscordMessage> searchResulst = new ArrayList<>();
        for(DiscordGuild g : guilds){
            for(DiscordGuildChannel c : g.channels){
                for(DiscordMessage msg : c.messages){
                    if(msg.messageContent.contains(message)){
                        searchResulst.add(msg);
                    }
                }
            }
        }
        return searchResulst;
    }
}
