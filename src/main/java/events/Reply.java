package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.LinkedList;
import java.util.List;

public class Reply extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String a = e.getMessage().getContentRaw();
        if (a.equalsIgnoreCase("hello")||a.equalsIgnoreCase("hi"))
            e.getChannel().sendMessage("mara kha").queue();
        else if (a.equalsIgnoreCase("tui mara kha"))
            e.getChannel().sendMessage("na, tui kha").queue();
        else if (a.equalsIgnoreCase("Michael"))
            e.getChannel().sendMessage("That's what she said").queue();
        else if (a.equalsIgnoreCase("bolod"))
            e.getChannel().sendMessage("tui bolod shalarpoot").queue();
        else if (a.equalsIgnoreCase("pagol"))
            e.getChannel().sendMessage("pa to sobar e gol :p").queue();
        else if (a.equalsIgnoreCase("gg"))
            e.getChannel().sendMessage("ez").queue();
        else if (a.equalsIgnoreCase("noob"))
            e.getChannel().sendMessage("ho, saad noob").queue();
        else if (a.equalsIgnoreCase("|marakha")||a.equalsIgnoreCase("|mara kha"))
            e.getChannel().sendMessage("Ghumaitesi, jalas na\nSong sunte chaile |join koray |play lekh").queue();
        else if (a.equalsIgnoreCase("<@&767801627750826005>"))
            e.getChannel().sendMessage("ajaira game").queue();
        else if (a.equalsIgnoreCase("<@&513390467925409833>"))
            e.getChannel().sendMessage("Outlaw is dead").queue();
        else if (a.equalsIgnoreCase("lol"))
            e.getChannel().sendMessage("L 0 L").queue();
        else if (a.equalsIgnoreCase("Rachel"))
            e.getChannel().sendMessage("Baler nam nibi na").queue();
        else if (a.equalsIgnoreCase("<@!446335997085483029>")) //Tasin
            e.getChannel().sendMessage("Ami boba, kotha bolbo na!").queue();
        else if (a.equalsIgnoreCase("<@!387264216899387392>")) //Farhan
            e.getChannel().sendMessage("Intern, tmi kothay?").queue();
        else if (a.equalsIgnoreCase("<@!405769489808883712>")) //Saad
            e.getChannel().sendMessage("Domestic girlfriend dakh beta").queue();
        else if (a.equalsIgnoreCase("<@!273355497783164928>")) //Ishman
            e.getChannel().sendMessage("Pro-est gamer alive").queue();
        //System.out.println(e.getMessage().getContentRaw());
    }
}
