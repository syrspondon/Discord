package Music;

import Music.lavaplayer.GuildMusicManager;
import Music.lavaplayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NowPlayingCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        final TextChannel channel = e.getChannel();
        final Member self = e.getGuild().getSelfMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();
        final Member member = e.getMember();
        final GuildVoiceState memberVoiceState = member.getVoiceState();

        String a = e.getMessage().getContentRaw();

        if (a.equalsIgnoreCase("|now")) {
            if (!selfVoiceState.inVoiceChannel())
                channel.sendMessage("Ami channel a nai to").queue();
            else {
                if (!memberVoiceState.inVoiceChannel())
                    channel.sendMessage("Voice channel asen a age").queue();
                else {
                    if (!memberVoiceState.getChannel().equals(selfVoiceState.getChannel()))
                        channel.sendMessage("Ak channel a na thakle gamer nam kmne bolbo?").queue();
                    else {
                        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
                        final AudioPlayer audioPlayer = musicManager.audioPlayer;
                        final AudioTrack track = audioPlayer.getPlayingTrack();

                        if (audioPlayer.getPlayingTrack()==null)
                            channel.sendMessage("Kisui to bajtese na").queue();
                        else {
                            final AudioTrackInfo info = track.getInfo();
                            channel.sendMessageFormat("Akhn bajtese `%s` by `%s` (Link: <%s>)", info.title, info.author, info.uri).queue();
                        }
                    }
                }
            }
        }
    }
}
