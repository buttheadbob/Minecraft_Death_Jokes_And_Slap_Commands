package net.senx.ircactions.fakeplayers;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.fml.LogicalSide;

import java.util.UUID;

public class DadJokes
{
    public static ServerPlayer Player;

    public static void register(MinecraftServer server)
    {
        if (LogicalSidedProvider.WORKQUEUE.get(LogicalSide.SERVER).isSameThread())
        {
            UUID uuid = UUID.nameUUIDFromBytes(("FakePlayer:" + "DadJokes").getBytes());
            ServerLevel world = server.overworld();
            ServerPlayer fakePlayer = (ServerPlayer) world.getPlayerByUUID(uuid);
            if (fakePlayer == null)
            {
                Player = createFakePlayer(server, "DadJokes");
            }
            if (fakePlayer instanceof FakePlayer)
            {
                Player = fakePlayer;
            }
        }
    }

    public static FakePlayer createFakePlayer(MinecraftServer server, String name) {
        ServerLevel world = server.overworld();
        GameProfile fakePlayerProfile = new GameProfile(UUID.randomUUID(), name);
        return FakePlayerFactory.get(world, fakePlayerProfile);
    }
}
