package chronosacaria.mobsummoning.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

public class SummonMobCommand implements CommandRegistrationCallback {
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        dispatcher.register(mobsummon);
    }

    static LiteralArgumentBuilder<ServerCommandSource> mobsummon = CommandManager
            .literal("mob_summon")
            .requires(source -> source.getEntity() instanceof ServerPlayerEntity && source.getEntity().hasPermissionLevel(2))
            .then(CommandManager
                    .argument("summonedMob", IdentifierArgumentType.identifier())
                    .suggests((context, builder) -> {
                        return CommandSource.suggestIdentifiers(Registry.ENTITY_TYPE.getIds(), builder);
                    })
                    .executes(source -> {
                        ServerPlayerEntity player = source.getSource().getPlayer();
                        CompoundTag tag = new CompoundTag();
                        UUID playerUUID = player.getUuid();
                        Identifier summonedMob = source.getArgument("summonedMob", Identifier.class);

                        EntityType<?> type = Registry.ENTITY_TYPE.get(summonedMob);
                        Entity sender = source.getSource().getEntity();

                        Entity summon = type.create(sender.world);

                        summon.refreshPositionAndAngles(sender.getX(), sender.getY(), sender.getZ(), sender.getYaw(0),sender.getPitch(0));
                        sender.world.spawnEntity(summon);
                        return 1;

                    }));

}
