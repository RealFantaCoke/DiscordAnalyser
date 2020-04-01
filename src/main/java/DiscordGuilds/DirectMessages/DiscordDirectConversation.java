package DiscordGuilds.DirectMessages;

import DiscordGuilds.Utils.DiscordUtils.DiscordMessage;

import java.util.List;

public class DiscordDirectConversation {
    public String id;
    public List<DiscordMessage> messages;

    public DiscordDirectConversation(String id){
        this.id = id;
        DiscordDirectConversationManager.directConversations.add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DiscordMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<DiscordMessage> messages) {
        this.messages = messages;
    }
}
