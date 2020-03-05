package DiscordGuilds;

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
}
