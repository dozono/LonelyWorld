package dozono.lonelyworld.ai;

import dozono.lonelyworld.FriendEntity;
import dozono.lonelyworld.NPCStats;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;

public class NPCMineGoal extends Goal {
    private FriendEntity friend;
    private List<Block> targetBlocks;

    public NPCMineGoal(FriendEntity friend, List<Block> targetBlocks) {
        this.friend = friend;
        this.targetBlocks = targetBlocks;
    }

    @Override
    public boolean canUse() {
        return false;
    }
}
