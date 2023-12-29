package net.senx.ircactions.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.senx.ircactions.dadjokes.DadJokesManager;
import net.senx.ircactions.fakeplayers.DadJokes;
import net.senx.ircactions.ircActions;
import net.senx.ircactions.utils.Chat;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = ircActions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerSpawnEventHandler
{
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ServerPlayer player = (ServerPlayer) event.getEntity();
        Chat.SendMessage(player.createCommandSourceStack(), DadJokesManager.GetRandomJoke());
    }
}
