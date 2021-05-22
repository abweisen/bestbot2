package core;


import commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Main {
    public static void main(String[] Args) {


        EnumSet<GatewayIntent> gatewayIntents = EnumSet.allOf(GatewayIntent.class);
        JDABuilder jdaBuilder = JDABuilder.createDefault("ODINDY3NDg4NTg3NTc5NDcy.YFSsiQ.p7ckbfWldBMfsdkA4RG-cz6w25c", gatewayIntents).setMemberCachePolicy(MemberCachePolicy.ALL);
        JDA jda;
        jdaBuilder.addEventListeners(new RoleReact(), new PingPong(), new Welcome(), new RechteCheck(), new Ban(), new Kick() , new Disconnect() , new KickOnMute() , new DisconnectLog());
        try {
            jda = jdaBuilder.build();
            jda.awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}