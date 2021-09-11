package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Invite extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        int timeString = 3600;
        String[] message = e.getMessage().getContentRaw().split(" ");
        if (message.length == 1 && message[0].equalsIgnoreCase("|invite"))
        {
            e.getChannel().sendMessage("hehe, |invite please - na lekhle invite dibo na").queue();
        }
        else if(message[0].equalsIgnoreCase("|invite") && message[1].equalsIgnoreCase("please"))
        {
            e.getChannel().sendMessage("aile " + e.getAuthor().getName() + ", tor invite link").queue();
            e.getChannel().sendMessage("link: " + e.getChannel().createInvite().setMaxAge(timeString).complete().getUrl()).queue();
            e.getChannel().sendMessage(timeString/60 + " minutes por link jabega").queue();

        }
    }
}
