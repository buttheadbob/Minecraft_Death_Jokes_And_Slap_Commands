package net.senx.ircactions.utils;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

public class Chat
{
    public static void BroadcastMessage(MinecraftServer server, ServerPlayer sender, String message)
    {
        List<ServerPlayer> players = new ArrayList<>();

        for (ServerLevel level : server.getAllLevels())
        {
            players.addAll(level.players());
        }

        for (ServerPlayer player : players)
        {
            if (player == null) continue;

            MutableComponent messageComp = Component.literal(message);
            player.createCommandSourceStack().sendSuccess(()-> messageComp, false);
        }
    }

    public static void SendMessage(CommandSourceStack source, String message)
    {
        //PlayerChatMessage chatMessage = PlayerChatMessage.unsigned(receiver.getUUID(), message);
        //receiver.createCommandSourceStack().sendChatMessage(new OutgoingChatMessage.Player(chatMessage), false, ChatType.bind(ChatType.CHAT, sender));
        MutableComponent messageComp = Component.literal(message);
        source.sendSuccess(()-> messageComp, false);
    }
}
