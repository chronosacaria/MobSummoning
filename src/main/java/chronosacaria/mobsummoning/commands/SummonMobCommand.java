package chronosacaria.mobsummoning.commands;

import chronosacaria.mobsummoning.entities.SummonedEntity;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

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
                    .then(CommandManager
                            .argument("position", Vec3ArgumentType.vec3())
                                    .executes(source -> {
                                        Identifier summonedMob = source.getArgument("summonedMob", Identifier.class);
                                        Vec3d pos = Vec3ArgumentType.getPosArgument(source, "position").toAbsolutePos(source.getSource());

                                        EntityType<?> type = Registry.ENTITY_TYPE.get(summonedMob);
                                        Entity sender = source.getSource().getEntity();

                                        SummonedEntity summon = (SummonedEntity) type.create(sender.world);
                                        summon.setSummonerUuid(source.getSource().getPlayer().getUuid());

                                        //summon.refreshPositionAndAngles(sender.getX(), sender.getY(), sender.getZ(),sender.getYaw(0),sender.getPitch(0));
                                        summon.refreshPositionAndAngles(pos.x, pos.y, pos.z,sender.getYaw(0),
                                                sender.getPitch(0));
                                        sender.world.spawnEntity(summon);
                                        return 1;

                                    })));

}
