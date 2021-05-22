package commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RechteCheck extends ListenerAdapter {

    public void onMessageRecieved(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith("!mute")) {



                for (Member member : event.getMessage().getMentionedMembers()) {
                    if (member.getVoiceState().isMuted()) {

                        event.getChannel().sendMessage("ja er ist muted").queue();

                    } else event.getChannel().sendMessage("nein ist er nicht");

                }



        }

    }
}
