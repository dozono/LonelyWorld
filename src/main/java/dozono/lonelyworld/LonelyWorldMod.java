package dozono.lonelyworld;

import dozono.lonelyworld.Entity.FriendEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(LonelyWorldMod.MODID)
public class LonelyWorldMod {
    public static final String MODID = "lonelyworld";

    private static final DeferredRegister<EntityType<?>> ENTITY_REG = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static final RegistryObject<EntityType<FriendEntity>> FRIEND = ENTITY_REG.register("friend",
            () -> EntityType.Builder.<FriendEntity>of(FriendEntity::new, EntityClassification.CREATURE)
                    .sized(1f, 3f)
                    .clientTrackingRange(10)
                    .build("friend"));


    public LonelyWorldMod(){
        ENTITY_REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
