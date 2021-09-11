package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String[] message = e.getMessage().getContentRaw().split(" ");

        if (message.length == 1 && message[0].equalsIgnoreCase("|user"))
            e.getChannel().sendMessage("Amne lekh - |user [name]").queue();
        else if(message.length == 2 && message[0].equalsIgnoreCase("|user"))
        {
            String userName = message[1];
            User user = e.getGuild().getMembersByName(userName, true).get(0).getUser();
            String avatar = e.getGuild().getMembersByName(userName, true).get(0).getUser().getAvatarUrl();
            EmbedBuilder avatarEmbed = new EmbedBuilder();
            avatarEmbed.setTitle(userName + "'r khobor:", e.getGuild().getIconUrl());
            avatarEmbed.setColor(Color.CYAN);
            avatarEmbed.addField("Name", user.getName(), true);
            avatarEmbed.addField("Online Status", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            avatarEmbed.addField("Avatar: ", "The Avatar is below, " + e.getMember().getAsMention(), true);
            avatarEmbed.setImage(avatar);
            avatarEmbed.setFooter("Request made @ " + formatter.format(date), e.getGuild().getIconUrl());
            e.getChannel().sendMessage(avatarEmbed.build()).queue();
        }
    }
}
