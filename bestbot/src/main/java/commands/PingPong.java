package commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingPong extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        if (e.getMessage().getContentRaw().equals("!ping")) {

            e.getChannel().sendMessage("du huan").queue();

        }

    }

}
