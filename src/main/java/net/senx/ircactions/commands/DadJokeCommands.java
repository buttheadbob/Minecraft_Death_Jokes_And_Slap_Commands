package net.senx.ircactions.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.senx.ircactions.dadjokes.DadJokesManager;
import net.senx.ircactions.fakeplayers.DadJokes;
import net.senx.ircactions.utils.Chat;

import java.util.Objects;

public class DadJokeCommands
{
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("dadjokes")
            .executes((context) ->
                    {
                        CommandSourceStack source = context.getSource();
                        return GetDadJoke(source);
                    }
            )
        );
    }

    private static int GetDadJoke(CommandSourceStack source)
    {
        Chat.SendMessage(source, DadJokesManager.GetRandomJoke());
        return 1;
    }
}
