package dozono.lonelyworld;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(LonelyWorldMod.MODID)
public class LonelyWorldMod {
    public static final String MODID = "lonelyworld";

    private static final DeferredRegister<EntityType<?>> ENTITY_REG = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static final RegistryObject<EntityType<?>> FRIEND = ENTITY_REG.register("noob",
            () -> EntityType.Builder.<FriendEntity>of(FriendEntity::new, EntityClassification.CREATURE)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build("noob"));


}
