package net.senx.ircactions.commands;

import net.senx.ircactions.ircActions;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.Component;
import net.senx.ircactions.fakeplayers.SlapMaster;
import net.senx.ircactions.utils.Chat;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public final class SlapCommand
{
    public static List<String> SlapResponses = new ArrayList<>();

    static
    {
        SlapResponses.add("<name> was slapped like a muppet!");
        SlapResponses.add("<name> was slapped into next week!");
        SlapResponses.add("<name> got slapped so hard, his mommas cheeks hurt!");
        SlapResponses.add("<name> got slapped around like a red headed step child!");
        SlapResponses.add("<name> got slapped by a trout!");
        SlapResponses.add("Nobody look... <name> got slapped so hard he turned inside out!!!");
        SlapResponses.add("If getting slapped was a game, <name> just won.");
        SlapResponses.add("<name> was just slapped... let's see if we can start SLAPCEPTION and everybody slap the person they think did it!");
        SlapResponses.add("<name> was just slapped for... well, does it really matter why? It's still funny!!");
        SlapResponses.add("I feel a slap-a-thon coming, <name> was first... who's next?");
        SlapResponses.add("*SLAP*  *SLAP*  *SLAP* ....   <name> just bit the dust!");
        SlapResponses.add("<name>, you just got slapped by a twat.  You're not just going to take it, are you?");
        SlapResponses.add("The mighty GIT hand just came down from the heavens and... slapped <name> clear into tomorrow!");
        SlapResponses.add("<name>, you seem to be getting slapped allot... maybe you should reconsider your life choices?");
        SlapResponses.add("Slapping <name> is as amusing as it looks, go on, try it yourself!");
        SlapResponses.add("I know we all joke about Madman being a git.... but how <name> just got slapped, they sure are!!!");
        SlapResponses.add("If geckos had hands, they would of slapped <name> too!!");
        SlapResponses.add("The itsy bitsy spider came down the water spout.... to slap <name>!");
        SlapResponses.add("I've seen some good slaps in my day, but <name> really just got a whopper!!");
        SlapResponses.add("C'mon, <name>... you know you secretly like getting slapped like this.");
        SlapResponses.add("If slaps were assholes, <name> would be the reddest of them all.");
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("actions")
            .then(Commands.literal("slap")
                .then(Commands.argument("name", EntityArgument.player())
                    .executes((context) ->
                       {
                            CommandSourceStack source = context.getSource();
                            String targeted = EntityArgument.getPlayer(context, "name").getName().getString();
                            return Slap(source, targeted);
                       }
                    )
                )
            )
        );
    }

    private static int Slap(CommandSourceStack source, String target) throws CommandSyntaxException
    {
        MutableComponent AttackerMessage = Component.literal(String.format("You slapped the shit out of %s!!", target));
        source.sendFailure(AttackerMessage);

        Chat.BroadcastMessage(ircActions.server, SlapMaster.Player, GetRandomResponse(source, target).getString());
        return 1;
    }

    private static Component GetRandomResponse(CommandSourceStack source, String target)
    {
        Random random = new Random();
        int index = random.nextInt(SlapResponses.size());
        String responseTemplate = SlapResponses.get(index);
        String newResponse = responseTemplate.replace("<name>", target);

        return Component.literal(newResponse)
            .setStyle(Style.EMPTY
                .withColor(TextColor.fromRgb(0xe30505))
                .withItalic(true)
                .withUnderlined(true)
            );
    }
}
