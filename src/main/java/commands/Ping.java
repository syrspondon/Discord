package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String q = e.getMessage().getContentRaw();
        if(q.equalsIgnoreCase("|ping"))
        {
            long ping = e.getJDA().getGatewayPing();
            String a = ""+ping;
            e.getChannel().sendMessage(a).queue();
        }
    }
}
