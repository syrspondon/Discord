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
            e.getChannel().sendMessage("ho, shanto noob").queue();
        else if (a.equalsIgnoreCase("|marakha")||a.equalsIgnoreCase("|mara kha"))
            e.getChannel().sendMessage("Ghumaitesi, jalas na\nSong sunte chaile |join koray |play lekh").queue();
        else if (a.equalsIgnoreCase("<@&513390467925409833>"))
            e.getChannel().sendMessage("Outlaw is dead").queue();
        else if (a.equalsIgnoreCase("lol"))
            e.getChannel().sendMessage("L 0 L").queue();
        else if (a.equalsIgnoreCase("Rachel"))
            e.getChannel().sendMessage("Baler nam nibi na").queue();
        
        else if (a.equalsIgnoreCase("<@446335997085483029>")) //Tasin
            e.getChannel().sendMessage("Ami boba, kotha bolbo na!").queue();
        else if (a.equalsIgnoreCase("<@387264216899387392>")) //Farhan
            e.getChannel().sendMessage("আমি এখন দিশেহারা").queue();
        else if (a.equalsIgnoreCase("<@405769489808883712>")) //Saad
            e.getChannel().sendMessage("Amr ase 15, tomar ase koto?").queue();
        else if (a.equalsIgnoreCase("<@273355497783164928>")) //Ishman
            e.getChannel().sendMessage("Pro-est gamer alive").queue();
        else if (a.equalsIgnoreCase("<@649299590650265610>")) //choto Shanto
            e.getChannel().sendMessage("Nokol dot user").queue();
        else if (a.equalsIgnoreCase("<@419839150653440001>")) //boro Shanto
            e.getChannel().sendMessage("Java is life").queue();
        
        else if (a.equalsIgnoreCase("<@435077413253152770>")) //ami
            e.getChannel().sendMessage("ghumaitesi, jalash na").queue();
        else if (a.equalsIgnoreCase("<@885388273160192022>")) //bot
            e.getChannel().sendMessage("ghumaitesi, jalash na").queue();
        
        else if (a.equalsIgnoreCase("<@493855038796595200>")) //Shanto
            e.getChannel().sendMessage("pola noob").queue();
        else if (a.equalsIgnoreCase("<@640549288749039618>")) //sadman
            e.getChannel().sendMessage("ak 69kg, beshi na vaya").queue();
        else if (a.equalsIgnoreCase("<@432224139227430912>")) //sabit
            e.getChannel().sendMessage("code kortesi, jalas na").queue();
        else if (a.equalsIgnoreCase("<@493695110517751818>")) //nola
            e.getChannel().sendMessage("ami natki nola, khai sudhu kola").queue();
        else if (a.equalsIgnoreCase("<@399916757222948865>")) //mushfiqvhai
            e.getChannel().sendMessage("biye korben kbe?").queue();
        else if (a.equalsIgnoreCase("<@522834007688216587>")) //ivan
            e.getChannel().sendMessage("pola valo hoye gese (almost(almost(almost)))").queue();
        
        System.out.println(e.getMessage().getContentRaw());
    }
}
