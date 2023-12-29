package net.senx.ircactions.events;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.senx.ircactions.commands.DadJokeCommands;
import net.senx.ircactions.commands.SlapCommand;
import net.senx.ircactions.commands.SuicideCommand;

@Mod.EventBusSubscriber
public final class RegisterCommandsEventHandler
{
    @SubscribeEvent
    public static void onCommandsRegister(final RegisterCommandsEvent event)
    {
        SlapCommand.register(event.getDispatcher());
        SuicideCommand.register(event.getDispatcher());
        DadJokeCommands.register(event.getDispatcher());
    }
}
