package dozono.lonelyworld.Entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTTypes;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.stream.Collectors;

public class FriendEntityStatus implements INBTSerializable<CompoundNBT> {
    private List<Item> favouriteItems;
    //0-100
    public int mood;

    public int combatSkill;
    public int mineSkill;
    public int farmSkill;
    public int cutTreeSkill;
    public int stamina = 100;

    public FriendEntityStatus(List<Item> favouriteItems) {
        this.favouriteItems = favouriteItems;
    }

    public List<Item> getFavouriteItems() {
        return favouriteItems;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("mood", mood);
        nbt.putInt("combatSkill", combatSkill);
        nbt.putInt("mineSkill", mineSkill);
        nbt.putInt("farmSkill", farmSkill);
        nbt.putInt("cutTreeSkill", cutTreeSkill);
        ListNBT listNBT = new ListNBT();
        favouriteItems.stream().map(v -> v.getRegistryName().toString()).forEach((s) -> {
            listNBT.add(StringNBT.valueOf(s));
        });
        nbt.put("favor", listNBT);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        combatSkill = nbt.getInt("combatSkill");
        mineSkill = nbt.getInt("mineSkill");
        farmSkill = nbt.getInt("farmSkill");
        cutTreeSkill = nbt.getInt("cutTreeSkill");
        mood = nbt.getInt("mood");

        this.favouriteItems = nbt.getList("favor", 8)
                .stream()
                .map(f -> new ResourceLocation(f.getAsString())).map(ForgeRegistries.ITEMS::getValue)
                .collect(Collectors.toList());
    }
}
