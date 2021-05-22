package commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class RoleReact extends ListenerAdapter {
    final long channelID = 822473116139782168L;
    final long roleID = 822497007057764413L;

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {


      if (
            event.getTextChannel().getIdLong() == channelID) {

                Member Typ = event.getMember();
          assert Typ != null;
          event.getGuild().addRoleToMember(Typ, event.getJDA().getRoleById(roleID)).queue();



         }


      }




}
