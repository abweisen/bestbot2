package commands;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;

public class Kick extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

       if(event.getMessage().getContentRaw().startsWith("!kick")) {

           if(event.getMember().hasPermission(Permission.KICK_MEMBERS)) {

               for (Member member : event.getMessage().getMentionedMembers()) {

                   member.kick("Tschüssi").queue();
                   event.getChannel().sendMessage("Der Member " + member.getAsMention() + " wurde erfolgreich vom Server gekickt.").queue();
               }

           } else event.getChannel().sendMessage("Dazu hast du keine Berechtigung").queue();

        }

    }

}
