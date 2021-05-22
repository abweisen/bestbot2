package commands;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;

import javax.xml.bind.Marshaller;

public class Ban extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith("!ban")) {
            if (event.getMember().hasPermission(Permission.BAN_MEMBERS)) {

                for (Member member : event.getMessage().getMentionedMembers()) {

                    member.ban(7).queue();

                }

            } else event.getChannel().sendMessage("Du hast keine Rechte dazu!").queue();
        }
    }


}
