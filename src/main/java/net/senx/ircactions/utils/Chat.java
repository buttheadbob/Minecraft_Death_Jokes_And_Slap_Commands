package net.senx.ircactions.utils;

import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
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
            PlayerChatMessage chatMessage = PlayerChatMessage.unsigned(player.getUUID(), message);
            player.createCommandSourceStack().sendChatMessage(new OutgoingChatMessage.Player(chatMessage), false, ChatType.bind(ChatType.CHAT, sender));
        }
    }

    public static void SendMessage(ServerPlayer sender, ServerPlayer receiver, String message)
    {
        PlayerChatMessage chatMessage = PlayerChatMessage.unsigned(receiver.getUUID(), message);
        receiver.createCommandSourceStack().sendChatMessage(new OutgoingChatMessage.Player(chatMessage), false, ChatType.bind(ChatType.CHAT, sender));
    }
}
