package net.senx.ircactions.commands;

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
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
        SlapResponses.add("");
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

        Chat.BroadcastMessage(source.getServer(), SlapMaster.Player, GetRandomResponse(source, target).getString());
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
