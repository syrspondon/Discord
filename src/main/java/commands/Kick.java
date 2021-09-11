package commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        final TextChannel channel = e.getChannel();
        final Message message = e.getMessage();
        final Member member = e.getMember();
        final String reason = "bye bye";
        String[] q = e.getMessage().getContentRaw().split(" ");

        if(q[0].equalsIgnoreCase("|kick")){
            if (message.getMentionedMembers().isEmpty())
                channel.sendMessage("Member ar nam lekh sathe").queue();
            else {
                final Member ami = e.getGuild().getSelfMember();
                final Member target = message.getMentionedMembers().get(0);
                if (!member.canInteract(target))
                    channel.sendMessage("Parbona1").queue();
                else {
                    if (!ami.canInteract(target)||!ami.hasPermission(Permission.KICK_MEMBERS))
                        channel.sendMessage("Parbona2").queue();
                    else {
                        e.getGuild().kick(target,reason).reason(reason).queue(
                                (__)-> channel.sendMessage("Gese ga").queue(),
                                (error)-> channel.sendMessage(error.getMessage()).queue()
                        );
                    }
                }
            }




        }


    }

}
