package Music;

import Music.lavaplayer.GuildMusicManager;
import Music.lavaplayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SkipCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        final TextChannel channel = e.getChannel();
        final Member self = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();
        final Member member = e.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        String a = e.getMessage().getContentRaw();

        if (a.equalsIgnoreCase("|skip")) {
            if (!selfVoiceState.inVoiceChannel())
                channel.sendMessage("Ami channel a nai to").queue();
            else {
                if (!memberVoiceState.inVoiceChannel())
                    channel.sendMessage("Voice channel asen a age").queue();
                else {
                    if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel()))
                        channel.sendMessage("Ak channel a na thakle bajabo kmne?").queue();
                    else {
                        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
                        final AudioPlayer audioPlayer = musicManager.audioPlayer;

                        if (audioPlayer.getPlayingTrack()==null)
                            channel.sendMessage("Kisu to bajtese na").queue();
                        else {
                            musicManager.scheduler.nextTrack();
                            channel.sendMessage("Skipped").queue();
                        }
                    }
                }
            }
        }
    }
}
