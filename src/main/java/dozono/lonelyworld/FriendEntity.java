package dozono.lonelyworld;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class FriendEntity extends AgeableEntity {
    private NPCStats stats;

    public FriendEntity(EntityType<? extends AgeableEntity> p_i48581_1_, World p_i48581_2_) {
        this(p_i48581_1_, p_i48581_2_, ImmutableList.of());
    }

    public FriendEntity(EntityType<? extends AgeableEntity> p_i48581_1_, World p_i48581_2_, List<Item> favor) {
        super(p_i48581_1_, p_i48581_2_);
        stats = new NPCStats(favor);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
