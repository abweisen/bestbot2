package commands;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMuteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;
import javax.annotation.Nonnull;

public class KickOnMute extends ListenerAdapter {

    public void onGuildVoiceMute(@Nonnull GuildVoiceMuteEvent event) {


        Member member = event.getMember();
        if(event.isMuted()) {

            event.getGuild().kickVoiceMember(member).queue();

        }






    }

}
