package Music;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        final TextChannel channel = e.getChannel();
        final Member self = e.getGuild().getSelfMember();
        final Member member = e.getMember();
        final GuildVoiceState selfVoiceState = self.getVoiceState();
        final GuildVoiceState memberVoiceState = member.getVoiceState();
        String a = e.getMessage().getContentRaw();

        if (a.equalsIgnoreCase("|join"))
        {
            if (selfVoiceState.inVoiceChannel())
                channel.sendMessage("Ak jaygay bose asi already").queue();
            else {
                if (!memberVoiceState.inVoiceChannel())
                    channel.sendMessage("Voice channel asen age").queue();
                else {
                    final AudioManager audioManager = e.getGuild().getAudioManager();
                    final VoiceChannel memberChannel = memberVoiceState.getChannel();

                    audioManager.openAudioConnection(memberChannel);
                    channel.sendMessageFormat("Connected hoise `\uD83D\uDD0A %s`", memberChannel.getName()).queue();
                }
            }
        }

    }
}
