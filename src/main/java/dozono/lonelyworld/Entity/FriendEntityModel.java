package dozono.lonelyworld.Entity;

// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FriendEntityModel<T extends FriendEntity> extends EntityModel<Entity> {
    private final ModelRenderer arms;
    private final ModelRenderer legs;
    private final ModelRenderer bb_main;

    public FriendEntityModel() {
        texWidth = 64;
        texHeight = 64;

        arms = new ModelRenderer(this);
        arms.setPos(0.0F, 24.0F, 0.0F);
        arms.texOffs(16, 0).addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        arms.texOffs(16, 0).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        legs = new ModelRenderer(this);
        legs.setPos(0.0F, 24.0F, 0.0F);
        legs.texOffs(0, 0).addBox(-4.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        legs.texOffs(0, 0).addBox(0.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);
        bb_main.texOffs(32, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        bb_main.texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        arms.render(matrixStack, buffer, packedLight, packedOverlay);
        legs.render(matrixStack, buffer, packedLight, packedOverlay);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}