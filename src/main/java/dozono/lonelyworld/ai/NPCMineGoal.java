package dozono.lonelyworld.ai;

import dozono.lonelyworld.Entity.FriendEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import java.util.List;

public class NPCMineGoal extends Goal {
    private FriendEntity friend;
    private List<Block> targetBlocks;


    public NPCMineGoal(FriendEntity entity, List<Block> targetBlocks) {
        this.friend = entity;
        this.targetBlocks = targetBlocks;
    }



    @Override
    public boolean canUse() {
        if (friend.getFriendEntityStatus().mood < 50) {
            return false;
        }
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    public Vector3d[] blocksNearby(FriendEntity friend){

        Vector3d[] postions ={} ;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j <3 ; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        postions[i].add(j,k,l);
                    }

                }
            }
        }



        return postions;
    }
    @Override
    public void tick() {
        while(friend.getFriendEntityStatus().stamina>=30){

        }
        super.tick();
    }
}
