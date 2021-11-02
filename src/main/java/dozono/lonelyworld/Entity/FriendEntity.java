package dozono.lonelyworld.Entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class FriendEntity extends AgeableEntity {
    private final FriendEntityStatus stats;

    private UUID hostUUID;
    private PlayerEntity host;


    public static AttributeModifierMap.MutableAttribute setAttributes(){
        return FriendEntity.setAttributes().add(Attributes.ARMOR,20).add(Attributes.MAX_HEALTH,40);
    }

    //all goals register here
    protected void registerGoals(FriendEntity friend){
        friend.goalSelector.addGoal(1,new NearestAttackableTargetGoal<>(this,PlayerEntity.class,true));


    }


    //DeathSound HurtSound StepSound
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;
    }

    public FriendEntity(EntityType<? extends AgeableEntity> p_i48581_1_, World p_i48581_2_) {
        this(p_i48581_1_, p_i48581_2_, ImmutableList.of());
    }

    public FriendEntity(EntityType<? extends AgeableEntity> p_i48581_1_, World p_i48581_2_, List<Item> favor) {
        super(p_i48581_1_, p_i48581_2_);
        stats = new FriendEntityStatus(favor);
    }

    //set the host of the friendEntity.basically whoever got to him first
    public void setHost(@Nonnull PlayerEntity host) {
        this.host = host;
        this.hostUUID = host.getUUID();
    }

    @Nullable
    public PlayerEntity getHost() {
        if (this.host == null && this.hostUUID != null) {
            host = this.level.getPlayerByUUID(this.hostUUID);
        }
        return host;
    }

    public FriendEntityStatus getFriendEntityStatus() {
        return stats;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = super.serializeNBT();
        nbt.put("stat", stats.serializeNBT());
        if (hostUUID != null) {
            nbt.put("friend", NBTUtil.createUUID(hostUUID));
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.stats.deserializeNBT(nbt.getCompound("stat"));
        INBT friend = nbt.get("friend");
        if (friend != null) {
            this.hostUUID = NBTUtil.loadUUID(friend);
        }
        super.deserializeNBT(nbt);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
