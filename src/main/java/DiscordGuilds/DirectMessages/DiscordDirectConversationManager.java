package DiscordGuilds.DirectMessages;

import java.util.ArrayList;

public class DiscordDirectConversationManager {
    public static ArrayList<DiscordDirectConversation> directConversations = new ArrayList<>();


    public static DiscordDirectConversation getConversationById(String id){
        for(DiscordDirectConversation conv : directConversations){
            if(id == conv.id)
                return conv;

        }
        return null;
    }
}
