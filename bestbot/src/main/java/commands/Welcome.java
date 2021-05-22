package commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Welcome extends ListenerAdapter {

@Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

    Member member = event.getMember();


    member.getUser().openPrivateChannel().queue(channel -> channel.sendMessage("Hallo du huan").queue());
}

}
