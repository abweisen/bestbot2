package commands;

import java.time.Clock;
import net.dv8tion.jda.api.audit.ActionType;
import net.dv8tion.jda.api.audit.AuditLogChange;
import net.dv8tion.jda.api.audit.AuditLogEntry;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;

public class DisconnectLog extends ListenerAdapter {
 String Channel = "843516499247497229";
 String BotServer = "843516499247497226";

    public void onGuildVoiceMove(@Nonnull GuildVoiceMoveEvent event) {

	    String MovedPerson = event.getMember().getEffectiveName();




    	event.getGuild().retrieveAuditLogs().type(ActionType.MEMBER_VOICE_MOVE).limit(1).queue(entries -> {
		    AuditLogEntry entry = entries.get(0);

		    User moverUser = entry.getUser();
		    Member mover = event.getGuild().getMember(moverUser);

		    System.out.println(mover);
		    event.getJDA().getGuildById(BotServer).getTextChannelById(Channel).sendMessage("Der Member " + MovedPerson + " wurde von " + mover.getEffectiveName() + "auf dem " + event.getGuild().getName() + " Server gemoved.").queue();

	    });

    }

}
