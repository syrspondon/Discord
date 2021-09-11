package Music;

import Music.lavaplayer.PlayerManager;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.net.URL;

public class PlayCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        final TextChannel channel = e.getChannel();
        final Member self = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();
        final Member member = e.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        String[] a = e.getMessage().getContentRaw().split(" ");
        String link = "ytsearch:";

        if (a[0].equalsIgnoreCase("|play")||a[0].equalsIgnoreCase("|p")) {
            if (!selfVoiceState.inVoiceChannel())
                channel.sendMessage("Ami channel a nai to").queue();
            else {
                if (!memberVoiceState.inVoiceChannel())
                    channel.sendMessage("Voice channel asen a age").queue();
                else {
                    if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel()))
                        channel.sendMessage("Ak channel a na thakle bajabo kmne?").queue();
                    else {
                        if (a.length < 2)
                            channel.sendMessage("Amne lekhen -  |play SongName").queue();
                        else {
                            if (isUrl(a[1]))
                                link = a[1];
                            else
                                for (int i = 1; i < a.length; i++)
                                    link += a[i];
                            PlayerManager.getInstance().loadAndPlay(channel, link);
                        }
                    }
                }
            }
        }
    }
    private boolean isUrl(String urlS) {
        try
        {
            URL url = new URL(urlS);
            url.toURI();
            return true;
        } catch (Exception exception)
        {
            return false;
        }
    }
}
