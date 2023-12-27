package net.senx.ircactions.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;

public class SuicideCommand
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("killme")
            .executes((context) ->
                {
                    CommandSourceStack source = context.getSource();
                    return killme(source);
                }
            )
        );
    }

    private static int killme(CommandSourceStack source) throws CommandSyntaxException {
        // Get reference to player that has typed the command.
        ServerPlayer player = source.getPlayerOrException();

        // IF: Player is not alive.
        if(!player.isAlive()) {

            // Create error message.
            MutableComponent message = Component.literal(
                    "You are already dead. How did you manage to type this command?"
            );

            // Send error message.
            source.sendFailure(message);

            return -1;
        }

        // Kill the player.
        MutableComponent message2 = Component.literal(
                "You will be respawned at your last spawn save or at server spawn point..."
        );
        source.sendFailure(message2);
        player.kill();

        return 1;
    }
}
