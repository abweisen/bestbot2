package commands;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Disconnect extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith("!disconnect")) {

            if(event.getMember().hasPermission(Permission.VOICE_MOVE_OTHERS)) {

                for (Member member : event.getMessage().getMentionedMembers()) {
                      if(member.getVoiceState().inVoiceChannel()) {

                          event.getGuild().kickVoiceMember(member).queue();
                          event.getChannel().sendMessage(member.getAsMention() + " wurde erfolgreich aus dem Talk gekickt.").queue();

                      } else event.getChannel().sendMessage("Der Member " + member.getAsMention() + " ist nicht in einem Voice Channel.").queue();



                }

            } else event.getChannel().sendMessage("Du hast keine Berechtigung dazu.").queue();

        }

    }

}
