package DiscordGuilds.Utils.DiscordUtils;

import DiscordGuilds.Channels.DiscordGuildChannel;
import DiscordGuilds.DirectMessages.DiscordDirectConversation;
import DiscordGuilds.DirectMessages.DiscordDirectConversationManager;
import DiscordGuilds.Groups.DiscordGroup;
import DiscordGuilds.Groups.DiscordGroupManager;
import DiscordGuilds.Guilds.DiscordGuild;
import DiscordGuilds.Guilds.DiscordGuildManager;

import java.util.ArrayList;
import java.util.List;

public class DiscordUtil {

    public static List<DiscordMessage> searchDiscordForMessage(String message){
        List<DiscordMessage> searchResults = new ArrayList<>();
        for(DiscordGuild g : DiscordGuildManager.guilds){
            for(DiscordGuildChannel c : g.channels){
                for(DiscordMessage msg : c.messages){
                    if(msg.messageContent.contains(message))
                        searchResults.add(msg);
                }
            }
        }
        for(DiscordGroup group : DiscordGroupManager.groups){
            for(DiscordMessage msg : group.messages){
                if(msg.messageContent.contains(message))
                    searchResults.add(msg);
            }
        }
        for(DiscordDirectConversation directConversation : DiscordDirectConversationManager.directConversations){
            for(DiscordMessage msg : directConversation.messages){
                if(msg.messageContent.contains(message)){
                    searchResults.add(msg);
                }
            }
        }
        return searchResults;
    }
    public static String printOutSearchResults(String search){
        StringBuilder sb = new StringBuilder();
        for(DiscordMessage msg : DiscordUtil.searchDiscordForMessage(search)){
            sb.append(msg.messageId + ": " + msg.messageContent + "\n");
        }
        return sb.toString();
    }
}
